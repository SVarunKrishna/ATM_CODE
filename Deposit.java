import java.util.Scanner;

public class Deposit {
    public static void deposit(User user, TransactionHistory history) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        // Check if the deposit amount is valid
        if (amount > 0) {
            // Placeholder logic: Add the amount to the user's account balance
            double currentBalance = user.getBalance();
            currentBalance += amount;
            user.setBalance(currentBalance);

            // Update transaction history
            String transaction = "Deposit: +$" + amount;
            history.addTransaction(transaction);
            System.out.println("Deposit successful. New balance: $" + currentBalance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}
