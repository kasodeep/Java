package LinkedLists;

import java.util.ArrayList;
import java.util.Arrays;

public class CriticalPoint {

    public static boolean is_critical_point(Node<Integer> node) {
        if (node.next.data > node.data && node.prev.data > node.data)
            return true;
        return node.next.data < node.data && node.prev.data < node.data;
    }

    public static ArrayList<Integer> findMaxMin(Node<Integer> head) {
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(2000000000, 2000000000));
        int first = -1, last = -1;

        Node<Integer> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node<Integer> curr = tail.prev;
        if (curr == null)
            return new ArrayList<>(Arrays.asList(-1, -1));

        int pos = 0;
        while (curr != head) {
            if (is_critical_point(curr)) {
                if (first != -1) {
                    ans.set(0, Math.min(ans.get(0), pos - last));
                    ans.set(1, pos - first);
                    last = pos;
                } else {
                    first = last = pos;
                }
            }
            pos++;
            curr = curr.prev;
        }

        if (ans.get(0) == 2e9) {
            ans.set(0, -1);
            ans.set(1, -1);
        }
        return ans;
    }

    public static void main(String[] args) {

    }

    static class Node<T> {
        int data;
        Node<T> next;
        Node<T> prev;

        Node(int data) {
            this.data = data;
        }
    }
}
