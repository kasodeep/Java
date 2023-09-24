package NAryTree;

import java.util.*;

public class LevelOrderBFS {

    public static void levelOrderTraversal(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            while (n > 0) {
                Node p = q.remove();
                System.out.print(p.data + " ");

                // Enqueue all children of the dequeued item
                q.addAll(p.children);
                n--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }
}
