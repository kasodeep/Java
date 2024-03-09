package BinarySearchTrees;

public class RangeSum {

    int rangeSum(Node root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        if (root.val >= low && root.val <= high) sum += root.val;

        if (root.val > low) sum += rangeSum(root.left, low, high);
        if (root.val < high) sum += rangeSum(root.right, low, high);
        return sum;
    }
}
