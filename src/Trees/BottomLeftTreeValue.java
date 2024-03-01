package Trees;

public class BottomLeftTreeValue {

    public static int findBottomLeftValue(Node root) {
        int[] result = new int[]{0, 0};
        help(root, 1, result);
        return result[1];
    }

    private static void help(Node node, int currD, int[] result) {
        if (node == null) return;

        if (currD > result[0]) {
            result[0] = currD;
            result[1] = node.val;
        }

        help(node.left, currD + 1, result);
        help(node.right, currD + 1, result);
    }
}
