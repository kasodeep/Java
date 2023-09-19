package Trees;

import java.util.*;

public class AllDuplicateTrees {

    Map<String, Integer> map = new HashMap<>();
    List<Node> result = new ArrayList<>();

    public static void main(String[] args) {

    }

    public String helper(Node root) {
        if (root == null) return "";

        String left = helper(root.left);
        String right = helper(root.right);
        String curr = root.val + " " + left + " " + right;

        if (map.getOrDefault(curr, 0) == 1) {
            result.add(root);
        }

        map.put(curr, map.getOrDefault(curr, 0) + 1);
        return curr;
    }

    List<Node> printAllDuplicates(Node root) {
        helper(root);
        result.sort(Comparator.comparingInt(n -> n.val));
        return result;
    }
}
