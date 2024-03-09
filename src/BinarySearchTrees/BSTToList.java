package BinarySearchTrees;

public class BSTToList {

    static void inorder(Node curr, Node[] head) {
        if (curr == null) return;

        inorder(curr.right, head);
        curr.right = head[0];
        if (head[0] != null) head[0].left = null;
        head[0] = curr;

        inorder(curr.left, head);
    }

    static Node flatten(Node parent) {
        Node[] head = new Node[1];
        inorder(parent, head);
        head[0].left = null;

        return head[0];
    }

    public static void main(String[] args) {

    }
}
