package Array.Questions;

import java.util.Arrays;
import java.util.Comparator;

public class BurstBalloons {

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new PointComparator());
        int count = 1, end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }

    private static class PointComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[1], b[1]);
        }
    }
}
