import java.util.Scanner;

public class Transfer {
    public static void transfer(User user, TransactionHistory history) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter recipient's user ID: ");
        String recipientId = scanner.nextLine();

        System.out.print("Enter transfer amount: ");
        double amount = scanner.nextDouble();

        // Check if the transfer amount is valid
        if (amount > 0) {
            // Placeholder logic: Deduct the amount from the user's account balance
            // and update the recipient's balance
            double currentBalance = user.getBalance();
            if (amount <= currentBalance) {
                currentBalance -= amount;
                user.setBalance(currentBalance);

                // Placeholder logic for recipient's balance (assuming a second user for simplicity)
                User recipient = new User(recipientId, "0000", 0);  // Placeholder recipient user
                double recipientBalance = recipient.getBalance();
                recipientBalance += amount;
                recipient.setBalance(recipientBalance);

                // Update transaction history
                String transaction = "Transfer to " + recipientId + ": -$" + amount;
                history.addTransaction(transaction);
                System.out.println("Transfer successful. New balance: $" + currentBalance);
            } else {
                System.out.println("Insufficient funds for transfer.");
            }
        } else {
            System.out.println("Invalid transfer amount.");
        }
    }
}
