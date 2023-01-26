package Sorting;

public class SelectionSort {
    
    static void selectionSort(int[] arr){

        int n = arr.length;

        // Outer For Loop
        for (int i = 0; i < n-1; i++) {
            int min = i;

            // Inner For Loop
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        
        // Time Complexity: Worst & Average & Best - O(N^2)
        // Auxillary Space: O(1)
        // It is "UnStable Sort" as it does change the order of the duplicate items present in it.
        // It is also "In Place".
        int[] arr = {7, 4, 5, 1, 2};
        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
