package Interview;

import java.text.NumberFormat;

public class Money {

    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(12300.500);
        System.out.println(result);
    }
}
