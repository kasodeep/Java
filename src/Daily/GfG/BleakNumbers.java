package Daily.GfG;

public class BleakNumbers {

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static int is_bleak(int n) {
        for (int i = n - (int) Math.sqrt(n); i < n; i++) {
            int count = countSetBits(i);
            if (count + i == n) return 0;
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}
