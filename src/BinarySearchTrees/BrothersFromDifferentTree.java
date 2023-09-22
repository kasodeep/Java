package BinarySearchTrees;

import java.util.HashMap;

public class BrothersFromDifferentTree {
    static HashMap<Integer, Integer> map;
    static int count;

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        inorder(root.right);
    }

    static void count(Node root, int x) {
        if (root == null) return;
        count(root.left, x);
        if (map.containsKey(x - root.val)) count += map.get(x - root.val);
        count(root.right, x);
    }

    public static int countPairs(Node root1, Node root2, int x) {
        map = new HashMap<>();
        count = 0;
        inorder(root1);
        count(root2, x);
        return count;
    }

    public static void main(String[] args) {

    }
}
