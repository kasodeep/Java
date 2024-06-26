package Array;

public class MaxWaterContainer {

    static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;

        while (l < r) {
            ans = Math.max(ans, (r - l) * Math.min(height[r], height[l]));

            if (height[l] <= height[r]) {
                int hl = height[l];
                while (l < r && height[l] <= hl)
                    l++;
            } else {
                int hr = height[r];
                while (l < r && height[r] <= hr)
                    r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 5, 6, 7, 8, 9, 7};
        System.err.println(maxArea(arr));
    }
}
