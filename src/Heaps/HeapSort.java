package Heaps;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {

    public static void heapSort(List<Integer> arr) {
        Heapify.heapify(arr);
        int n = arr.size() - 1;

        for (int i = n; i > 0; i--) {
            Basics.swap(arr, 0, i);
            DeletionMinHeap.pushDown(arr, 0, i);
        }
    }

    // Time Complexity - O(N * logN)
    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        heap.add(5);
        heap.add(42);
        heap.add(13);
        heap.add(26);
        heap.add(3);
        System.out.println(heap);
        heapSort(heap);
        System.out.println(heap);
    }
}
