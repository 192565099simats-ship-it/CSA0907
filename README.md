# CSA0907 – Assignment 3 (CO3)

**Student:** S. Malavika  
**Register Number:** 192565099  
**Student Role:** Student A  
**Course:** Programming in Java  
**GitHub:** https://github.com/192565099simats-ship-it/CSA0907

## Requirements
- JDK 17 or later (the examples use modern Java APIs such as `Files.writeString`).
- Terminal / command prompt.

## Folder structure
- `Task01/ATM.java` – ATM validation and exception handling
- `Task02/StorageDemo.java` – custom checked exception and exception chaining
- `Task03/ReportGenerator.java` – safe file handling using try-with-resources
- `Task04/ScannerStations.java` – thread creation, start and join
- `Task05/SeatBooking.java` – synchronized seat booking
- `Task06/TokenCounter.java` – bounded producer-consumer buffer
- `Task07/ResultProcessor.java` – ExecutorService, Callable, Future and concurrent results

## Compile and run
Open a terminal in the relevant task folder and run:
```bash
javac FileName.java
java ClassName
```
For example:
```bash
cd Task02
javac StorageDemo.java
java StorageDemo
```
For `ATM`, enter an account number, balance and withdrawal amount when prompted.

## Expected checks
- Task 02 prints `Saved answer01.pdf`, then the wrapped storage error and its original cause.
- Task 05 prints `Seats sold: 10`.
- Task 06 prints `Sum of tokens collected: 210 (expected 210)`.
- Task 07 deliberately includes valid, corrupt and missing score files and reports each outcome without terminating the whole batch.

## Submission note
Run every program on your own computer, capture genuine output screenshots, and add them to the corresponding task folder. Commit progressively (at least one commit per task), as required by the assignment. This ZIP is a starter submission package; it does not claim that screenshots or measured timing results were produced on your machine.
