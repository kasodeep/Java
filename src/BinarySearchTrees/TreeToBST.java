package BinarySearchTrees;

import java.util.ArrayList;
import java.util.Collections;

public class TreeToBST {

    static void storeInorder(Node node, ArrayList<Integer> inorder) {
        if (node == null) return;

        storeInorder(node.left, inorder);
        inorder.add(node.val);
        storeInorder(node.right, inorder);
    }

    public static Node helper(ArrayList<Integer> arr, int low, int high) {
        if (low > high) return null;
        int mid = low + (high - low) / 2;

        Node root = new Node(arr.get(mid));
        root.left = helper(arr, low, mid - 1);
        root.right = helper(arr, mid + 1, high);
        return root;
    }

    static Node binaryTreeToBST(Node root) {
        if (root == null) return root;

        ArrayList<Integer> arr = new ArrayList<>();
        storeInorder(root, arr);
        Collections.sort(arr);

        return helper(arr, 0, arr.size() - 1);
    }
}
