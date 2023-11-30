package Daily.LeetCode;

public class OneBitOperation {

    /**
     * The concept used is by considering power of 2.
     * Try to calculate the number of operations required to convert the power of 2 to 0.
     * */
    public static int minimumOneBitOperations(int n) {
        int ans = 0;
        int k = 0;
        int mask = 1;

        while (mask <= n) {
            if ((n & mask) != 0) {
                ans = (1 << (k + 1)) - 1 - ans;
            }

            mask <<= 1;
            k++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
