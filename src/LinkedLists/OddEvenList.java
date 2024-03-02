package LinkedLists;

public class OddEvenList {

    public static Node oddEvenList(Node head) {
        Node temp = head;
        Node odd = new Node(0);
        Node even = new Node(0);

        Node tempo = odd;
        Node tempe = even;

        while (temp != null) {
            tempo.next = temp;
            temp = temp.next;
            tempo = tempo.next;

            tempe.next = temp;
            if (temp == null) break;
            temp = temp.next;
            tempe = tempe.next;
        }

        tempo.next = even.next;
        return odd.next;
    }

    public static void main(String[] args) {

    }
}
