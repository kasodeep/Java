package Interview.memory;

/**
 * javac JITDemo.java
 * <p>
 * java -server \
 * -XX:+UnlockDiagnosticVMOptions \
 * -XX:+PrintCompilation \
 * -XX:+PrintInlining \
 * JITDemo
 */
public class JITDemo {

    public static void main(String[] args) {

        long sum = 0;

        for (int i = 0; i < 1_000_000; i++) {
            sum += compute(i);
        }

        System.out.println("Sum: " + sum);
    }

    public static int compute(int x) {
        return x * 2;
    }
}
