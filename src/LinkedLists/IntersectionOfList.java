package LinkedLists;

public class IntersectionOfList {

    public static Node<Integer> getIntersectionNode(Node<Integer> headA, Node<Integer> headB) {
        Node<Integer> tempA = headA;
        Node<Integer> tempB = headB;
        int lengthA = 0, lengthB = 0;

        while (tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }

        while (tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }

        // Reinitialize.
        tempA = headA;
        tempB = headB;

        if (lengthA > lengthB) {
            int steps = lengthA - lengthB;
            for (int i = 0; i < steps; i++) {
                tempA = tempA.next;
            }
        } else {
            int steps = lengthB - lengthA;
            for (int i = 0; i < steps; i++) {
                tempB = tempB.next;
            }
        }

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {

    }
}
