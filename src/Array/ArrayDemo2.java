package Array;

import java.util.Arrays;

/*
 * When we use copy the value of an array to a new array both are referring to the same memory address, therefore changing one value will also change other array's value.
 * We can also copy the array with various functions/methods to create new array.
 */
public class ArrayDemo2 {

    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static void copyingArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] copyArray = Arrays.copyOf(arr, 4);

        // It is also called Deep Copy.
        int[] cloneArray = arr.clone();

        // 2 is excluded from the new Array.
        int[] modifiedArray = Arrays.copyOfRange(arr, 0, 2);

        printArray(modifiedArray);
        printArray(cloneArray);
        printArray(copyArray);
    }

    public static void main(String[] args) {
        copyingArray();
    }
}
