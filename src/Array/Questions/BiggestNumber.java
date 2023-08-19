package Array.Questions;

import java.util.ArrayList;
import java.util.Vector;

@SuppressWarnings("ComparatorMethodParameterNotUsed")
public class BiggestNumber {

    /**
     * Method for Numbers which are Larger than 10^18.
     * */
    static void printLargestLong(Vector<String> arr) {
        arr.sort((X, Y) -> {
            String XY = X + Y;
            String YX = Y + X;
            return XY.compareTo(YX) > 0 ? -1 : 1;
        });

        for (String s : arr) System.out.print(s);
    }

    /**
     * Method for Integer Array.
     * */
    static void printLargest(ArrayList<Integer> arr) {
        arr.sort((x, y) -> {
            int xy = x;
            int yx = y;

            int lengthX = 0;
            int lengthY = 0;

            while (x > 0) {
                lengthX++;
                x /= 10;
            }
            while (y > 0) {
                lengthY++;
                y /= 10;
            }

            x = xy;
            y = yx;

            while (lengthX > 0) {
                lengthX--;
                yx *= 10;
            }
            while (lengthY > 0) {
                lengthY--;
                xy *= 10;
            }

            // Append x to y
            yx += x;
            // Append y to x
            xy += y;

            return -xy + yx;
        });

        for (Integer integer : arr) System.out.print(integer);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(54);
        arr.add(546);
        arr.add(548);
        arr.add(60);
        printLargest(arr);

        Vector<String> vector = new Vector<>();
        vector.add("54");
        vector.add("546");
        vector.add("548");
        vector.add("60");
        printLargestLong(vector);
    }
}
