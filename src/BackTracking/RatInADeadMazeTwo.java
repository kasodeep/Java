package BackTracking;

public class RatInADeadMazeTwo {

   private static void print(int sr, int sc, int er, int ec, String s, int[][] maze) {
      if (sc > ec || sr > er)
         return;
      if (sr == er && sc == ec) {
         System.out.println(s);
         return;
      }

      // Check if we are at 0.
      if (maze[sr][sc] == 0)
         return;

      // Go Right
      print(sr, sc + 1, er, ec, s + "R", maze);
      // Go Down
      print(sr + 1, sc, er, ec, s + "D", maze);
   }

   /*
    * The rat can move through the maze in two directions but he has to move only
    * if it is 1, if 0 can't move.
    * Here we are not backtracking, just doing recursion.
    */
   public static void main(String[] args) {
      int rows = 4;
      int cols = 6;
      int[][] maze = { { 1, 0, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 0, 1 },
            { 0, 1, 1, 1, 1, 1 },
            { 0, 0, 1, 0, 1, 1 } };

      print(0, 0, rows - 1, cols - 1, "", maze);
   }
}
