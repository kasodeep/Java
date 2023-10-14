package Daily.GfG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CommonNodes {

    static HashSet<Integer> set;
    static ArrayList<Integer> list;

    public static void preorder(TreeNode root) {
        if (root == null) return;
        set.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public static void check(TreeNode root) {
        if (root == null) return;
        if (set.contains(root.val)) list.add(root.val);
        check(root.left);
        check(root.right);
    }

    //Function to find the nodes that are common in both BST.
    public static ArrayList<Integer> findCommon(TreeNode root1, TreeNode root2) {
        set = new HashSet<>();
        list = new ArrayList<>();

        preorder(root1);
        check(root2);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {

    }
}
