package Array;

public class JumpGame2 {

    public static int jump(int[] nums) {
        if (nums.length == 1) return 0;
        return jump(nums, 0);
    }

    public static int jump(int[] nums, int start) {
        if (start + nums[start] >= nums.length - 1) return 1;

        int max = -1;
        int max_index = -1;
        for (int i = 1; i <= nums[start]; i++) {
            if (start + i + nums[start + i] > max) {
                max = start + i + nums[start + i];
                max_index = start + i;
            }
        }
        return jump(nums, max_index) + 1;
    }
}
