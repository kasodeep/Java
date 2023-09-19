package Trees;

import java.util.*;

public class SerializeDeserialize {

    public static String serialize(Node root) {
        if (root == null) return null;

        Stack<Node> s = new Stack<>();
        s.push(root);
        List<String> l = new ArrayList<>();

        while (!s.isEmpty()) {
            Node t = s.pop();

            if (t == null) {
                l.add("#");
            } else {
                l.add(String.valueOf(t.val));
                s.push(t.right);
                s.push(t.left);
            }
        }
        return String.join(",", l);
    }

    public static Node deserialize(String data) {
        if (data == null)
            return null;
        String[] arr = data.split(",");
        return helper(arr, 0);
    }

    public static Node helper(String[] arr, int t) {
        if (arr[t].equals("#"))
            return null;

        Node root = new Node(Integer.parseInt(arr[t]));
        root.left = helper(arr, t + 1);
        root.right = helper(arr, t + 2);
        return root;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {

    }
}
