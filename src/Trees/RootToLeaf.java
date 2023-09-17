package Trees;

import java.util.ArrayList;
import java.util.List;

public class RootToLeaf {

    public static void helper(Node root, List<StringBuilder> list, StringBuilder s) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            s.append(root.val);
            list.add(s);
            return;
        }

        helper(root.left, list, s.append(root.val).append("->"));
        helper(root.right, list, s.append(root.val).append("->"));
    }

    public static List<StringBuilder> binaryTreePaths(Node root) {
        List<StringBuilder> list = new ArrayList<>();
        helper(root, list, new StringBuilder());
        return list;
    }

    public static void main(String[] args) {

    }
}
