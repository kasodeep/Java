package Heaps;

import java.util.ArrayList;
import java.util.List;

/*
 * 1) Swap first and last.
 * 2) Delete last element.
 * 3) Push down till correct position.
 * */
public class DeletionMinHeap {

    public static void delete(List<Integer> heap) {
        Basics.swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        pushDown(heap, 0, heap.size() - 1);
    }

    public static void pushDown(List<Integer> heap, int i, int n) {
        if (i == n) return;

        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
        int smallest = i;

        if (left <= n && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right <= n && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest == i) return;

        Basics.swap(heap, i, smallest);
        pushDown(heap, smallest, n);
    }

    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        heap.add(10);
        heap.add(20);
        heap.add(30);
        heap.add(40);
        heap.add(50);
        System.out.println(heap);
        delete(heap);
        System.out.println(heap);
    }
}
