package Sorting;

public class RadixSort {

   // Finding the Max Element.
   static int findMax(int[] arr) {

      int mx = Integer.MIN_VALUE;
      for (int i = 0; i < arr.length; i++) {
         if (arr[i] > mx) {
            mx = arr[i];
         }
      }
      return mx;
   }

   // Count Sort for Radix implementation.
   static void countSort(int[] arr, int place) {

      int n = arr.length;
      int[] output = new int[n];

      // Make frequency array
      int[] count = new int[10];
      for (int i = 0; i < arr.length; i++) {
         count[(arr[i] / place) % 10]++;
      }

      // Make prefix sum array of count array
      for (int i = 1; i < count.length; i++) {
         count[i] += count[i - 1];
      }

      // Find the index of each element in the original array and put it in output.
      // To Make Stable
      for (int i = n - 1; i >= 0; i--) {
         int idx = count[(arr[i] / place) % 10] - 1;
         output[idx] = arr[i];
         count[(arr[i] / place) % 10]--;
      }

      // Copy all elements of output to array.
      for (int i = 0; i < n; i++) {
         arr[i] = output[i];
      }
   }

   // Radix Sort
   static void radixSort(int[] arr) {

      int max = findMax(arr);
      for (int place = 1; max / place > 0; place *= 10) {
         countSort(arr, place);
      }
   }

   public static void main(String[] args) {

      // 1) Digit by digit sorting or place by place.
      // Time Complexity: Worst & Average -O(Nd), Best - O(N)
      // Auxillary Space: O(N)
      // It is "Stable Sort" as it does not change the order of the duplicate items.
      // It is also "In Place".
      int[] arr = { 43, 453, 626, 894, 0, 3 };
      radixSort(arr);
      for (int val : arr) {
         System.out.print(val + " ");
      }
      System.out.println();
   }
}
