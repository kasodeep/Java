package Interview;

public class DeadlockExample {

    private static final Object account = new Object();
    private static final Object transaction = new Object();

    public static void main(String[] args) {
        Thread debitCard = new Thread(() -> {
            synchronized (account) {
                System.out.println("Thread debitCard: " + "Holding account object");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread debitCard: " + "Trying to acquire transaction");
                synchronized (transaction) {
                    System.out.println("Thread debitCard: " + "Holding account and transaction");
                }
            }
        });
        debitCard.setName("Debit Card Thread");

        Thread onlinePayment = new Thread(() -> {
            synchronized (transaction) {
                System.out.println("Thread onlinePayment: " + "Holding transaction object");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread onlinePayment: " + "Trying to acquire account");
                synchronized (account) {
                    System.out.println("Thread onlinePayment: " + "Holding account and transaction");
                }
            }
        });
        onlinePayment.setName("Online Payment Thread");

        debitCard.start();
        onlinePayment.start();

        while (true) {
            if (debitCard.getState() == Thread.State.BLOCKED && onlinePayment.getState() == Thread.State.BLOCKED) {
                System.out.println("Deadlocked Threads: " + debitCard.getName() + onlinePayment.getName());
                break;
            }
        }
    }
}
