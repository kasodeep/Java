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
            DeletionMaxHeap.pushDown(arr, i, arr.size() - 1);
        }
    }

    // Time Complexity - O(N)
    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        heap.add(60);
        heap.add(10);
        heap.add(80);
        heap.add(50);
        heap.add(5);
        heap.add(20);
        heap.add(70);
        System.out.println(heap);
        heapify(heap);
        System.out.println(heap);
    }
}
