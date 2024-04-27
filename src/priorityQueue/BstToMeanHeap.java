package priorityQueue;

import java.util.ArrayList;

/**
 * For min heap, we do preorder and for max heap we do postorder.
 */
public class BstToMeanHeap {

    static int index;

    private static void bstToArray(Node root, ArrayList<Integer> arr) {
        if (root == null) return;

        bstToArray(root.left, arr);
        arr.add(root.data);
        bstToArray(root.right, arr);
    }

    private static void arrToMinHeap(Node root, ArrayList<Integer> arr) {
        if (root == null) return;

        root.data = arr.get(index++);
        arrToMinHeap(root.left, arr);
        arrToMinHeap(root.right, arr);
    }

    public static void convertToMinHeap(Node root) {
        index = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        bstToArray(root, arr);
        arrToMinHeap(root, arr);
    }

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}
