package BinarySearchTrees;

public class ValidBST {

    static boolean flag = true;
    static Node prev = null;

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);

        if (prev == null) {
            prev = root;
        } else if (root.val <= prev.val) {
            flag = false;
        } else {
            prev = root;
        }
        inorder(root.right);
    }

    public static void main(String[] args) {
        String[] arr = {"50", "20", "60", "17", "34", "55", "89", "10", "", "28", "", "", "", "70", "", "", "14"};
        Node root = Construct.construct(arr);
        
        inorder(root);
        System.out.println(flag);
    }
}
