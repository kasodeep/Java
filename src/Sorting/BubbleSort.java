package Sorting;

public class BubbleSort {
    
    static void sort(int[] arr){

        int n = arr.length;

        // Outer For Loop
        for (int i = 0; i < n-1; i++) {
            boolean flag = false;

            // Inner For Loop
            for (int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            // Optimizing the Approach
            if(!flag) return;
        }
    }

    public static void main(String[] args) {

        // Time Complexity: Worst & Average -O(N^2), Best - O(N)
        // Auxillary Space: O(1)
        // It is "Stable Sort" as it does not change the order of the duplicate items present in it.
        // It is also "In Place".
        int[] arr = {7, 4, 5, 1, 2};
        sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
