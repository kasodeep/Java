package Trees;

public class FlattenTree {

    /* In this approach we are using recursion to flatten a tree.
     * It causes us to use O(H) extra space in terms of recursion calls;
     * We have to store values in preorder format.
     * Time Complexity of this approach is O(N).
     */
    public static void flatten(Node root) {
        if (root == null) return;
        Node leftTree = root.left;
        Node rightTree = root.right;
        root.left = null;

        flatten(leftTree);
        flatten(rightTree);
        root.right = leftTree;

        Node temp = leftTree;
        while (temp != null && temp.right != null) {
            temp = temp.right;
        }

        if (temp != null) temp.right = rightTree;
        else root.right = rightTree;
    }

    /*
     * This approach is known as Morris Traversal, it uses O(1) extra space.
     * It is similar to a linked list being reversed we use two pointers.
     * */
    public static void flattenMorris(Node root) {
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                Node predecessor = curr.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                predecessor.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5", "6", "7"};
        Node root = ConstructTree.construct(arr);
        flattenMorris(root);

        int i = 0;
        while (root != null) {
            if (root.left == null) continue;
            else System.err.println("Test Failed");
            root = root.right;
        }
    }
}
