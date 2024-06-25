package HashMaps;

import java.util.LinkedList;

public class MyHashMap<K, V> {

    public static final int DEFAULT_CAPACITY = 4;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int n; // the number of entries in the map.
    private LinkedList<Node>[] buckets;

    public MyHashMap() {
        initBuckets(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    private void initBuckets(int N) { // N - capacity/size of buckets array.
        buckets = new LinkedList[N];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int HashFunc(K key) {
        int hc = key.hashCode();
        return (Math.abs(hc)) % buckets.length;
    }

    // Traverse the ll and look for a node with key.
    private int searchInBucket(LinkedList<Node> ll, K key) {
        for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i).key == key) {
                return i;
            }
        }
        return -1;
    }

    private void rehash() {
        LinkedList<Node>[] oldBuckets = buckets;
        initBuckets(oldBuckets.length * 2);
        n = 0;

        for (var bucket : oldBuckets) {
            for (var node : bucket) {
                put(node.key, node.value);
            }
        }
    }

    public int size() { // returns the number of entries in map.
        return n;
    }

    public void put(K key, V value) {
        int bi = HashFunc(key);
        LinkedList<Node> currBucket = buckets[bi];
        int ei = searchInBucket(currBucket, key);

        if (ei == -1) { // key doesn't exists
            Node node = new Node(key, value);
            currBucket.add(node);
            n++;
        } else {
            Node currNode = currBucket.get(ei);
            currNode.value = value;
        }

        if (n >= buckets.length * DEFAULT_LOAD_FACTOR) {
            rehash();
        }
    }

    public V get(K key) {
        int bi = HashFunc(key);
        LinkedList<Node> currBucket = buckets[bi];
        int ei = searchInBucket(currBucket, key);

        if (ei != -1) { // key exists
            Node currNode = currBucket.get(ei);
            return currNode.value;
        }
        return null;
    }

    public V remove(K key) {
        int bi = HashFunc(key);
        LinkedList<Node> currBucket = buckets[bi];
        int ei = searchInBucket(currBucket, key);

        if (ei != -1) { // key exists
            Node currNode = currBucket.get(ei);
            V val = currNode.value;
            currBucket.remove(ei);
            n--;
            return val;
        }
        return null;
    }

    private class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
