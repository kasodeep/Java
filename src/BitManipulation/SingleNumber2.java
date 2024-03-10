package BitManipulation;

public class SingleNumber2 {

    public static int[] singleNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) sum ^= num;

        // This gives us the rightmost set bit. We do & of sum, it's 2's compliment.
        sum = sum & -sum;

        int sum1 = 0, sum2 = 0;
        for (int num : nums) {
            if ((num & sum) > 0) sum1 ^= num;
            else sum2 ^= num;
        }

        return new int[]{sum1, sum2};
    }
}
