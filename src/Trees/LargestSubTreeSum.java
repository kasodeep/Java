package Trees;

public class LargestSubTreeSum {

    static int ans = Integer.MIN_VALUE;

    public static int dfs(Node root) {
        if (root == null) return 0;

        int sumLeft = dfs(root.left);
        int sumRight = dfs(root.right);
        int sum = sumLeft + sumRight + root.val;

        if (sum > ans) ans = sum;
        return sum;
    }

    public static int findLargestSubtreeSum(Node root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }

    public static void main(String[] args) {

    }
}

