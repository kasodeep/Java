package Daily.GfG;

import java.util.HashSet;

public class PythagorasTriplet {

    public static boolean checkTriplet(int[] arr, int n) {
        HashSet<Long> s = new HashSet<>();
        for (int i = 0; i < n; i++)
            s.add((long) arr[i] * arr[i]);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                long res = ((long) arr[i] * arr[i]) + ((long) arr[j] * arr[j]);
                if (s.contains(res)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
