package Interview;

@FunctionalInterface
interface MathOperation {
    double operate(double a, double b);
}

public class FunctionalInterfaceExample {

    public static void main(String[] args) {
        MathOperation addition = Double::sum;
        MathOperation subtraction = (a, b) -> a - b;

        System.out.println(addition.operate(10, 20));
        System.out.println(subtraction.operate(20, 10));
    }
}
