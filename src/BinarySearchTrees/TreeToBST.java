package BinarySearchTrees;

import java.util.Arrays;

public class TreeToBST {

    static int index;

    static void storeInorder(Node node, int[] inorder) {
        if (node == null)
            return;

        storeInorder(node.left, inorder);
        inorder[index++] = node.val;
        storeInorder(node.right, inorder);
    }

    /* A helper function to count nodes in a Binary Tree */
    static int countNodes(Node root) {
        if (root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    static void arrayToBST(int[] arr, Node root) {
        if (root == null)
            return;

        arrayToBST(arr, root.left);
        root.val = arr[index++];
        arrayToBST(arr, root.right);
    }

    public static void main(String[] args) {

    }

    Node binaryTreeToBST(Node root) {
        if (root == null)
            return root;

        int n = countNodes(root);
        int[] arr = new int[n];

        index = 0;
        storeInorder(root, arr);
        Arrays.sort(arr);

        index = 0;
        arrayToBST(arr, root);
        return root;
    }
}
