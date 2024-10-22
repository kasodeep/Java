package Interview.execptions;

/**
 * To catch or propagate exception depends on the use case.
 * Majorly, We take the error up the call stack and handle at the service or controller.
 */
public class TryCatch {

    public int divide(int numberToDivide, int numberToBeDividedBy) throws ArithmeticException {
        if (numberToBeDividedBy == 0) {
            throw new ArithmeticException("Cannot divide by 0!");
        }
        return numberToDivide / numberToBeDividedBy;
    }

    public void callDivide() {
        try {
            int result = divide(2, 1);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Division attempt done");
    }
}
