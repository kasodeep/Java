package Trees;

import java.util.HashMap;
import java.util.Stack;

public class MirrorOrNot {

    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        HashMap<Integer, Stack<Integer>> hm = new HashMap<>();

        for (int i = 0; i < A.length; i = i + 2) {
            if (hm.containsKey(A[i])) {
                hm.get(A[i]).push(A[i + 1]);
            } else {
                Stack<Integer> s = new Stack<>();
                s.push(A[i + 1]);
                hm.put(A[i], s);
            }
        }

        for (int i = 0; i < B.length; i = i + 2)
            if (B[i + 1] != hm.get(B[i]).pop())
                return 0;
        return 1;
    }
}
