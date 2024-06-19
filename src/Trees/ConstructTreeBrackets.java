package Trees;

public class ConstructTreeBrackets {

    static int start = 0;

    static Node constructTree(String s) {
        if (s.length() == 0 || s == null || start >= s.length()) return null;

        boolean neg = false;
        if (s.charAt(start) == '-') {
            neg = true;
            start++;
        }

        int num = 0;
        while (start < s.length() && Character.isDigit(s.charAt(start))) {
            int digit = Character.getNumericValue(s.charAt(start));
            num = num * 10 + digit;
            start++;
        }

        if (neg) num = -num;
        Node node = new Node(num);

        // no root node.
        if (num == 0) {
            start++;
            return null;
        }

        // only root node.
        if (start >= s.length()) {
            return node;
        }

        // Left Node.
        if (start < s.length() && s.charAt(start) == '(') {
            start++;
            node.left = constructTree(s);
        }

        if (start < s.length() && s.charAt(start) == ')') {
            start++;
            return node;
        }

        // Right Tree.
        if (start < s.length() && s.charAt(start) == '(') {
            start++;
            node.right = constructTree(s);
        }

        if (start < s.length() && s.charAt(start) == ')') {
            start++;
            return node;
        }

        return node;
    }

    // Print tree function
    public static void printTree(Node node) {
        if (node == null)
            return;

        System.out.println(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        Node root = constructTree(s);
        printTree(root);
    }
}

