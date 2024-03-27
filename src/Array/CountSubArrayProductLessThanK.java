package Array;

public class CountSubArrayProductLessThanK {

    public static int numSubArrayProductLessThanK(int[] nums, int k) {
        int sum = 1;
        int result = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum *= nums[right];

            while (sum >= k && left <= right) {
                sum /= nums[left];
                left++;
            }
            result += right - left + 1;
        }
        return result;
    }
}
