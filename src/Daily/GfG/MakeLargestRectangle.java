package Daily.GfG;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakeLargestRectangle {

    static Map<Integer, Integer> unmap = new HashMap<>();

    static int dfs(int i, int j, int[][] grid, boolean[][] visited, int key) {
        int n = grid.length;
        if (i < 0 || j < 0 || i >= n || j >= n || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }

        visited[i][j] = true;
        int count = 1 + dfs(i + 1, j, grid, visited, key)
                + dfs(i - 1, j, grid, visited, key)
                + dfs(i, j + 1, grid, visited, key)
                + dfs(i, j - 1, grid, visited, key);
        grid[i][j] = key;
        return count;
    }

    public static int largestIsland(int N, int[][] grid) {
        int n = grid.length;
        int key = 2;
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int count = dfs(i, j, grid, visited, key);
                    unmap.put(key, count);
                    key++;
                }
            }
        }

        int result = -1;
        boolean[][] visited2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int a = (i + 1 < n) ? grid[i + 1][j] : 0;
                    int b = (i - 1 >= 0) ? grid[i - 1][j] : 0;
                    int c = (j + 1 < n) ? grid[i][j + 1] : 0;
                    int d = (j - 1 >= 0) ? grid[i][j - 1] : 0;
                    Set<Integer> st = new HashSet<>();
                    st.add(a);
                    st.add(b);
                    st.add(c);
                    st.add(d);

                    int res = 1;
                    for (int value : st) res += unmap.getOrDefault(value, 0);
                    result = Math.max(result, res);
                }
            }
        }

        if (result == -1) return n * n;
        return result;
    }

    public static void main(String[] args) {

    }
}
