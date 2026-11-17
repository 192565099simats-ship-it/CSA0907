import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ReportGenerator {
    static void generate(List<Path> inputs, Path output) throws IOException {
        // try-with-resources closes the writer even if a read/write fails.
        try (BufferedWriter writer = Files.newBufferedWriter(output)) {
            for (Path input : inputs) {
                try (BufferedReader reader = Files.newBufferedReader(input)) {
                    String line;
                    while ((line = reader.readLine()) != null) writer.write(line + System.lineSeparator());
                } catch (IOException e) {
                    System.err.println("Failed while processing " + input + ": " + e.getMessage());
                    throw e;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("input");
        Files.createDirectories(dir);
        Path store1 = dir.resolve("store1.txt");
        Path store2 = dir.resolve("store2.txt");
        Files.writeString(store1, "Store 1 sales: 1200\n");
        Files.writeString(store2, "Store 2 sales: 950\n");
        generate(List.of(store1, store2), Paths.get("daily-report.txt"));
        System.out.println(Files.readString(Paths.get("daily-report.txt")));
    }
}
