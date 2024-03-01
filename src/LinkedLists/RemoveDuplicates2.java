package LinkedLists;

public class RemoveDuplicates2 {

    public Node deleteDuplicates(Node head) {
        Node extra = new Node(101);
        extra.next = head;

        Node temp = head;
        Node prev = extra;
        while (temp != null) {
            int data = temp.data;

            boolean flag = false;
            while (temp.next != null && temp.next.data == data) {
                flag = true;
                temp = temp.next;
            }

            if (flag) prev.next = temp.next;
            else prev = temp;
            temp = temp.next;
        }
        return extra.next;
    }
}

