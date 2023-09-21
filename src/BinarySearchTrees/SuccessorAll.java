package BinarySearchTrees;

public class SuccessorAll {

    Node node = null;

    public static void main(String[] args) {

    }

    public void populateNext(Node root) {
        if (root == null)
            return;
        populateNext(root.left);
        if (node != null) {
            node.next = root;
        }
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
