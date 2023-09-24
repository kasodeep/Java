package NAryTree;

import java.util.HashMap;
import java.util.Map;

public class SerializeDeserialize {

    public static String serialize(Node root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }


    private static void serializeHelper(Node node, StringBuilder sb) {
        if (node == null) return;

        sb.append(node.data).append(":").append(node.children.size()).append(":");
        for (Node child : node.children) {
            sb.append(child.data).append(",");
        }

        if (sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("\n");

        for (Node child : node.children) {
            serializeHelper(child, sb);
        }
    }


    // Deserialize an N-ary tree
    public static Node deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] nodes = data.split("\n");
        Map<String, Node> map = new HashMap<>();


        // Create all nodes
        for (String nodeStr : nodes) {
            String[] parts = nodeStr.split(":");

            String val = parts[0];
            int numChildren = Integer.parseInt(parts[1]);
            Node node = new Node(Integer.parseInt(val));
            map.put(val, node);

            for (int i = 0; i < numChildren; i++) {
                node.children.add(null); // Add a placeholder for the child
            }
        }

        // Link all nodes
        for (String nodeStr : nodes) {
            String[] parts = nodeStr.split(":");

            int numChildren = Integer.parseInt(parts[1]);
            if (numChildren == 0) continue;

            String val = parts[0];
            String[] childValues = parts[2].split(",");
            Node node = map.get(val);

            for (int i = 0; i < numChildren; i++) {
                node.children.set(i, map.get(childValues[i]));
            }
        }

        return map.get(nodes[0].split(":")[0]);
    }
}
