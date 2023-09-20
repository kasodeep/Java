package Trees;

import java.util.*;

public class NoAdjacentMaxSum {

    static HashMap<Node, Integer> map = new HashMap<>();

    static int maxSum(Node root) {
        if (root == null)
            return 0;

        if (map.containsKey(root))
            return map.get(root);
        int inc = root.val;

        if (root.left != null) inc += maxSum(root.left.left) + maxSum(root.left.right);
        if (root.right != null) inc += maxSum(root.right.left) + maxSum(root.right.right);
        int ex = maxSum(root.left) + maxSum(root.right);

        map.put(root, Math.max(inc, ex));
        return Math.max(inc, ex);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(1);
        root.left.left = new Node(2);
        root.left.left.left = new Node(1);
        root.left.right = new Node(3);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(5);
        System.out.println(maxSum(root));
    }
}

