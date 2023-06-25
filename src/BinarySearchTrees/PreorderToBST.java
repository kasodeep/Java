package BinarySearchTrees;

public class PreorderToBST {

    public static Node insertIntoBST(Node root, int val) {
        if (root == null) return new Node(val);
        if (root.val > val) {
            if (root.left == null) root.left = new Node(val);
            else insertIntoBST(root.left, val);
        } else {
            if (root.right == null) root.right = new Node(val);
            else insertIntoBST(root.right, val);
        }
        return root;
    }

    public static Node bstFromPreorder(int[] preorder) {
        Node root = new Node(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            root = insertIntoBST(root, preorder[i]);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {8, 5, 1, 7, 10, 12};
        bstFromPreorder(arr);
    }
}
