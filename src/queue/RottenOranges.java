package queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public final static int R = 3;
    public final static int C = 5;

    // Function to check whether a cell is valid / invalid.
    static boolean isValid(int i, int j) {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }

    // Function to check whether the cell is delimiter which is (-1, -1)
    static boolean isDelimiter(Cells temp) {
        return (temp.x == -1 && temp.y == -1);
    }

    // Function to check whether there is still a fresh orange remaining
    static boolean checkAll(int[][] arr) {
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (arr[i][j] == 1)
                    return true;
        return false;
    }

    static int rotOranges(int[][] arr) {

        Queue<Cells> Q = new LinkedList<>();
        Cells temp;
        int ans = 0;

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (arr[i][j] == 2)
                    Q.add(new Cells(i, j));

        Q.add(new Cells(-1, -1));

        // Process the grid while there are rotten oranges in the Queue.
        while (!Q.isEmpty()) {
            boolean flag = false;

            // Process all the rotten oranges in current time frame.
            while (!Q.isEmpty() && !isDelimiter(Q.peek())) {
                temp = Q.peek();

                // Check right adjacent cell
                if (isValid(temp.x + 1, temp.y) && arr[temp.x + 1][temp.y] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x + 1][temp.y] = 2;
                    Q.add(new Cells(temp.x + 1, temp.y));
                }

                // Check left adjacent cell.
                if (isValid(temp.x - 1, temp.y) && arr[temp.x - 1][temp.y] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x - 1][temp.y] = 2;
                    Q.add(new Cells(temp.x - 1, temp.y));
                }

                // Check top adjacent cell.
                if (isValid(temp.x, temp.y + 1) && arr[temp.x][temp.y + 1] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x][temp.y + 1] = 2;
                    Q.add(new Cells(temp.x, temp.y + 1));

                }

                // Check bottom adjacent cell.
                if (isValid(temp.x, temp.y - 1) && arr[temp.x][temp.y - 1] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x][temp.y - 1] = 2;
                    Q.add(new Cells(temp.x, temp.y + 1));
                }
                Q.remove();
            }
            // Pop the delimiter
            Q.remove();
            if (!Q.isEmpty()) {
                Q.add(new Cells(-1, -1));
            }
        }

        return (checkAll(arr)) ? -1 : ans;
    }

    // Time Complexity - O(R * C), Auxiliary Space - O(R * C).
    public static void main(String[] args) {
        int[][] arr = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};

        int ans = rotOranges(arr);
        if (ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot => " + ans);
    }

    // structure for storing coordinates of the cell
    static class Cells {
        int x;
        int y;

        Cells(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

