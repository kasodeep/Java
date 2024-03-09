package BinarySearchTrees;

public class PopulateNext {

    static Node node = null;

    public static void populateNext(Node root) {
        if (root == null) return;

        populateNext(root.left);
        if (node != null) node.next = root;
        node = root;
        populateNext(root.right);
    }

    static class Node {
        int data;
        Node left, right, next;

        public Node(int data) {
            this.data = data;
        }
    }
}
