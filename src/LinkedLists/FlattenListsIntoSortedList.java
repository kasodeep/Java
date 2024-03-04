package LinkedLists;

public class FlattenListsIntoSortedList {

    public static Node merge(Node first, Node second) {
        if (first == null) return second;
        if (second == null) return first;

        // Recursive calls.
        Node ans;
        if (first.data < second.data) {
            ans = first;
            ans.bottom = merge(first.bottom, second);
        } else {
            ans = second;
            ans.bottom = merge(first, second.bottom);
        }
        ans.next = null;
        return ans;
    }

    public static Node flatten(Node root) {
        if (root == null || root.next == null) return root;
        return merge(root, flatten(root.next));
    }

    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }
}
