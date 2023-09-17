package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderBFS {

    /*
     * Breadth First Search algorithm to find and print the elements in level order.
     */
    public static void bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root != null)
            q.add(root);

        while (q.size() > 0) {
            Node temp = q.peek();

            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);

            System.out.print(temp.val + " ");
            q.remove();
        }
    }

    public static void reverseLevelOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            stack.push(temp);

            if (temp.right != null) {
                queue.add(temp.right);
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
        }

        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.print(temp.val + " ");
        }
    }

    public static void main(String[] args) {

    }
}
