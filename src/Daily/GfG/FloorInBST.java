package Daily.GfG;

public class FloorInBST {

    static int max = -1;

    public static void helper(TreeNode root, int x) {
        if (root == null) return;
        if (root.val <= x && root.val > max) max = root.val;

        helper(root.left, x);
        helper(root.right, x);
    }

    public static int floor(TreeNode root, int x) {
        max = -1;
        helper(root, x);
        return max;
    }

    public static void main(String[] args) {

    }
}
