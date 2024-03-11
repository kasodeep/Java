package BackTracking;

public class RatInADeadMazeFour {

    private static void print(int sr, int sc, int er, int ec, String s, int[][] maze) {
        if (sr < 0 || sc < 0 || sc > ec || sr > er || maze[sr][sc] == 0 || maze[sr][sc] == -1)
            return;

        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }

        maze[sr][sc] = -1;

        print(sr, sc + 1, er, ec, s + "R", maze);
        print(sr + 1, sc, er, ec, s + "D", maze);
        print(sr, sc - 1, er, ec, s + "L", maze);
        print(sr - 1, sc, er, ec, s + "U", maze);

        maze[sr][sc] = 1;
    }

    /*
     * The rat can move through the maze in four directions, he has to move only if it is 1, if 0 can't move.
     * We could have also created an isVisited 2-D matrix, but that would consume more memory.
     * We have to apply a check because the rat would otherwise loop over the matrix.
     */
    public static void main(String[] args) {
        int rows = 3;
        int cols = 4;
        int[][] maze = {{1, 0, 1, 1},
                {1, 1, 1, 1,},
                {1, 1, 0, 1}};

        print(0, 0, rows - 1, cols - 1, "", maze);
    }
}
