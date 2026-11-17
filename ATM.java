import java.util.Scanner;

public class ATM {
    static class InsufficientBalanceException extends Exception {
        InsufficientBalanceException(String message) { super(message); }
    }

    static void withdraw(double balance, double amount)
            throws InsufficientBalanceException {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        if (amount > balance) throw new InsufficientBalanceException("Insufficient balance");
        System.out.printf("Withdrawal successful. Remaining balance: %.2f%n", balance - amount);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter account number: ");
            String account = sc.nextLine();
            if (account.isBlank()) throw new IllegalArgumentException("Account number is required");
            System.out.print("Enter balance: ");
            double balance = Double.parseDouble(sc.nextLine());
            System.out.print("Enter withdrawal amount: ");
            double amount = Double.parseDouble(sc.nextLine());
            withdraw(balance, amount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: enter numeric values.");
        } catch (InsufficientBalanceException e) {
            System.out.println("Transaction declined: " + e.getMessage());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Invalid transaction: " + e.getMessage());
        } finally {
            System.out.println("ATM session closed.");
        }
    }
}
