package Trees;

import java.util.ArrayList;

public class LeafSimilar {

    public static void preorder(ArrayList<Integer> list, Node root) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            preorder(list, root.left);
            preorder(list, root.right);
        }
    }

    public static boolean leafSimilar(Node root1, Node root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        preorder(list1, root1);
        preorder(list2, root2);
        return list1.equals(list2);
    }

    public static void main(String[] args) {

    }
}
