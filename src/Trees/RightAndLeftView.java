package Trees;

import java.util.ArrayList;
import java.util.List;

public class RightAndLeftView {

    public static int height(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void preorder(Node root, List<Integer> ans, int level) {
        if (root == null) return;
        ans.set(level - 1, root.val);
        preorder(root.left, ans, level + 1);
        preorder(root.right, ans, level + 1);
    }

    public static void postorder(Node root, List<Integer> ans, int level) {
        if (root == null) return;
        ans.set(level - 1, root.val);
        postorder(root.right, ans, level + 1);
        postorder(root.left, ans, level + 1);
    }

    public static List<Integer> rightSideView(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        int level = height(root) + 1;

        for (int i = 0; i < level; i++) ans.add(100);
        preorder(root, ans, 1);
        return ans;
    }

    public static List<Integer> leftSideView(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        int level = height(root) + 1;

        for (int i = 0; i < level; i++) ans.add(100);
        postorder(root, ans, 1);
        return ans;
    }

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5", "6", "7"};
        Node root = ConstructTree.construct(arr);

        List<Integer> right = rightSideView(root);
        List<Integer> left = leftSideView(root);
        System.out.println(right);
        System.out.println(left);
    }
}
