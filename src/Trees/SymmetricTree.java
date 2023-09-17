package Trees;

/* It is true only if the tree is symmetric about it's root.
 * First invert left/right subtree and compare it they are same. */
public class SymmetricTree {

    public static Node invertTree(Node root) {
        if (root == null)
            return null;
        Node temp = root.left;

        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public static boolean isSameTree(Node p, Node q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

    }
}
