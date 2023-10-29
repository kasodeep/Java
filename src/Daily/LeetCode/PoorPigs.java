package Daily.LeetCode;

public class PoorPigs {

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int test = minutesToTest / minutesToDie + 1;
        int i = 0;

        while (Math.pow(test, i) < buckets) i++;
        return i;
    }

    public static void main(String[] args) {

    }
}
