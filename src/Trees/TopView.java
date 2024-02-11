package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopView {

    static void topView(Node root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int hd, l = 0, r = 0;

        Stack<Integer> left = new Stack<>();
        ArrayList<Integer> right = new ArrayList<>();
        Node node;

        while (!q.isEmpty()) {
            node = q.peek().node;
            hd = q.peek().hd;

            if (hd < l) {
                left.push(node.val);
                l = hd;
            }

            if (hd > r) {
                right.add(node.val);
                r = hd;
            }

            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
            q.poll();
        }

        while (!left.isEmpty()) System.out.print(left.pop() + " ");
        System.out.print(root.val + " ");
        for (int num : right) System.out.print(num + " ");
    }

    public static void main(String[] args) {

    }

    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}

