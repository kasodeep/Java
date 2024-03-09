package BinarySearchTrees;

public class MinimumDistanceTwoNodes {

    static int distanceFromRoot(Node root, int x) {
        if (root.val == x) return 0;
        else if (root.val > x) return 1 + distanceFromRoot(root.left, x);
        return 1 + distanceFromRoot(root.right, x);
    }

    static int distanceBetween2(Node root, int a, int b) {
        if (root == null) return 0;

        if (root.val > a && root.val > b) return distanceBetween2(root.left, a, b);
        if (root.val < a && root.val < b) return distanceBetween2(root.right, a, b);

        if (root.val >= a && root.val <= b) return distanceFromRoot(root, a) + distanceFromRoot(root, b);
        return 0;
    }
}
