package Daily.LeetCode;

public class ReachableCell {

    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int width = Math.abs(sx - fx);
        int height = Math.abs(sy - fy);

        if (width == 0 && height == 0 && t == 1) return false;
        return t >= Math.max(width, height);
    }

    public static void main(String[] args) {

    }
}
