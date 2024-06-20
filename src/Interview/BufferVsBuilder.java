package Interview;

public class BufferVsBuilder {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Deep");
        System.out.println(sb.capacity()); // It gives me 16 extra space, continuous memory location.
        sb.append(10D);

        /*
         * StringBuffer is thread safe (synchronized), and StringBuilder is not thread safe.
         * */

        String s1 = "Hello"; // Gets created in the String Pool.
        String s2 = s1.concat(""); // Gets created in the Heap Memory.
        String s3 = s2.intern(); // Looks into String Pool first.

        System.out.println(s2.equals(s3));
        System.out.println(s1.equals(s3));

        StringBuilder shared = new StringBuilder();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                shared.append("A");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                shared.append("B");
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(shared.length());
    }
}
