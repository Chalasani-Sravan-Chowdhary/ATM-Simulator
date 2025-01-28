import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private String accountantName;
    private int accountNumber;
    private String pin;
    private double accountBalance;

    public Account(String accountantName, int accountNumber, String pin, double accountBalance) {
        this.accountantName = accountantName;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.accountBalance = accountBalance;
    }

    public String getAccountantName() {
        return accountantName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}

public class ATM {
    private Map<Integer, Account> accounts;
    private Scanner scanner;

    public ATM() {
        accounts = new HashMap<>();
        scanner = new Scanner(System.in);

        // Creating accounts
        accounts.put(56743, new Account("Ramu", 56743, "56743", 100330.0));
        accounts.put(53785, new Account("Rajesh", 53785, "53785", 50860.0));
        accounts.put(53725, new Account("Rakesh", 53725, "53725", 30860.0));
        accounts.put(56785, new Account("Ramesh", 56785, "56785", 55660.0));
    }

    public void run() {
        System.out.println("Welcome to the ATM simulator!");

        while (true) {
            System.out.print("Enter your account number: ");
            int accountNumber = scanner.nextInt();

            if (!accounts.containsKey(accountNumber)) {
                System.out.println("Invalid account number. Please try again.");
                continue;
            }

            Account account = accounts.get(accountNumber);

            System.out.print("Enter your PIN: ");
            String pin = scanner.next();

            if (!account.getPin().equals(pin)) {
                System.out.println("Invalid PIN. Please try again.");
                continue;
            }

            while (true) {
                System.out.println("1. Check balance");
                System.out.println("2. Withdraw cash");
                System.out.println("3. Deposit cash");
                System.out.println("4. Exit");

                System.out.print("Choose an option: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Your balance is: " + account.getAccountBalance());
                        break;
                    case 2:
                        System.out.print("Enter the amount to withdraw: ");
                        double amount = scanner.nextDouble();

                        if (amount > account.getAccountBalance()) {
                            System.out.println("Insufficient funds. Please try again.");
                        } else {
                            account.setAccountBalance(account.getAccountBalance() - amount);
                            System.out.println("Withdrawal successful. Your new balance is: " + account.getAccountBalance());
                        }
                        break;
                    case 3:
                        System.out.print("Enter the amount to deposit: ");
                        amount = scanner.nextDouble();

                        account.setAccountBalance(account.getAccountBalance() + amount);
                        System.out.println("Deposit successful. Your new balance is: " + account.getAccountBalance());
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM simulator!");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
