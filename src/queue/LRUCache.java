package queue;


import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache {

    private final int CACHE_SIZE;

    private final Deque<Integer> doublyQueue;

    private final HashSet<Integer> hashSet;

    LRUCache(int capacity) {
        doublyQueue = new LinkedList<>();
        hashSet = new HashSet<>();
        CACHE_SIZE = capacity;
    }

    /* add -> First, remove -> Last. */
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.display();
    }

    public void refer(int page) {
        if (!hashSet.contains(page)) {
            if (doublyQueue.size() == CACHE_SIZE) {
                int last = doublyQueue.removeLast();
                hashSet.remove(last);
            }
        } else {
            doublyQueue.remove(page);
        }
        doublyQueue.push(page);
        hashSet.add(page);
    }

    public void display() {
        for (Integer integer : doublyQueue) {
            System.out.print(integer + " ");
        }
    }
}

