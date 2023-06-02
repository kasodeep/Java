package BackTracking;

public class MazePathWays {

   private static int maze(int sr, int sc, int er, int ec) {
      if (sc > ec || sr > er)
         return 0;
      if (sr == er && sc == ec) {
         return 1;
      }
      // Right Ways + Down Ways
      return maze(sr, sc + 1, er, ec) + maze(sr + 1, sc, er, ec);
   }

   public static void main(String[] args) {
      int rows = 3;
      int cols = 2;
      System.out.println(maze(0, 0, rows - 1, cols - 1));
   }
}
