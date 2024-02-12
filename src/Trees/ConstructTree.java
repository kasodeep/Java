package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Constructing a binary tree based on the given array as it is of prime importance.
 */
public class ConstructTree {

    public static Node construct(String[] arr) {
        int x = Integer.parseInt(arr[0]);
        int n = arr.length;

        Node root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (i < n - 1) {
            Node temp = q.remove();
            Node left = new Node(10);
            Node right = new Node(10);

            if (arr[i].equals("")) {
                left = null;
            } else {
                left.val = Integer.parseInt(arr[i]);
                q.add(left);
            }

            if (arr[i + 1].equals("")) {
                right = null;
            } else {
                right.val = Integer.parseInt(arr[i + 1]);
                q.add(right);
            }

            temp.left = left;
            temp.right = right;
            i += 2;
        }
        return root;
    }

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5", "", "6", "7", "", "8", "", "9", "10", "", "11", "",
                "12", "", "13", "", "14", "15", "16", "", "17", "", "", "18", "", "19", "", "", "",
                "20", "21", "22", "23", "", "24", "25", "26", "27", "", "", "28", "", ""};
        Node root = construct(arr);

    }
}
