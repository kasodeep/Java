package Daily.GfG;

public class ShuffleIntegers {

    public static void shuffleArray(long[] arr, int n) {
        int i = 1, j = n / 2;

        for (int k = 1; k < n - 1; k++) {
            if (k % 2 != 0) {
                arr[k] = (arr[j] % 1001) * 1001 + arr[k];
                j++;
            } else {
                arr[k] = (arr[i] % 1001) * 1001 + arr[k];
                i++;
            }
        }

        for (int k = 1; k < n - 1; k++) {
            arr[k] /= 1001;
        }
    }

    public static void main(String[] args) {

    }
}
