package Array;

/*
 * Array have 0 based indexing.
 * They have contiguous memory allocation.
 * They can be multidimensional.
 * Arrays are stored in Heap Memory and the address of the first variable is stored in Stack Memory.
 */

/*
 * Operations: Length of the Array.
 * Traversing: For each and For loop.
 *
 * */
public class ArrayDemo {

    static void oneDimensional() {

        int[] ages = new int[4];
        System.out.println(ages.length);

        // Array Literal.
        String[] names = {"Suresh", "Ramesh", "Kajol", "Ravi"};
        for (String name : names) {
            System.out.println(name);
        }
    }

    static void multiDimensional() {

        int[][] arr = {{1, 2}, {3, 4}, {5, 6}};
        for (int[] num : arr) {
            for (int i : num) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void peakElement() {

        int[] arr = {1, 1, 3, 4, 2, 3, 5, 7, 0};
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                System.out.println(arr[i]);
                break;
            }
        }
    }

    public static void main(String[] args) {
        oneDimensional();
        multiDimensional();
        peakElement();
    }
}
