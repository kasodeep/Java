package BinarySearchTrees;

public class LowestAncestor {

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else return root;
    }

    public static void main(String[] args) {
        String[] arr = {"50", "20", "60", "17", "34", "55", "89", "10", "", "28", "", "", "", "70", "", "", "14"};
        Node root = Construct.construct(arr);
//        System.out.println(lowestCommonAncestor(root, "", ""));
    }
}
