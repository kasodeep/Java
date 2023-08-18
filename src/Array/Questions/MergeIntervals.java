package Array.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = matrix.length;

        Arrays.sort(matrix, Comparator.comparingInt(a -> a[0]));
        int i = 0;

        while (i < n) {
            List<Integer> list = new ArrayList<>();
            while (i < n - 1 && matrix[i][1] >= matrix[i + 1][0]) {
                matrix[i + 1][0] = matrix[i][0];
                matrix[i + 1][1] = Math.max(matrix[i][1], matrix[i + 1][1]);
                i++;
            }
            list.add(matrix[i][0]);
            list.add(matrix[i][1]);
            ans.add(list);
            i++;
        }

        int[][] merge = new int[ans.size()][2];
        for (i = 0; i < ans.size(); i++) {
            List<Integer> list = ans.get(i);
            merge[i][0] = list.get(0);
            merge[i][1] = list.get(1);
        }
        return merge;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = merge(intervals);

        for (int[] num : merged) {
            for (int j = 0; j < 2; j++) {
                System.out.print(num[j] + " ");
            }
            System.out.println();
        }
    }
}
