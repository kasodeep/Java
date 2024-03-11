package BinarySearchTrees;

public class KthSmallest {

    static int KSmallestUsingMorris(Node root, int k) {
        int count = 0;
        int kSmall = Integer.MIN_VALUE;
        Node curr = root;

        // Morris Traversal.
        while (curr != null) {
            if (curr.left == null) {
                count++;
                if (count == k) kSmall = curr.val;
                curr = curr.right;
            } else {
                Node pre = curr.left;
                while (pre.right != null && pre.right != curr)
                    pre = pre.right;
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    count++;
                    if (count == k) kSmall = curr.val;
                    curr = curr.right;
                }
            }
        }
        return kSmall;
    }

    public static void main(String[] args) {

    }
}
