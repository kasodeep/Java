package DoublyLinkedList;

import java.util.ArrayList;

public class TripletSum {

    public ArrayList<ArrayList<Integer>> tripletSumInLinkedList(Node head, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Node s, m, e;
        s = head;
        e = head;

        // Assigning e to the tail node.
        while (e.next != null) e = e.next;

        while (s.next.next != null) {
            int currSum = sum - s.data;
            m = s.next;
            Node ev = e;
            while (m != null && ev != null && m != ev) {
                int newSum = m.data + ev.data;
                if (newSum == currSum) {
                    ArrayList<Integer> triple = new ArrayList<>();
                    triple.add(s.data);
                    triple.add(m.data);
                    triple.add(ev.data);
                    res.add(triple);
                    m = m.next;
                } else if (newSum > currSum)
                    ev = ev.prev;
                else
                    m = m.next;
            }
            s = s.next;
        }
        return res;
    }
}
