import java.util.Scanner;

public class ATM1 {
    private BankAccount account;
    private Scanner sc;

    public ATM1(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); 
        ATM1 atm = new ATM1(account);
        atm.displayMenu();
    }
}
