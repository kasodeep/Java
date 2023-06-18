package Trees;

public class PreInTree {

    public static Node helper(int[] preorder, int prelo, int prehi, int[] inorder, int inlo, int inhi) {
        // Base Case
        if (prelo > prehi) return null;

        // First element is always the root, and we find its position in inorder.
        Node root = new Node(preorder[prelo]);
        int i = inlo;
        while (inorder[i] != preorder[prelo]) i++;

        // Making the Recursive calls.
        int leftsize = i - inlo;
        root.left = helper(preorder, prelo + 1, prelo + leftsize, inorder, inlo, i - 1);
        root.right = helper(preorder, prelo + leftsize + 1, prehi, inorder, i + 1, inhi);
        return root;
    }

    // Time Complexity - O(n * logn)[Best], O(n^2)[Worst]
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        int n = preorder.length;
        Node root = helper(preorder, 0, n - 1, inorder, 0, n - 1);
        LevelOrderBFS.bfs(root);
    }
}
