package Daily.GfG;

public class ZerosToEnd {

    public static void pushZerosToEnd(int[] arr, int n) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) arr[j++] = arr[i];
        }

        while (j < n) arr[j++] = 0;
    }

    public static void main(String[] args) {

    }
}
