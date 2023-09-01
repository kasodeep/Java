package LinkedLists;

public class ListCycle {

    public static boolean hasCycle(Node<Integer> head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node<Integer> fast = head;
        Node<Integer> slow = head;
        while (fast != null && slow != null) {
            slow = slow.next;

            if (fast.next == null) return false;
            fast = fast.next.next;

            if (fast == slow) return true;
        }
        return false;
    }

    public static Node<Integer> detectCycle(Node<Integer> head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        Node<Integer> temp = head;

        while (fast != null && slow != null) {
            slow = slow.next;

            if (fast.next == null) return null;
            fast = fast.next.next;

            if (fast == null || slow == null) {
                return null;
            }
            if (fast == slow) break;
        }

        while (temp != slow && slow != null) {
            temp = temp.next;
            slow = slow.next;
        }
        return temp;
    }

    public static void main(String[] args) {

    }
}
