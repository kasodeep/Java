package Trees;

public class KthAncestorNode {

    static Node temp = null;
    static int k;

    static Node kthAncestorDFS(Node root, int node) {
        if (root == null)
            return null;

        if (root.val == node || (temp = kthAncestorDFS(root.left, node)) != null || (temp = kthAncestorDFS(root.right, node)) != null) {
            if (k > 0)
                k--;
            else if (k == 0) {
                System.out.print("Kth ancestor is: " + root.val);
                return null;
            }
            return root;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
