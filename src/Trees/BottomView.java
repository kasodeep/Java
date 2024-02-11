package Trees;

import java.util.*;

public class BottomView {

    static void printBottomView(Node root) {
        if (root == null) return;
        HashMap<Integer, Integer> hash = new HashMap<>();
        int leftmost = 0;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair top = q.remove();
            Node temp = top.node;
            int index = top.second;

            hash.put(index, temp.val);
            leftmost = Math.min(index, leftmost);

            if (temp.left != null) q.add(new Pair(temp.left, index - 1));
            if (temp.right != null) q.add(new Pair(temp.right, index + 1));
        }

        while (hash.containsKey(leftmost)) {
            System.out.print(hash.get(leftmost++) + " ");
        }
    }

    public static void main(String[] args) {

    }

    static class Pair {
        Node node;
        int second;

        Pair(Node node, int second) {
            this.node = node;
            this.second = second;
        }
    }
}
