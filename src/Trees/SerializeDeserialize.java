package Trees;

import java.util.*;

public class SerializeDeserialize {

    public static ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while (q.size() > 0) {
            Node curr = q.poll();
            if (curr == null) list.add(0);
            else list.add(curr.val);

            if (curr != null) {
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return list;
    }

    public static Node deSerialize(ArrayList<Integer> a) {
        Node root = new Node(a.get(0));
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        int i = 1;

        while (!q.isEmpty() && i < a.size()) {
            Node p = q.remove();
            if (a.get(i) == 0) p.left = null;
            else {
                p.left = new Node(a.get(i));
                q.add(p.left);
            }

            i++;
            if (a.get(i) == 0) p.right = null;
            else {
                p.right = new Node(a.get(i));
                q.add(p.right);
            }
            i++;
        }
        return root;
    }
}
