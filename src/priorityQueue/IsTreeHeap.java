package priorityQueue;

import java.util.LinkedList;
import java.util.Queue;

public class IsTreeHeap {

    static boolean isHeap(Node root) {
        if (root == null) return true;
        Queue<Node> q = new LinkedList<>();
        int flag = 0;
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.left != null) {
                if (flag == 1) return false;

                q.add(curr.left);
                if (curr.data <= curr.left.data) return false;
            } else {
                flag = 1;
            }

            if (curr.right != null) {
                if (flag == 1) return false;

                q.add(curr.right);
                if (curr.data <= curr.right.data) return false;
            } else {
                flag = 1;
            }
        }
        return true;
    }

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
}
