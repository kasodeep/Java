package BinarySearchTrees;

public class LargestBSTInTree {

    static int MAX = Integer.MAX_VALUE;
    static int MIN = Integer.MIN_VALUE;

    static NodeInfo largestBST(Node root) {
        if (root == null) {
            return new NodeInfo(0, MIN, MAX, true);
        }

        NodeInfo left = largestBST(root.left);
        NodeInfo right = largestBST(root.right);

        NodeInfo returnInfo = new NodeInfo();

        returnInfo.min = Math.min(left.min, root.val);
        returnInfo.max = Math.max(right.max, root.val);

        // Crazy Stuff.
        returnInfo.isBST = left.isBST && right.isBST && root.val > left.max && root.val < right.min;

        if (returnInfo.isBST) returnInfo.size = left.size + right.size + 1;
        else returnInfo.size = Math.max(left.size, right.size);
        return returnInfo;
    }

    static int largestBst(Node root) {
        return largestBST(root).size;
    }

    static class NodeInfo {
        int size; int max;
        int min; boolean isBST;

        NodeInfo() {
        }

        NodeInfo(int size, int max, int min, boolean isBST) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }
}

