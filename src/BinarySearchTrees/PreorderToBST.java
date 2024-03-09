package BinarySearchTrees;

public class PreorderToBST {

    public static Node bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    public static Node helper(int[] preorder, int st, int end) {
        if (end < st) return null;

        Node root = new Node(preorder[st]);
        int check = preorder[st];
        int i = st + 1;
        while (i <= end && check > preorder[i]) i++;

        root.left = helper(preorder, st + 1, i - 1);
        root.right = helper(preorder, i, end);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {8, 5, 1, 7, 10, 12};
        Node root = bstFromPreorder(arr);
        Basics.inorder(root);
    }
}
