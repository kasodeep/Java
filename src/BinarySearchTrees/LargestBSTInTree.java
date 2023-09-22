package BinarySearchTrees;

public class LargestBSTInTree {

    static int MAX = Integer.MAX_VALUE;
    static int MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {
        final Node node1 = new Node(60);
        node1.left = new Node(65);
        node1.right = new Node(70);
        node1.left.left = new Node(50);

        System.out.print("Size of the largest BST is " + largestBst(node1) + "\n");
    }

    static nodeInfo largestBST(Node root) {

        if (root == null) {
            return new nodeInfo(0, MIN, MAX, true);
        }

        nodeInfo left = largestBST(root.left);
        nodeInfo right = largestBST(root.right);

        nodeInfo returnInfo = new nodeInfo();

        returnInfo.min = Math.min(left.min, root.val);
        returnInfo.max = Math.max(right.max, root.val);

        // Crazy Stuff.
        returnInfo.isBST = left.isBST && right.isBST && root.val > left.max && root.val < right.min;

        if (returnInfo.isBST)
            returnInfo.size = left.size + right.size + 1;
        else
            returnInfo.size = Math.max(left.size, right.size);
        return returnInfo;
    }

    static int largestBst(Node root) {
        return largestBST(root).size;
    }

    static class nodeInfo {
        int size;
        int max;
        int min;
        boolean isBST;

        nodeInfo() {
        }

        nodeInfo(int size, int max, int min, boolean isBST) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }
}

