package Trees;

import java.util.*;

/**
 * Try to print the right ones and add left ones in queue.
 */
public class DiagonalTraversal {

    public static void diagonalTraversal(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            while (current != null) {
                System.out.print(current.val + " ");
                if (current.left != null) queue.add(current.left);
                current = current.right;
            }
        }
    }

    public static void main(String[] args) {

    }
}
