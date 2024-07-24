package Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class HuffManCoding {

    public ArrayList<String> huffmanCodes(String S, int[] f, int N) {
        PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> {
            if (a.data == b.data) {
                return 0;
            }
            return a.data - b.data;
        });

        for (int i = 0; i < f.length; i++) {
            heap.add(new Node(f[i]));
        }

        while (heap.size() >= 2) {
            Node temp1 = heap.remove();
            Node temp2 = heap.remove();
            heap.add(new Node(temp1.data + temp2.data, temp1, temp2));
        }

        Node tree = heap.remove();
        ArrayList<String> ans = new ArrayList<>();
        findCode(tree, "", ans);
        return ans;
    }

    public void findCode(Node root, String str, ArrayList<String> ans) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            ans.add(str);
            return;
        }
        findCode(root.left, str + "0", ans);
        findCode(root.right, str + "1", ans);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
