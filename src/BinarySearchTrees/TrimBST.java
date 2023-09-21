package BinarySearchTrees;

public class TrimBST {

    public static void helper(Node root, int low, int high) {
        if (root == null) return;

        while (root.left != null) {
            if (root.left.val < low) root.left = root.left.right;
            else if (root.left.val > high) root.left = root.left.left;
            else break;
        }

        while (root.right != null) {
            if (root.right.val < low) root.right = root.right.right;
            else if (root.right.val > high) root.right = root.right.left;
            else break;
        }

        helper(root.left, low, high);
        helper(root.right, low, high);
    }

    public static void main(String[] args) {
        String[] arr = {"50", "20", "60", "17", "34", "55", "89", "10", "", "28", "", "", "", "70", "", "", "14"};
        Node root = Construct.construct(arr);

        Node parent = new Node(Integer.MAX_VALUE);
        parent.left = root;
        helper(parent, 20, 50);
    }
}
