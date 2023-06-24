package BinarySearchTrees;

public class Delete {

    /**
     * Delete function to delete the given node with the constraint of binary tree.
     */
    public static void delete(Node root, int target) {
        if (root == null) return;
        if (root.val > target) {
            if (root.left == null) return;

            if (root.left.val == target) {
                Node l = root.left; // l is the node to be deleted.

                // 0 Children
                if (l.left == null && l.right == null)
                    root.left = null;

                // 1 Children
                else if (l.left == null || l.right == null) {
                    if (l.left != null) root.left = l.left;
                    else root.left = l.right;
                }

                // 2 Children
                else {
                    Node pred = l.left;
                    while (pred.right != null) pred = pred.right;
                    delete(root, pred.val);
                    pred.left = l.left;
                    pred.right = l.right;
                    root.left = pred;
                }
            } else
                delete(root.left, target);
        } else {
            if (root.right == null) return;

            if (root.right.val == target) {
                Node r = root.right; // r is the node to be deleted.

                // 0 Children
                if (r.left == null && r.right == null)
                    root.right = null;
                    // 1 Children
                else if (r.left == null || r.right == null) {
                    if (r.left != null) root.right = r.left;
                    else root.right = r.right;
                }
                // 2 Children
                else {
                    Node pred = r.left;
                    while (pred.right != null) pred = pred.right;
                    delete(root, pred.val);
                    pred.left = r.left;
                    pred.right = r.right;
                    root.right = pred;
                }
            } else
                delete(root.right, target);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"50", "20", "60", "17", "34", "55", "89", "10", "", "28", "", "", "", "70", "", "", "14"};
        Node root = Construct.construct(arr);

        //  Doing this to avoid error while deleting root node.
        Node temp = new Node(Integer.MAX_VALUE);
        temp.left = root;
        delete(temp, 50);
    }
}
