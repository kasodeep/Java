package Trees;

public class PreInTree {

    public static Node helper(int[] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh) {
        if (preLow > preHigh) return null;

        Node root = new Node(preorder[preLow]);
        int i = inLow;
        while (inorder[i] != preorder[preLow]) i++;

        int leftSize = i - inLow;
        root.left = helper(preorder, preLow + 1, preLow + leftSize, inorder, inLow, i - 1);
        root.right = helper(preorder, preLow + leftSize + 1, preHigh, inorder, i + 1, inHigh);
        return root;
    }

    // Time Complexity - O(n * log(n)) [Best], O(n^2) [Worst]
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        int n = preorder.length;
        Node root = helper(preorder, 0, n - 1, inorder, 0, n - 1);
        LevelOrderBFS.bfs(root);
    }
}
