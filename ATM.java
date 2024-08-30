import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        final int PIN = 1234; // Set your 4-digit PIN here
        int attempts = 0;
        boolean accessGranted = false;
        double balance = 1000.00; // Initial balance
        Scanner scanner = new Scanner(System.in);

        // PIN validation
        while (attempts < 3) {
            System.out.print("Enter your 4-digit PIN: ");
            int inputPin = scanner.nextInt();

            if (inputPin == PIN) {
                accessGranted = true;
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (3 - attempts));
            }
        }

        // Main menu
        if (accessGranted) {
            int choice;
            do {
                System.out.println("\nATM Main Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1: // Check balance
                        System.out.println("Your current balance is: $" + balance);
                        break;

                    case 2: // Deposit money
                        System.out.print("Enter amount to deposit: $");
                        double depositAmount = scanner.nextDouble();
                        if (depositAmount > 0) {
                            balance += depositAmount;
                            System.out.println("You've successfully deposited $" + depositAmount);
                        } else {
                            System.out.println("Invalid deposit amount.");
                        }
                        break;

                    case 3: // Withdraw money
                        System.out.print("Enter amount to withdraw: $");
                        double withdrawAmount = scanner.nextDouble();
                        if (withdrawAmount > 0 && withdrawAmount <= balance) {
                            balance -= withdrawAmount;
                            System.out.println("You've successfully withdrawn $" + withdrawAmount);
                        } else if (withdrawAmount > balance) {
                            System.out.println("Insufficient balance.");
                        } else {
                            System.out.println("Invalid withdrawal amount.");
                        }
                        break;

                    case 4: // Exit
                        System.out.println("Exiting... Thank you for using our ATM.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 4); // Exit loop when the user chooses to exit
        } else {
            System.out.println("Maximum attempts reached. Exiting...");
        }

        scanner.close();
    }
}
