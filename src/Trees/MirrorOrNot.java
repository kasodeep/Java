package Trees;

import java.util.HashMap;
import java.util.Stack;

public class MirrorOrNot {

    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        HashMap<Integer, Stack<Integer>> map = new HashMap<>();

        for (int i = 0; i < A.length; i = i + 2) {
            // A[i] is the parent of i + 1.
            if (map.containsKey(A[i])) {
                map.get(A[i]).push(A[i + 1]);
            } else {
                Stack<Integer> s = new Stack<>();
                s.push(A[i + 1]);
                map.put(A[i], s);
            }
        }

        // B[i] will have opposite order of children.
        for (int i = 0; i < B.length; i = i + 2)
            if (B[i + 1] != map.get(B[i]).pop())
                return 0;
        return 1;
    }
}
