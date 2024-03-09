package BinarySearchTrees;

public class MinimumDifference {

    static int minDiff = Integer.MAX_VALUE;
    static Node prev = null;

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);

        if (prev != null) {
            int diff = Math.abs(root.val - prev.val);
            minDiff = Math.min(minDiff, diff);
        }

        prev = root;
        inorder(root.right);
    }
}
