package Trees;

public class SumTree {
    static boolean f = true;

    public static int check(Node root) {
        int s = 0;
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        int l = check(root.left);
        int r = check(root.right);
        if (l + r != root.val) f = false;
        return l + r + root.val;
    }

    static boolean isSumTree(Node root) {
        check(root);
        return f;
    }

    int sumTree(Node root) {
        if (root == null) return 0;

        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        int x = root.val;
        int tSum = leftSum + rightSum;

        root.val = tSum;
        return tSum + x;
    }

    public void toSumTree(Node root) {
        sumTree(root);
    }
}
