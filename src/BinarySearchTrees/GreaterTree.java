package BinarySearchTrees;

/**
 * In this the val of the node is changed from its original value to the sum of the elements greater than element.
 */
public class GreaterTree {
    static int sum = 0;

    public static void helper(Node root) {
        if (root == null) return;
        helper(root.right);
        root.val = root.val + sum;
        sum = root.val;
        helper(root.left);
    }

    public static void main(String[] args) {
        String[] arr = {"50", "20", "60", "17", "34", "55", "89", "10", "", "28", "", "", "", "70", "", "", "14"};
        Node root = Construct.construct(arr);
        helper(root);
    }
}
