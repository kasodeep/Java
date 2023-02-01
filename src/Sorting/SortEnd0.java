package Sorting;

public class SortEnd0 {

   public static void sort0(int[] arr) {

      int n = arr.length;
      for (int i = 0; i < n - 1; i++) {
         for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] == 0 && arr[j + 1] != 0) {
               int temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
            }
         }
      }
   }

   public static void main(String[] args) {

      int[] arr = { 6, 7, 0, 3, 0, 4 };
      sort0(arr);
      for (int i : arr) {
         System.out.print(i + " ");
      }
   }
}
