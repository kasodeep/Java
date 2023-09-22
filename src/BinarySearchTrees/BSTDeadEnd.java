package BinarySearchTrees;

import java.util.HashMap;
import java.util.Map;

public class BSTDeadEnd {

    static void findAllNodes(Node root, Map<Integer, Integer> allNodes) {
        if (root == null) return;

        allNodes.put(root.val, 1);
        findAllNodes(root.left, allNodes);
        findAllNodes(root.right, allNodes);
    }

    static boolean check(Node root, Map<Integer, Integer> allNodes) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            int pre = root.val - 1;
            int next = root.val + 1;
            if (allNodes.containsKey(pre) && allNodes.containsKey(next)) {
                return true;
            }
        }

        return check(root.left, allNodes) || check(root.right, allNodes);
    }

    public static boolean isDeadEnd(Node root) {
        if (root == null) return false;

        Map<Integer, Integer> allNodes = new HashMap<>();
        allNodes.put(0, 1); // For nodes with values 1.
        findAllNodes(root, allNodes);
        return check(root, allNodes);
    }
}
