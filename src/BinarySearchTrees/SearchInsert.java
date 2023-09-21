package BinarySearchTrees;

public class SearchInsert {

    public static Node insertIntoBST(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (root.val > val) {
            if (root.left == null) root.left = new Node(val);
            else insertIntoBST(root.left, val);
        } else {
            if (root.right == null) root.right = new Node(val);
            else insertIntoBST(root.right, val);
        }
        return root;
    }

    public static Node searchBST(Node root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;
        else if (root.val < val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }

    public static void main(String[] args) {
        String[] arr = {"50", "20", "60", "17", "34", "55", "89", "10", "", "28", "", "", "", "70", "", "", "14"};
        Node root = Construct.construct(arr);

        Node found = searchBST(root, 10);
        System.out.println(found.val);

        // New node if root is null.
        Node node = insertIntoBST(root, 20);
        System.out.println(node.val);
    }
}
