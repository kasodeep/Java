package Recursion;

public class TriangularArrays {
    
    // Utility Function to Print Array
    static void printArray(int arr[]){

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // To create small Arrays
    static void createArray(int[] arr, int[] temp){

        for (int i = 0; i < arr.length-1; i++) {
            temp[i] = arr[i] + arr[i+1];
        }
    }

    static void printTriangle(int[] arr){

        // Base Case
        if(arr.length == 1){
            printArray(arr);
            return;
        }
        
        int n = arr.length;
        int[] temp = new int[n-1];
        createArray(arr, temp);

        // Recursion and Self-Work
        printTriangle(temp);
        printArray(arr);

    }

    public static void main(String[] args) {

            int arr[] = {1, 2, 3, 4, 5};
            printTriangle(arr);
    }
}
