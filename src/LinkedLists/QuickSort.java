package LinkedLists;

public class QuickSort {

    public static Node<Integer> partitionLast(Node<Integer> start, Node<Integer> end) {
        if (start == end || start == null || end == null)
            return start;

        Node<Integer> pivot_prev = start;
        Node<Integer> curr = start;
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

    public static void sort(Node<Integer> start, Node<Integer> end) {
        if (start == null || start == end || start == end.next)
            return;

        Node<Integer> pivot_prev = partitionLast(start, end);
        sort(start, pivot_prev);

        if (pivot_prev != null && pivot_prev == start)
            sort(pivot_prev.next, end);
        else if (pivot_prev != null && pivot_prev.next != null)
            sort(pivot_prev.next.next, end);
    }

    public static void main(String[] args) {

    }
}
