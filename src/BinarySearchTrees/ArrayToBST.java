package BinarySearchTrees;

/**
 * We are given a sorted array, we are going to convert it a bst.
 */
public class ArrayToBST {

    public static Node helper(int[] arr, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;

        Node root = new Node(arr[mid]);
        root.left = helper(arr, low, mid - 1);
        root.right = helper(arr, mid + 1, high);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        helper(arr, 0, n - 1);
    }
}
