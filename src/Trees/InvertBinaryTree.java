package Trees;

public class InvertBinaryTree {

    public static Node invertTree(Node root) {
        if (root == null) return null;
        Node temp = root.left;

        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    /* Time Complexity - O(n), Auxiliary Space - O(h) */
    public static void main(String[] args) {

    }
}
