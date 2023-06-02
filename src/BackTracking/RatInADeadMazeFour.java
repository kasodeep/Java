package BackTracking;

public class RatInADeadMazeFour {

   private static void print(int sr, int sc, int er, int ec, String s, int[][] maze) {
      if (sr < 0 || sc < 0)
         return;
      if (sc > ec || sr > er)
         return;
      if (sr == er && sc == ec) {
         System.out.println(s);
         return;
      }

      if (maze[sr][sc] == 0) // Blocked
         return;

      if (maze[sr][sc] == -1) // Already Visited
         return;

      // Check Mark
      maze[sr][sc] = -1;

      // Go Right
      print(sr, sc + 1, er, ec, s + "R", maze);
      // Go Down
      print(sr + 1, sc, er, ec, s + "D", maze);
      // Go Left
      print(sr, sc - 1, er, ec, s + "L", maze);
      // Go Up
      print(sr - 1, sc, er, ec, s + "U", maze);

      // Backtracking
      maze[sr][sc] = 1;
   }

   /*
    * The rat can move through the maze in four directions but he has to move only
    * if it is 1, if 0 can't move.
    * We could have also created an isVisited 2-D matrix, but that would consume
    * more memory.
    * We have to apply a check because the rat would otherwise loop over the
    * matrix.
    */
   public static void main(String[] args) {
      int rows = 3;
      int cols = 4;
      int[][] maze = { { 1, 0, 1, 1 },
            { 1, 1, 1, 1, },
            { 1, 1, 0, 1 } };

      print(0, 0, rows - 1, cols - 1, "", maze);
   }
}
