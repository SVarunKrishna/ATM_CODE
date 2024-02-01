import java.util.Scanner;

public class Withdrawal {
    public static void withdraw(User user, TransactionHistory history) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        // Check if the withdrawal amount is valid
        if (amount > 0) {
            // Placeholder logic: Deduct the amount from the user's account balance
            double currentBalance = user.getBalance();
            if (amount <= currentBalance) {
                currentBalance -= amount;
                user.setBalance(currentBalance);

                // Update transaction history
                String transaction = "Withdrawal: -$" + amount;
                history.addTransaction(transaction);
                System.out.println("Withdrawal successful. New balance: $" + currentBalance);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}
