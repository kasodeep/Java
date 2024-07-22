package Interview;

import java.util.function.Predicate;

/**
 * There are some predefined functional interface in Java like Predicate, Consumer, Supplier etc.
 * The return type of Lambda function (introduced in JDK 1.8) is an also functional interface.
 */
public class PredicateExample {

    public static void main(String[] args) {
        Predicate<Integer> isEven = number -> number % 2 == 0;

        Predicate<Integer> isPrime = num -> {
            if (num <= 1) return false;
            for (int i = 2; i < Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        };

        Predicate<Integer> isEvenAndPrime = isEven.and(isPrime);

        System.out.println("Testing: " + isEvenAndPrime.test(2));
    }
}
