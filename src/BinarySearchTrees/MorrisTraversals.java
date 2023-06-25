package BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversals {

    public static List<Integer> morris(Node root) {
        Node curr = root;
        List<Integer> arr = new ArrayList<>();

        while (curr != null) {
            if (curr.left != null) { // Find Predecessor
                Node pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                if (pre.right == null) { // Connect Predecessor With Current
                    pre.right = curr;
                    curr = curr.left;
                }
                if (pre.right == curr) { // Unlink Predecessor With Current
                    pre.right = null;
                    arr.add(curr.val);
                    curr = curr.right;
                }
            } else { // No Predecessor
                arr.add(curr.val);
                curr = curr.right;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        String[] arr = {"50", "20", "60", "17", "34", "55", "89", "10", "", "28", "", "", "", "70", "", "", "14"};
        Node root = Construct.construct(arr);
        List<Integer> list = morris(root);
        System.out.println(list.toString());
    }
}
