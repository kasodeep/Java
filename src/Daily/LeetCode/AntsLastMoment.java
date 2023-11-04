package Daily.LeetCode;

public class AntsLastMoment {

    public static int getLastMoment(int n, int[] left, int[] right) {
        int leftMax = 0, rightMin = 0;
        if (left.length != 0) leftMax = left[0];
        if (right.length != 0) rightMin = right[0];

        for (int num : left) if (num > leftMax) leftMax = num;
        for (int num : right) if (num < rightMin) rightMin = num;

        if (left.length == 0) return n - rightMin;
        if (right.length == 0) return leftMax;
        return Math.max(leftMax, n - rightMin);
    }

    public static void main(String[] args) {

    }
}
