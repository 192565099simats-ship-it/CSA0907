import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

public class ResultProcessor {
    static class Result {
        final String file;
        final boolean success;
        final String message;
        Result(String file, boolean success, String message) {
            this.file = file; this.success = success; this.message = message;
        }
    }
    static Callable<Result> task(Path file) {
        return () -> {
            try {
                String raw = Files.readString(file).trim();
                if (raw.isEmpty()) throw new IllegalArgumentException("Empty score file");
                int score = Integer.parseInt(raw);
                if (score < 0 || score > 100) throw new IllegalArgumentException("Score outside 0-100");
                return new Result(file.toString(), true, "Validated score=" + score);
            } catch (IOException | IllegalArgumentException e) {
                return new Result(file.toString(), false, e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        };
    }
    public static void main(String[] args) throws Exception {
        Path dir = Paths.get("scores");
        Files.createDirectories(dir);
        Files.writeString(dir.resolve("student1.txt"), "85");
        Files.writeString(dir.resolve("student2.txt"), "91");
        Files.writeString(dir.resolve("student3.txt"), "corrupt");
        // student4.txt is deliberately missing.
        List<Path> input = List.of(dir.resolve("student1.txt"), dir.resolve("student2.txt"),
                dir.resolve("student3.txt"), dir.resolve("student4.txt"));

        for (int poolSize : new int[]{1, 2, 4, 8}) {
            ExecutorService pool = Executors.newFixedThreadPool(poolSize);
            ConcurrentLinkedQueue<Result> results = new ConcurrentLinkedQueue<>();
            long start = System.nanoTime();
            try {
                List<Future<Result>> futures = new ArrayList<>();
                for (Path p : input) futures.add(pool.submit(task(p)));
                for (Future<Result> f : futures) results.add(f.get());
            } finally {
                pool.shutdown();
                pool.awaitTermination(1, TimeUnit.MINUTES);
            }
            long elapsedMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
            long success = results.stream().filter(r -> r.success).count();
            long failure = results.size() - success;
            System.out.println("Pool=" + poolSize + ", success=" + success +
                    ", failure=" + failure + ", timeMs=" + elapsedMs);
            for (Result r : results) System.out.println(r.file + " -> " + r.message);
        }
    }
}
