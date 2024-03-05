package LinkedLists;

public class QuickSort {

    public static Node partitionLast(Node start, Node end) {
        if (start == end || start == null || end == null)
            return start;

        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;

        while (start != end) {
            if (start.data < pivot) {
                pivot_prev = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;
        return pivot_prev;
    }

    public static void sort(Node start, Node end) {
        if (start == null || start == end || start == end.next) return;

        Node pivot = partitionLast(start, end);
        sort(start, pivot);

        if (pivot != null && pivot == start) sort(pivot.next, end);
        else if (pivot != null && pivot.next != null) sort(pivot.next.next, end);
    }

    public static void main(String[] args) {

    }
}
