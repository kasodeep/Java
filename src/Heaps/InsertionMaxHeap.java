package Heaps;

import java.util.ArrayList;
import java.util.List;

/*
 * 1) Insert at the last.
 * 2) Make sure that the new node is at correct position.
 * */
public class InsertionMaxHeap {

    public static void insert(List<Integer> heap, int element) {
        heap.add(element);
        int index = heap.size() - 1;
        pushUp(heap, index);
    }

    public static void pushUp(List<Integer> heap, int i) {
        int parent_index = (i - 1) / 2;

        // Base Case
        if (i == 0 || heap.get(parent_index) > heap.get(i)) return;

        Basics.swap(heap, i, parent_index);
        pushUp(heap, parent_index);
    }

    // Time Complexity - O(logN)
    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        heap.add(80);
        heap.add(50);
        heap.add(70);
        heap.add(10);
        heap.add(20);
        System.out.println(heap);
        insert(heap, 90);
        System.out.println(heap);
    }
}
