package Searching;

public class SearchMatrix {

   // Intergers in Each Row are Sorted
   // Last Column Element < Next Row Element
   // O(log(m*n))
   static boolean searchMatrix(int[][] a, int target) {

      int n = a.length, m = a[0].length;
      int st = 0, end = n * m - 1;

      while (st <= end) {
         int mid = st + (end - st / 2);
         int midElt = a[mid / m][mid % m];

         if (midElt == target)
            return true;
         if (target < midElt)
            end = mid - 1;
         else
            st = mid + 1;
      }
      return false;
   }

   // Integers in Each Row are Sorted
   // Integers in Each Column are Sorted
   // O(m+n)
   static boolean searchMatrix2(int[][] a, int target) {

      int n = a.length, m = a[0].length;
      int i = 0, j = m - 1;

      while (i < n && j >= 0) {
         if (a[i][j] == target)
            return true;
         if (target < a[i][j])
            j--;
         else
            i++;
      }
      return false;
   }

   public static void main(String[] args) {

   }
}
