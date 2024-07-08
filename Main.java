import java.util.Scanner;

class ATM {
    int PIN = 3456;
    float balance;

    public void checkpin() {
        System.out.println("Enter your pin: ");
        Scanner sc = new Scanner(System.in);
        int enteredpin = sc.nextInt();

        if (enteredpin == PIN) {
            menu();
        }
        else {
            System.out.println(" Please enter a valid PIN.");
            checkpin();
        }
    }

    public void menu() {
        System.out.println("Choose an option below:");
        System.out.println("1. Check balance");
        System.out.println("2. Money deposit");
        System.out.println("3. Amount withdraw");
        System.out.println("4. Exit");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();

        if (opt == 1) {
            checkbalance();
        }
        else if (opt == 2) {
            moneydeposit();
        }
        else if (opt == 3) {
            amountwithdraw();
        }
        else if (opt == 4) {
            return;
        }
        else {
            System.out.println("Please choose a correct option.");
            menu();
        }
    }

    public void checkbalance() {
        System.out.println("Balance: " + balance);
        menu();
    }

    public void moneydeposit() {
        System.out.println("Enter your amount:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        balance = balance + amount;
        System.out.println("Money deposited successfully.");
        menu();
    }

    public void amountwithdraw() {
        System.out.println("Enter the amount:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("Your balance is insufficient.");
        } else {
            balance = balance - amount;
            System.out.println("Money withdraw successfully.");
        }
        menu();
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.checkpin();
    }
}
