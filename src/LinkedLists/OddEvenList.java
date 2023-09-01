package LinkedLists;

public class OddEvenList {

    public static Node<Integer> oddEvenList(Node<Integer> head) {
        Node<Integer> temp = head;
        Node<Integer> odd = new Node<>(0);
        Node<Integer> even = new Node<>(0);

        Node<Integer> tempo = odd;
        Node<Integer> tempe = even;

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
