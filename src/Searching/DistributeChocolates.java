package Searching;

public class DistributeChocolates {

   static boolean isDivisionPossible(int[] a, int m, int mxChocoAllowed) {

      int numOfStudents = 1;
      int choc = 0;

      for (int i = 0; i < a.length; i++) {
         if (a[i] > mxChocoAllowed)
            return false;

         if (choc + a[i] <= mxChocoAllowed) {
            choc += a[i];
         } else {
            numOfStudents++;
            choc = a[i];
         }
      }

      return numOfStudents <= m;
   }

   static int distributeChocolates(int[] a, int m) {

      if (a.length < m)
         return -1;

      int ans = 0, st = 1, end = (int) 1e9;

      while (st <= end) {
         int mid = st + (end - st) / 2;
         if (isDivisionPossible(a, m, mid)) {
            ans = mid;
            end = mid - 1;
         } else {
            st = mid + 1;
         }
      }
      return ans;
   }

   // Time Complexity - O(n*logn)
   public static void main(String[] args) {

      int[] a = { 5, 3, 1, 4, 2 };
      int m = 3;
      System.out.println(distributeChocolates(a, m));
   }
}
