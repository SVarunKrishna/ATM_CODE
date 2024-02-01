import java.util.Scanner;

public class ATM {
    private User currentUser;
    private TransactionHistory transactionHistory;

    public ATM(User currentUser) {
        this.currentUser = currentUser;
        this.transactionHistory = new TransactionHistory();
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    transactionHistory.displayTransactions();
                    break;
                case 2:
                    Withdrawal.withdraw(currentUser, transactionHistory);
                    break;
                case 3:
                    Deposit.deposit(currentUser, transactionHistory);
                    break;
                case 4:
                    Transfer.transfer(currentUser, transactionHistory);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        User user = new User(userId, pin, initialBalance);
        ATM atm = new ATM(user);
        atm.displayMenu();
    }
}
