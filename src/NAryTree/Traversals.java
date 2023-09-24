package NAryTree;

public class Traversals {

    public static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        for (Node node : root.children) {
            preorder(node);
        }
    }

    public static void inorder(Node root) {
        if (root == null)
            return;

        // Visiting All accept Last.
        for (int i = 0; i < root.children.size() - 1; i++) {
            inorder(root.children.get(i));
        }
        System.out.print(root.data + " ");

        // Visiting Last Child.
        if (root.children.size() > 1) {
            inorder(root.children.get(root.children.size() - 1));
        }
    }

    public static void postorder(Node root) {
        if (root == null)
            return;

        for (Node node : root.children) {
            postorder(node);
        }
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

    }
}
