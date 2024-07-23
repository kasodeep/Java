package Heaps;

import java.util.List;

/*
* Full Binary Tree : 0 / 2 child for all nodes.
* Complete Binary Tree : All levels must be filled except the last.
                         Last Level must be filled from left to right.
*
* HEAP : Heap is a data structure which is a Complete Binary Tree, represented in terms of Array and visualized in terms if Tree.
* MAX HEAP : For every node parent must be greater than the children.
* MIN HEAP : For every node parent must be smaller than the children.
*
* Left Child : (2 * i) + 1
* Right Child : (2 * i) + 2
* Parent : (i - 1) / 2
* */
public class Basics {

    /*
    * Utility function to swap the two array elements.
    * */
    public static void swap(List<Integer> heap, int l, int r) {
        int temp = heap.get(l);
        heap.set(l, heap.get(r));
        heap.set(r, temp);
    }

    public static void main(String[] args) {

    }
}
