package BinarySearchTrees;

public class PreorderToBST {

    public static void insertIntoBST(Node root, int val) {
        if (root == null) return;

        if (root.val > val) {
            if (root.left == null) root.left = new Node(val);
            else insertIntoBST(root.left, val);
        } else {
            if (root.right == null) root.right = new Node(val);
            else insertIntoBST(root.right, val);
        }
    }

    public static Node bstFromPreorder(int[] preorder) {
        Node root = new Node(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insertIntoBST(root, preorder[i]);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {8, 5, 1, 7, 10, 12};
        Node root = bstFromPreorder(arr);
        Basics.inorder(root);
    }
}
