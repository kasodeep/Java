package Searching;

public class FirstOccurence {

   static int firstOccurence(int[] a, int x) {

      int st = 0, end = a.length - 1;
      int fo = -1;

      while (st <= end) {
         int mid = st + (end - st) / 2;
         if (x == a[mid]) {
            fo = mid;
            end = mid - 1;
         } else if (x > a[mid]) {
            st = mid + 1;
         } else {
            end = mid - 1;
         }
      }
      return fo;
   }

   public static void main(String[] args) {
      int[] arr = { 2, 2, 2, 2, 2, 2, 3, 3, 4, 5, 6, 6, 6, 6 };
      System.out.println(firstOccurence(arr, 6));
   }
}
