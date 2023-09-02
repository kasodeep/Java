package LinkedLists;

import java.util.HashSet;

public class RemoveDuplicates {

    static void removeDuplicate(Node<Integer> head) {
        HashSet<Integer> hs = new HashSet<>();
        Node<Integer> current = head;
        Node<Integer> prev = null;

        while (current != null) {
            int currValue = current.data;
            if (hs.contains(currValue)) {
                prev.next = current.next;
            } else {
                hs.add(currValue);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {

    }
}
