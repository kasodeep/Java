package Trees;

public class PathSums {

    public static boolean hasPathSum(Node root, int targetSum) {
        if (root == null) return false;

        // Root to Leaf path.
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {

    }
}
