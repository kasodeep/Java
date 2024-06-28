package BitManipulation;

public class CountTotalSetBitsTillN {

    public static int countSetBits(int n) {
        n++;
        int powerOf2 = 2;
        int cnt = n / 2;

        while (powerOf2 <= n) {
            int totalPairs = n / powerOf2;
            cnt += (totalPairs / 2) * powerOf2; // We have powerOf2 number of ones in half of pairs.

            cnt += (totalPairs % 2 == 1) ? (n % powerOf2) : 0;
            powerOf2 <<= 1;
        }

        return cnt;
    }
}
