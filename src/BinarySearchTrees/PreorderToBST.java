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

    public static Node create(int[] pre, int low, int high) {
        if (low >= high) return null;

        Node root = new Node(pre[low]);
        int i = low + 1;
        while (i < high && pre[low] > pre[i]) {
            i++;
        }

        root.left = create(pre, low + 1, i);
        root.right = create(pre, i, high);
        return root;
    }

    // Second Approach.
    public static Node post_order(int[] pre, int size) {
        return create(pre, 0, size);
    }

    public static void main(String[] args) {
        int[] arr = {8, 5, 1, 7, 10, 12};
        Node root = bstFromPreorder(arr);
        Basics.inorder(root);
    }
}
