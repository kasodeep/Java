package ArraysD2;

import java.util.*;

public class MaximumRectangle1s {

    static int maxHist(int R, int C, int[] row) {
        Stack<Integer> result = new Stack<>();
        int top_val;
        int max_area = 0;
        int area;

        int i = 0;
        while (i < C) {
            if (result.empty() || row[result.peek()] <= row[i])
                result.push(i++);
            else {
                top_val = row[result.pop()];

                // No need to do i + 1, as 'i' is already ahead.
                area = top_val * i;

                if (!result.empty())
                    area = top_val * (i - result.peek() - 1);
                max_area = Math.max(area, max_area);
            }
        }

        while (!result.empty()) {
            top_val = row[result.pop()];
            area = top_val * i;

            if (!result.empty())
                area = top_val * (i - result.peek() - 1);
            max_area = Math.max(area, max_area);
        }
        return max_area;
    }

    static int maxRectangle(int R, int C, int[][] A) {
        int result = maxHist(R, C, A[0]);

        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++)
                if (A[i][j] == 1)
                    A[i][j] += A[i - 1][j];
            result = Math.max(result, maxHist(R, C, A[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        int R = 4;
        int C = 4;
        int[][] A = {{0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},};

        System.out.print("Area of maximum rectangle is " + maxRectangle(R, C, A));
    }
}

