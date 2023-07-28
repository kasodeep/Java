package Heaps;

import java.util.ArrayList;
import java.util.List;

/*
 * Create a heap from an array of numbers.
 * Insertion : O(N * logN)
 * Heapify : Push down each node from 1st leaf node till root.
 * */
public class Heapify {

    public static void heapify(List<Integer> arr) {
        int firstNoneLeaf = (arr.size() - 2) / 2;

        for (int i = firstNoneLeaf; i >= 0; i--) {
            DeletionMinHeap.pushDown(arr, i, arr.size() - 1);
        }
    }

    // Time Complexity - O(N)
    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        heap.add(5);
        heap.add(42);
        heap.add(13);
        heap.add(26);
        heap.add(3);
        System.out.println(heap);
        heapify(heap);
        System.out.println(heap);
    }
}
