package ArraysD2;

import java.util.*;

public class MaximumRectangle1s {
    
    public static int maxHist(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int max_area = arr[0];

        int[] left_smaller = new int[n];
        int[] right_smaller = new int[n];
        for (int i = 0; i < n; i++) {
            left_smaller[i] = -1;
            right_smaller[i] = n;
        }

        int i = 0;
        while (i < n) {
            while (!s.empty() && s.peek() != -1 && arr[i] < arr[s.peek()]) {
                right_smaller[s.peek()] = i;
                s.pop();
            }

            if (i > 0 && arr[i] == arr[i - 1]) {
                left_smaller[i] = left_smaller[i - 1];
            } else {
                left_smaller[i] = s.peek();
            }
            s.push(i);
            i++;
        }

        for (i = 0; i < n; i++) {
            max_area = Math.max(max_area, arr[i] * (right_smaller[i] - left_smaller[i] - 1));
        }
        return max_area;
    }


    static int maxRectangle(int R, int C, int[][] A) {
        int result = maxHist(A[0], C);

        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++)
                if (A[i][j] == 1)
                    A[i][j] += A[i - 1][j];
            result = Math.max(result, maxHist(A[i], C));
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

