package Array;

import java.util.Arrays;

/* When we use copy the value of an array to a new array both are referring
to the same memory address, therefore changing one value will also change
other array's value.

We can also copy the array with various functions/methods to create new array.
*/

public class ArrayDemo2 {

    static void printArray(int a[]) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static void referenceArray() {

        int arr[] = { 1, 2, 3, 4, 5 };
        int arr_2[] = arr;
        arr_2[2] = 4;
        printArray(arr_2);
        printArray(arr);
    }

    static void copyingArray() {

        int arr[] = { 1, 2, 3, 4, 5 };
        int arr_2[] = Arrays.copyOf(arr, 4);

        // It is also called Deep Copy.
        int arr_1[] = arr.clone();

        // 2 is excluded from the new array
        int arr_3[] = Arrays.copyOfRange(arr, 0, 2);

        printArray(arr_3);
        printArray(arr_2);
        printArray(arr_1);
        printArray(arr);
    }

    public static void main(String[] args) {
        referenceArray();
        copyingArray();
    }
}
