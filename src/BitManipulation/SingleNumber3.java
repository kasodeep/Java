package BitManipulation;

public class SingleNumber3 {

    public static int singleNumber(int[] nums) {
        int[] count = new int[32];
        int n = nums.length;

        for (int i = 0; i < 32; i++) {
            for (int num : nums) {
                if ((num & (1 << i)) != 0) count[i] += 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) ans += (count[i] % 3) * (1 << i);
        return ans;
    }
}
