package Trees;

/*
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees
 * of every node never differs by more than one.
 */
public class HeightBalanced {

    static boolean f = true;

    static boolean isBalanced(Node root) {
        f = true;
        helper(root);
        return f;
    }

    static int helper(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int left = helper(root.left);
        int right = helper(root.right);

        if (Math.abs(left - right) > 1) f = false;
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

    }
}
