package Recursion;

public class ArrayRecursion {

    static void printArray(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length)
            return;

        // Slef-Work
        System.out.println(arr[idx]);

        // Recursion
        printArray(arr, idx + 1);
    }

    static int maxInArray(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length - 1)
            return arr[idx];

        // Recursion
        int smallAns = maxInArray(arr, idx + 1);

        // Self-Work
        return Math.max(arr[idx], smallAns);
    }

    static int sumOfArray(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length)
            return 0;

        // Recursion
        int smallAns = sumOfArray(arr, idx + 1);

        // Self-Work
        return smallAns + arr[idx];
    }

    public static void main(String[] args) {

    }
}
