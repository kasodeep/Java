package LinkedLists;

import java.util.HashSet;

public class RemoveDuplicatesUnsorted {

    static void removeDuplicate(Node head) {
        HashSet<Integer> hs = new HashSet<>();
        Node current = head;
        Node prev = null;

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
