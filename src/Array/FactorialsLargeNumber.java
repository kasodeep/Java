package Array;

import java.util.ArrayList;
import java.util.Collections;

public class FactorialsLargeNumber {

    static ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i <= n; i++) {
            int carry = 0;
            for (int j = 0; j < list.size(); j++) {
                int result = (list.get(j) * i) + carry;
                carry = result / 10;
                list.set(j, result % 10);
            }

            while (carry != 0) {
                list.add(carry % 10);
                carry /= 10;
            }
        }

        Collections.reverse(list);
        return list;
    }
}
