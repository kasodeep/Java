package Trees;

public class LargestSubTreeSum {

    static int ans = Integer.MIN_VALUE;

    static int dfs(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;

        int sumLeft = dfs(root.left);
        int sumRight = dfs(root.right);
        int sum = sumLeft + sumRight + root.val;

        ans = Math.max(ans, Math.max(Math.max(sumLeft, sumRight), sum));
        return sum;
    }

    static int findLargestSubtreeSum(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;
        dfs(root);
        return ans;
    }

    public static void main(String[] args) {

    }
}

