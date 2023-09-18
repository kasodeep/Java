package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class VirusKiller {

    // Getting the node whose value is start.
    public static Node getNode(Node root, int start) {
        if (root == null) return null;
        if (root.val == start) return root;

        Node left = getNode(root.left, start);
        Node right = getNode(root.right, start);

        if (left == null) return right;
        else return left;
    }

    // Doing preorder traversal to map children to parent.
    public static void preorder(Node root, Map<Node, Node> p) {
        if (root == null) return;
        if (root.left != null) p.put(root.left, root);
        if (root.right != null) p.put(root.right, root);

        preorder(root.left, p);
        preorder(root.right, p);
    }

    // Finding the amount of time to infect the whole tree.
    public static int amountOfTime(Node root, int start) {
        Node node = getNode(root, start);
        Map<Node, Node> p = new HashMap<>();
        preorder(root, p);

        // BFS
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Map<Node, Integer> v = new HashMap<>();
        v.put(node, 0);

        while (q.size() > 0) {
            Node temp = q.remove();
            int level = v.get(temp);

            if (temp.left != null && !v.containsKey(temp.left)) {
                q.add(temp.left);
                v.put(temp.left, level + 1);
            }
            if (temp.right != null && !v.containsKey(temp.right)) {
                q.add(temp.right);
                v.put(temp.right, level + 1);
            }
            if (p.containsKey(temp) && !v.containsKey(p.get(temp))) {
                q.add(p.get(temp));
                v.put(p.get(temp), level + 1);
            }
        }

        int max = -1;
        for (int level : v.values()) {
            max = Math.max(max, level);
        }
        return max;
    }

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5", "6", "7"};
        Node root = ConstructTree.construct(arr);
        System.out.println(amountOfTime(root, 4));
    }
}
