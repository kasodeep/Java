package BinarySearchTrees;

public class BSTToList {

    static Node prev;

    static void Inorder(Node curr) {
        if (curr == null)
            return;
        Inorder(curr.left);

        prev.left = null;
        prev.right = curr;
        prev = curr;

        Inorder(curr.right);
    }

    static Node flatten(Node parent) {
        Node dummy = new Node(-1);
        prev = dummy;
        Inorder(parent);

        prev.left = null;
        prev.right = null;
        return dummy.right;
    }

    public static void main(String[] args) {

    }
}
