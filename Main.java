import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Create Account (User Input)");
            System.out.println("2. Current Account (Predefined Single)");
            System.out.println("3. Double Accounts (Predefined Two)");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (option) {
                case 1: // Create Account
                    System.out.print("Enter Account Holder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Account Number: ");
                    String accNumber = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();

                    BankAccount userAccount = new BankAccount(accNumber, name, balance);
                    accountMenu(userAccount, scanner);
                    break;

                case 2: // Current account
                    BankAccount currentAccount = new BankAccount("6374652912", "Mr. Praveenkumar", 10000.0);
                    accountMenu(currentAccount, scanner);
                    break;

                case 3: // Double accounts
                    BankAccount account1 = new BankAccount("6374652912", "Mr. Praveenkumar", 50000.0);
                    BankAccount account2 = new BankAccount("6374652913", "Ms. Parvathi", 75000.0);

                    boolean chooseAcc = true;
                    while (chooseAcc) {
                        System.out.println("\n--- Select Account ---");
                        System.out.println("1. " + account1.getAccountHolder() + " (" + account1.getAccountNumber() + ")");
                        System.out.println("2. " + account2.getAccountHolder() + " (" + account2.getAccountNumber() + ")");
                        System.out.println("3. Transfer Money");
                        System.out.println("4. Back to Main Menu");
                        System.out.print("Choose an option: ");
                        int accChoice = scanner.nextInt();

                        if (accChoice == 1) {
                            accountMenu(account1, scanner);
                        } else if (accChoice == 2) {
                            accountMenu(account2, scanner);
                        } else if (accChoice == 3) {
                            System.out.println("\n--- Transfer Money ---");
                            System.out.println("1. " + account1.getAccountHolder() + " → " + account2.getAccountHolder());
                            System.out.println("2. " + account2.getAccountHolder() + " → " + account1.getAccountHolder());
                            System.out.print("Choose transfer direction: ");
                            int tChoice = scanner.nextInt();
                            System.out.print("Enter transfer amount: ");
                            double tAmount = scanner.nextDouble();

                            if (tChoice == 1) {
                                account1.transfer(account2, tAmount);
                            } else if (tChoice == 2) {
                                account2.transfer(account1, tAmount);
                            } else {
                                System.out.println("Invalid transfer option.");
                            }
                        } else if (accChoice == 4) {
                            chooseAcc = false; // back
                        } else {
                            System.out.println("Invalid choice. Try again.");
                        }
                    }
                    break;

                case 4: // Exit
                    running = false;
                    System.out.println("Exiting Banking System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    // Common account operations menu
    private static void accountMenu(BankAccount account, Scanner scanner) {
        boolean accountRunning = true;
        while (accountRunning) {
            System.out.println("\n--- Account Menu for " + account.getAccountHolder() + " ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    accountRunning = false; // back
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
