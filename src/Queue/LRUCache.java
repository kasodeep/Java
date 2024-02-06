package Queue;


import java.util.HashMap;

public class LRUCache {
    static int capacity;

    static HashMap<Integer, Node> cache;

    static Node head;

    static Node tail;

    LRUCache(int cap) {
        capacity = cap;
        cache = new HashMap<>(cap);
        head = null;
        tail = null;
    }

    public static int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToFront(node);
            return node.value;
        }
        return -1;
    }

    public static void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
            return;
        }

        Node node = new Node(key, value);
        if (cache.size() == capacity) {
            cache.remove(tail.key);
            remove(tail);
        }

        addToFront(node);
        cache.put(key, node);
    }

    static void moveToFront(Node node) {
        remove(node);
        addToFront(node);
    }

    static void remove(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;

        if (prevNode != null) prevNode.next = nextNode;
        else head = nextNode;

        if (nextNode != null) nextNode.prev = prevNode;
        else tail = prevNode;
    }

    static void addToFront(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) head.prev = node;
        if (tail == null) tail = node;
        head = node;
    }

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}



