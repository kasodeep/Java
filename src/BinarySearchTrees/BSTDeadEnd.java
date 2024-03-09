package BinarySearchTrees;

import java.util.HashSet;

public class BSTDeadEnd {

    static void findAllNodes(Node root, HashSet<Integer> allNodes) {
        if (root == null) return;

        allNodes.add(root.val);
        findAllNodes(root.left, allNodes);
        findAllNodes(root.right, allNodes);
    }

    static boolean check(Node root, HashSet<Integer> allNodes) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            int pre = root.val - 1;
            int next = root.val + 1;
            if (allNodes.contains(pre) && allNodes.contains(next)) {
                return true;
            }
        }

        return check(root.left, allNodes) || check(root.right, allNodes);
    }

    public static boolean isDeadEnd(Node root) {
        if (root == null) return false;

        HashSet<Integer> allNodes = new HashSet<>();
        allNodes.add(0); // For nodes with values 1.
        findAllNodes(root, allNodes);
        return check(root, allNodes);
    }
}
