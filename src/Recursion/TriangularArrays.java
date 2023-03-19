package Recursion;

public class TriangularArrays {

    // Utility Function to Print Array
    static void printArray(int arr[]) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 
     * @param arr  - It is the array which needs to be modified
     * @param temp - It is the temp array which has prefix sum of 'arr'
     */
    static void createArray(int[] arr, int[] temp) {

        for (int i = 0; i < arr.length - 1; i++) {
            temp[i] = arr[i] + arr[i + 1];
        }
    }

    /**
     * 
     * @param arr - It is the array which needs to be printe
     */
    static void printTriangle(int[] arr) {

        // Base Case
        if (arr.length == 1) {
            printArray(arr);
            return;
        }

        int n = arr.length;
        int[] temp = new int[n - 1];
        createArray(arr, temp);

        // Recursion and Self-Work
        printTriangle(temp);
        printArray(arr);

    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5 };
        printTriangle(arr);
    }
}
