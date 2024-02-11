package Trees;

public class LowestCommonAncestor {

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) return root;

        Node right = lowestCommonAncestor(root.right, p, q);
        Node left = lowestCommonAncestor(root.left, p, q);

        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }

    public static void main(String[] args) {

    }
}
