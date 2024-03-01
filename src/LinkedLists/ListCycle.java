package LinkedLists;

public class ListCycle {

    public static boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) return true;
        }
        return false;
    }

    /**
     * x denotes the length of the linked list before starting the cycle.
     * y denotes the distance from the start of the cycle to where slow and fast met.
     * C denotes the length of the cycle
     * when they meet, slow traveled (x + y) steps while fast traveled 2 * (x + y) steps, and the extra distance (x + y) must be a multiple of the circle length C
     */
    public static Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void removeLoop(Node head) {
        Node fast = head;
        Node slow = head;
        Node prev = fast;

        while (fast != null && fast.next != null) {

            // This because if they meet at the head.
            prev = fast.next;
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) return;
        while (fast != head) {
            prev = fast;
            fast = fast.next;
            head = head.next;
        }
        prev.next = null;
    }

    public static void main(String[] args) {

    }
}
