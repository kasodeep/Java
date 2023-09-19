package Trees;

public class LongestRootToLeafSum {
    static int maxLen;
    static int maxSum;

    static void sumOfLongRootToLeafPath(Node root, int sum, int len) {
        if (root == null) {
            if (maxLen < len) {
                maxLen = len;
                maxSum = sum;
            } else if (maxLen == len && maxSum < sum)
                maxSum = sum;
            return;
        }

        sumOfLongRootToLeafPath(root.left, sum + root.val, len + 1);
        sumOfLongRootToLeafPath(root.right, sum + root.val, len + 1);
    }

    static int sumOfLongRootToLeafPathUtil(Node root) {
        if (root == null)
            return 0;

        maxSum = Integer.MIN_VALUE;
        maxLen = 0;
        sumOfLongRootToLeafPath(root, 0, 0);
        return maxSum;
    }
}
