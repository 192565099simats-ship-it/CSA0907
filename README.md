# CSA09 Programming in Java – Assignment 2 (CO2)

Student: S. Malavika  
Register Number: 192565099
Submission Date: 13/11/2026
GitHub Repository: https://github.com/192565099simats-ship-it/CSA0907  
Java version: Java 17 or later (Task04 uses Stream.toList())  

## Repository structure
- Task01: String, StringBuilder and StringBuffer benchmark
- Task02: ArrayList, LinkedList and ArrayDeque comparison
- Task03: hashCode–equals contract and HashSet
- Task04: HashMap, TreeMap and LinkedHashMap
- Task05: Generics and Comparator-based leaderboard
- Task06: PriorityQueue-based hospital triage
- Task07: Inventory redesign and validation

## Compile and run
Open a terminal in the task folder and run:
```bash
javac Task01.java
java Task01
```
Replace `Task01` with the corresponding class name for each folder. Each task is independent.

## Important experimental note
Benchmark output depends on CPU, JVM, warm-up, garbage collection and background load. Run each benchmark several times (at least 5), record the average and use the same machine and conditions for comparisons. Do not present sample or single-run timings as universal facts. The report contains complexity-based predictions and places to record your actual measurements.

## Results summary
- Q1: String is immutable; repeated concatenation can copy growing prefixes. StringBuilder is preferred for local ticket construction; StringBuffer is synchronized and suitable only when shared mutable access is genuinely required.
- Q2: ArrayList is strong for indexed reads and iteration; LinkedList has constant-time end operations but indexed access is linear; ArrayDeque is suitable for double-ended queues.
- Q3: equals and hashCode must agree. Equal objects must have equal hash codes. Immutable identity fields protect hash-based membership.
- Q4: HashMap provides average constant-time lookup; TreeMap keeps sorted keys; LinkedHashMap preserves insertion order.
- Q5: A comparator chain provides reusable multi-field ordering; Leaderboard returns a sorted copy.
- Q6: PriorityQueue orders by severity and arrival sequence; copy and poll to display treatment order.
- Q7: HashMap supports lookup and TreeMap maintains code order, avoiding repeated full-list sorting for each report.

## Submission checklist
1. Execute every program locally.
2. Save terminal output screenshots in the matching Task folder.
3. Add raw benchmark measurements and repeated-run averages to the report.
4. Commit progressively, at least one commit per task.
5. Create the GitHub repository named `CSA09-192565099-Assignment2` and submit its URL in the report.
