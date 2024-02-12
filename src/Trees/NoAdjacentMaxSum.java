package Trees;

import java.util.*;

public class NoAdjacentMaxSum {

    static HashMap<Node, Integer> map = new HashMap<>();

    static int maxSum(Node root) {
        if (root == null) return 0;

        if (map.containsKey(root)) return map.get(root);
        int inc = root.val;

        if (root.left != null) inc += maxSum(root.left.left) + maxSum(root.left.right);
        if (root.right != null) inc += maxSum(root.right.left) + maxSum(root.right.right);
        int ex = maxSum(root.left) + maxSum(root.right);

        map.put(root, Math.max(inc, ex));
        return Math.max(inc, ex);
    }

    public static void main(String[] args) {

    }
}

