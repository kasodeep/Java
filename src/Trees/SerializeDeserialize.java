package Trees;

import java.util.*;

public class SerializeDeserialize {

    public String serialize(Node root) {
        if (root == null) return "";

        Queue<Node> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }

            res.append(node.val).append(" ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public Node deserialize(String data) {
        if (Objects.equals(data, "")) return null;

        Queue<Node> q = new LinkedList<>();
        String[] values = data.split(" ");

        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);

        for (int i = 1; i < values.length; i++) {
            Node parent = q.poll();

            if (!values[i].equals("n")) {
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }

            if (!values[++i].equals("n")) {
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
