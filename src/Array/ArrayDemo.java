package Array;

/*
    Array have 0 based indexing.
    They have contiugous memory allocation.
    They can multi-dimensional.
    Arrays are stored in Heap Memory and the address of the first variable is stored in Stack Memory.
 */

public class ArrayDemo {

    static void oneDimensional() {

        int ages[] = new int[4];
        System.out.println(ages.length);

        // Array Literal
        String names[] = { "Suresh", "Ramesh", "Kajol", "Ravi" };
        for (String name : names) {
            System.out.println(name);
        }
    }

    static void multiDimensional() {

        int nums[][] = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }
    }

    static void peakElement() {

        int arr[] = { 1, 1, 3, 4, 2, 3, 5, 7, 0 };
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
    }
}
