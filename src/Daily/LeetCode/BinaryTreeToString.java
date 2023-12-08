package Daily.LeetCode;

public class BinaryTreeToString {

    public static String tree2str(TreeNode t) {
        StringBuilder res = new StringBuilder();
        dfs(t, res);
        return res.toString();
    }

    public static void dfs(TreeNode t, StringBuilder res) {
        if (t == null) return;
        // Value.
        res.append(t.val);
        if (t.left == null && t.right == null) return;

        // Left Part.
        res.append('(');
        dfs(t.left, res);
        res.append(')');

        // Right Part.
        if (t.right != null) {
            res.append('(');
            dfs(t.right, res);
            res.append(')');
        }
    }

    public static void main(String[] args) {

    }
}
