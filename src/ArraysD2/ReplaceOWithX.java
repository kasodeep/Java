package ArraysD2;

public class ReplaceOWithX {

    static void fill(int n, int m, char[][] a) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && a[i][j] == 'O')
                    dfs(a, n, m, i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O') a[i][j] = 'X';
                else if (a[i][j] == '$') a[i][j] = 'O';
            }
        }
    }

    static void dfs(char[][] a, int n, int m, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || a[i][j] == 'X')
            return;

        if (a[i][j] == 'O') {
            a[i][j] = '$';
            dfs(a, n, m, i + 1, j);
            dfs(a, n, m, i - 1, j);
            dfs(a, n, m, i, j - 1);
            dfs(a, n, m, i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] mat = {{'X', 'O', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'}};

        int N = mat.length;
        int M = mat[0].length;
        fill(N, M, mat);

        for (char[] chars : mat) {
            for (int j = 0; j < M; j++)
                System.out.print(chars[j] + " ");
            System.out.println();
        }
    }
}
