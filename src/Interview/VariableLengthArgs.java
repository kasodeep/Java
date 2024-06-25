package Interview;

public class VariableLengthArgs {

    static int balance;

    public static void main(String[] args) {
        balance = 0;
        // Each method can have only one variable length args.
        // It should also be the last argument.
        deposit(10, 20, 30);
    }

    public static void deposit(int amount) {
        balance += amount;
        System.out.println("Amount Deposited");
    }

    public static void deposit(int... amount) {
        for (int num : amount) {
            balance += num;
        }
        System.out.println("New Balance: " + balance);
    }
}
