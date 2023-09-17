package Trees;

public class LowestCommonAncestor {

    public static boolean contains(Node root, Node node) {
        if (root == null)
            return false;
        if (root == node)
            return true;
        return contains(root.left, node) || contains(root.right, node);
    }

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (p == null || q == null)
            return root;
        if (p == q)
            return p;
        if (p == root || q == root)
            return root;

        boolean leftCheckP = contains(root.left, p);
        boolean rightCheckQ = contains(root.right, q);

        if ((leftCheckP && rightCheckQ) || (!leftCheckP && !rightCheckQ))
            return root;
        if (leftCheckP && !rightCheckQ)
            return lowestCommonAncestor(root.left, p, q);
        if (!leftCheckP && rightCheckQ)
            return lowestCommonAncestor(root.right, p, q);
        return null;
    }

    public static void main(String[] args) {

    }
}
