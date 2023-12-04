package Heaps;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {

    public static void heapSort(List<Integer> arr) {
        Heapify.heapify(arr);
        int n = arr.size() - 1;

        for (int i = n; i > 0; i--) {
            Basics.swap(arr, 0, i);
            DeletionMaxHeap.pushDown(arr, 0, i);
        }
    }

    // Time Complexity - O(N * logN)
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
        heapSort(heap);
        System.out.println(heap);
    }
}
