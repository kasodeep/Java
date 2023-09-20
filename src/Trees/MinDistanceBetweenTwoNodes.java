package Trees;

public class MinDistanceBetweenTwoNodes {

    public static int ans;

    public static int _findDistance(Node root, int n1, int n2) {
        if (root == null) return 0;
        int left = _findDistance(root.left, n1, n2);
        int right = _findDistance(root.right, n1, n2);

        if (root.val == n1 || root.val == n2) {
            if (left != 0 || right != 0) {
                ans = Math.max(left, right);
                return 0;
            } else
                return 1;
        } else if (left != 0 && right != 0) {
            ans = left + right;
            return 0;
        } else if (left != 0 || right != 0)
            return Math.max(left, right) + 1;
        return 0;
    }

    public static int findDistance(Node root, int n1, int n2) {
        ans = 0;
        _findDistance(root, n1, n2);
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println("Dist(4, 5) = " + findDistance(root, 4, 5));
        System.out.println("Dist(4, 6) = " + findDistance(root, 4, 6));
        System.out.println("Dist(3, 4) = " + findDistance(root, 3, 4));
        System.out.println("Dist(2, 4) = " + findDistance(root, 2, 4));
        System.out.println("Dist(8, 5) = " + findDistance(root, 8, 5));
    }
}
