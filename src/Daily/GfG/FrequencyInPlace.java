package Daily.GfG;

public class FrequencyInPlace {

    public static void frequencyCount(int[] arr, int N, int P) {
        int i = 0;
        while (i < N) {
            if (arr[i] <= 0 || arr[i] > N || arr[i] > P) {
                i++;
                continue;
            }

            int elementIndex = arr[i] - 1;
            if (arr[elementIndex] > 0) {
                arr[i] = arr[elementIndex];
                arr[elementIndex] = -1;
            } else {
                arr[elementIndex]--;
                arr[i] = 0;
                i++;
            }
        }

        for (i = 0; i < N; i++) {
            if (arr[i] < 0) arr[i] *= -1;
            else arr[i] = 0;
        }
    }

    public static void main(String[] args) {

    }
}
