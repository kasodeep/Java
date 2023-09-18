package Trees;

public class BoundaryTraversal {

    static void printLeftBoundary(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            System.out.print(root.val + " ");
        }
        if (root.left != null) {
            printLeftBoundary(root.left);
        } else {
            printLeftBoundary(root.right);
        }
    }

    // Function to print the right boundary nodes of a binary tree
    static void printRightBoundary(Node root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            printRightBoundary(root.right);
        } else {
            printRightBoundary(root.left);
        }
        if (root.left != null || root.right != null) {
            System.out.print(root.val + " ");
        }
    }

    // Function to print the leaves of a binary tree
    static void printLeaves(Node root) {
        if (root == null) {
            return;
        }
        printLeaves(root.left);
        if (root.left == null && root.right == null) {
            System.out.print(root.val + " ");
        }
        printLeaves(root.right);
    }

    // Function to print the boundary nodes of a binary tree in anticlockwise order
    static void printBoundary(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }

    public static void main(String[] args) {

    }
}
