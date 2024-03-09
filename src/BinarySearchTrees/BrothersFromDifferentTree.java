package BinarySearchTrees;

import java.util.HashMap;

public class BrothersFromDifferentTree {

    public static void preorder(Node root, HashMap<Integer, Integer> map) {
        if (root == null) return;

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        preorder(root.left, map);
        preorder(root.right, map);
    }

    public static int count(Node root, HashMap<Integer, Integer> map, int x) {
        if (root == null) return 0;

        int ans = 0;
        if (map.containsKey(x - root.val)) {
            ans += map.get(x - root.val);
        }

        ans += count(root.left, map, x);
        ans += count(root.right, map, x);
        return ans;
    }

    public static int countPairs(Node root1, Node root2, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        preorder(root1, map);
        return count(root2, map, x);
    }
}
