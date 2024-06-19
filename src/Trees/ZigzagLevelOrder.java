package Trees;

import java.util.*;

/* It means to travel in level order, but in an alternate fashion. */
public class ZigzagLevelOrder {

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        int flag = 1;
        while (q.size() > 0) {
            int size = q.size();
            List<Integer> part = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node temp = q.remove();
                part.add(temp.val);

                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }

            if (flag % 2 == 0) Collections.reverse(part);
            ans.add(part);
            flag++;
        }
        return ans;
    }
}
