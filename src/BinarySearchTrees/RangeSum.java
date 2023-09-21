package BinarySearchTrees;

public class RangeSum {

    int sum = 0;

    public static void main(String[] args) {

    }

    void rangeSum(Node root, int low, int high) {
        if (root == null)
            return;
        if (root.val >= low && root.val <= high)
            sum += root.val;
        if (root.val > low)
            rangeSum(root.left, low, high);
        if (root.val < high)
            rangeSum(root.right, low, high);
    }
}
