package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeWindow {

    public static long[] printFirstNegativeInteger(long[] A, int N, int K) {
        long[] res = new long[N - K + 1];
        Queue<Integer> q = new LinkedList<>();

        // Adding -ve value indices.
        for (int i = 0; i < N; i++) {
            if (A[i] < 0) q.add(i);
        }

        for (int i = 0; i < N - K + 1; i++) {
            if (q.size() > 0 && q.peek() < i)
                q.remove();

            if (q.size() > 0 && q.peek() <= i + K - 1) {
                res[i] = A[q.peek()];
            } else if (q.size() == 0) {
                res[i] = 0;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
