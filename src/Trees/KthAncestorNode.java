package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthAncestorNode {

    static int kthAncestor(Node root, Node node, int k) {
        Stack<Node> s = new Stack<>();
        List<Integer> ancestors = new ArrayList<>();
        boolean found = false;

        while (root != null || !s.empty()) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                Node temp = s.pop();

                if (temp.val == node.val) {
                    found = true;
                    break;
                }
                if (temp.right != null) {
                    root = temp.right;
                }
            }
        }

        if (!found) return -1;

        while (!s.empty() && k > 0) {
            Node temp = s.pop();
            ancestors.add(temp.val);
            k--;
        }

        if (k > 0) {
            return -1;
        }
        return ancestors.get(ancestors.size() - 1);
    }

    public static void main(String[] args) {

    }
}
