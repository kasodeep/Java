package NAryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ZigZagOrder {

    public static void zigzag(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        int level = 0;

        while (!q.isEmpty()) {
            int n = q.size();

            if (level % 2 == 0) {
                while (n-- > 0) {
                    Node p = q.remove();
                    System.out.print(p.data + " ");
                    q.addAll(p.children);
                }
            } else {
                Stack<Integer> st = new Stack<>();
                while (n-- > 0) {
                    Node p = q.remove();
                    st.push(p.data);
                    q.addAll(p.children);
                }
                while (st.size() > 0) {
                    System.out.print(st.pop() + " ");
                }
            }
            level++;
            System.out.println();
        }
    }
}
