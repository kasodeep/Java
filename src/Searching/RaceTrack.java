package Searching;

public class RaceTrack {

   static boolean isPossible(int[] a, int k, int dist) {

      int kidsPlaces = 1;
      int lastKid = a[0];

      for (int i = 1; i < a.length; i++) {
         if (a[i] - lastKid >= dist) {
            kidsPlaces++;
            lastKid = a[i];
         }
      }
      return kidsPlaces >= k;
   }

   static int raceTrack(int[] a, int k) {

      if (k > a.length)
         return -1;

      int st = 0, end = (int) 1e9, ans = -1;

      while (st <= end) {
         int mid = st + (end - st) / 2;
         if (isPossible(a, k, mid)) { // can k kids be placed such that no 2 kids have distance greater than mid
            ans = mid;
            st = mid + 1;
         } else {
            end = mid - 1;
         }
      }
      return ans;
   }

   public static void main(String[] args) {
   }
}
