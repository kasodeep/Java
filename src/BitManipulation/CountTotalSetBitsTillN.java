package BitManipulation;

public class CountTotalSetBitsTillN {

    public static int countSetBits(int n) {
        n++;
        int powerOf2 = 2;
        int cnt = n / 2;

        while (powerOf2 <= n) {

            int totalPairs = n / powerOf2;

            /* (totalPairs / 2) gives the complete count of the pairs of 1s.
                Multiplying it with the current power of 2 will give the count of 1s in the current bit.
            */
            cnt += (totalPairs / 2) * powerOf2;

            // If the count of pairs was odd then add the remaining 1s which could not be grouped together
            cnt += (totalPairs % 2 == 1) ? (n % powerOf2) : 0;
            powerOf2 <<= 1;
        }

        return cnt;
    }
}
