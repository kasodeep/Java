package Trees;

import java.util.HashSet;

public class DuplicateTree {

    static HashSet<String> set = new HashSet<>();
    static boolean flag = false;

    public static String helper(Node root) {
        if (root == null) return "";

        String left = helper(root.left);
        String right = helper(root.right);
        String curr = root.val + " " + left + " " + right;

        if (set.contains(curr) && curr.length() > 5) flag = true;
        set.add(curr);
        return curr;
    }

    static int dupSub(Node root) {
        helper(root);
        return flag ? 1 : 0;
    }

    public static void main(String[] args) {

    }
}

