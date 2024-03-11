package BinarySearchTrees;

public class MedianInO1 {

    /**
     * Function to count the number of nodes, using Morris Traversals.
     */
    static int countNodes(Node root) {
        Node current, pre;
        int count = 0;
        if (root == null) return count;

        current = root;
        while (current != null) {
            if (current.left == null) {
                count++;
                current = current.right;
            } else {
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    count++;
                    current = current.right;
                }
            }
        }
        return count;
    }

    /**
     * Finding the median using Morris Traversal.
     */
    public static float findMedian(Node root) {
        if (root == null) return 0;

        int count = countNodes(root);
        int currCount = 0;
        Node current = root, pre, prev = null;

        while (current != null) {
            if (current.left == null) {
                currCount++;

                float utility = Utility(prev, current, currCount, count);
                if (utility != -1) return utility;

                prev = current;
                current = current.right;
            } else {
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    prev = pre;
                    currCount++;

                    float utility = Utility(prev, current, currCount, count);
                    if (utility != -1) return utility;

                    prev = current;
                    current = current.right;

                }
            }
        }
        return -1F;
    }

    public static float Utility(Node prev, Node current, int currCount, int count) {
        // Odd case
        if (count % 2 != 0 && currCount == (count + 1) / 2)
            return current.val;

            // Even case
        else if (count % 2 == 0 && currCount == (count / 2) + 1)
            return ((float) prev.val + current.val) / 2;
        return -1;
    }
}
