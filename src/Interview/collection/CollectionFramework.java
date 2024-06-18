package Interview.collection;

import java.util.*;

/**
 * Collection Interface is extended by List, Queue, Set interfaces.
 * Map Interface is implemented by HashMap, HashTable, SortedMap (interface)
 * <p>
 * List -> ArrayList, LinkedList, Stack, Vector.
 * Queue -> LinkedList (Queue), PriorityQueue, ArrayDeque(can also be used as a stack).
 * Set -> HashSet, TreeSet, LinkedHashSet (order is maintained).
 * </p>
 *
 * <p>
 * Map -> HashMap, TreeMap.
 * </p>
 */
public class CollectionFramework {

    public static void main(String[] args) {
        /* The default size 10, then it increases dynamically.
         * n = n + n / 2 + 1
         */
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0, 2);
        System.out.println(list.get(0));

        list.remove(1);
        list.remove(Integer.valueOf(2));
        list.clear();

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Methods of the queue interface.
        Queue<Integer> q = new LinkedList<>();
        q.offer(10);
        q.offer(20);

        System.out.println(q.peek());
        System.out.println(q.poll());

        // Methods of set interface.
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(10);

        System.out.println(set);
    }
}
