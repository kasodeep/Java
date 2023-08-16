package ArraysD2;

public class CountIsland {

    static void DFS(int[][] M, int i, int j, int ROW, int COL) {
        if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != 1) {
            return;
        }

        if (M[i][j] == 1) {
            M[i][j] = 0;
            DFS(M, i + 1, j, ROW, COL);
            DFS(M, i - 1, j, ROW, COL);
            DFS(M, i, j + 1, ROW, COL);
            DFS(M, i, j - 1, ROW, COL);
            DFS(M, i + 1, j + 1, ROW, COL);
            DFS(M, i - 1, j - 1, ROW, COL);
            DFS(M, i + 1, j - 1, ROW, COL);
            DFS(M, i - 1, j + 1, ROW, COL);
        }
    }

    static int countIslands(int[][] M) {

        int ROW = M.length;
        int COL = M[0].length;
        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (M[i][j] == 1) {
                    count++;
                    DFS(M, i, j, ROW, COL);
                }
            }
        }
        return count;
    }

    // Time Complexity - O(R*C), Auxiliary Space - O(R*C)
    public static void main(String[] args) {
        int[][] M = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        System.out.print("Number of islands is: " + countIslands(M));
    }
}
