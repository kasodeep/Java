package Trees;

/**
 * Return 0 if it's a leaf.
 * Return 1 if it's a parent of a leaf, with a camera on this node.
 * Return 2 if it's covered, without a camera on this node.
 */
public class BinaryTreeCameras {

    static int res = 0;

    public static int minCameraCover(Node root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    public static int dfs(Node root) {
        if (root == null) return 2;
        int left = dfs(root.left), right = dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }
}
