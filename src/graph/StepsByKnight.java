package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class StepsByKnight {

    public static int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N) {
        boolean[][] vis = new boolean[N + 1][N + 1];
        Queue<int[]> q = new ArrayDeque<>();

        q.add(KnightPos);
        vis[KnightPos[0]][KnightPos[1]] = true;

        int step = 0;
        int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int[] pos = q.poll();
                if (pos[0] == TargetPos[0] && pos[1] == TargetPos[1]) {
                    return step;
                }

                for (int i = 0; i < 8; i++) {
                    int r = pos[0] + dir[i][0];
                    int c = pos[1] + dir[i][1];

                    if (r > 0 && r <= N && c > 0 && c <= N && !vis[r][c]) {
                        vis[r][c] = true;
                        q.offer(new int[]{r, c});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
