package Trees;

import java.util.*;

public class MinimumSwapsToBST {

    static void inorder(int[] a, Vector<Integer> v, int n, int index) {
        if (index >= n)
            return;

        inorder(a, v, n, 2 * index + 1);
        v.add(a[index]);
        inorder(a, v, n, 2 * index + 2);
    }

    public static int minSwaps(Vector<Integer> arr) {
        int len = arr.size();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++)
            map.put(arr.get(i), i);
        Collections.sort(arr);

        boolean[] visited = new boolean[len];
        Arrays.fill(visited, false);

        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (visited[i] || map.get(arr.get(i)) == i)
                continue;

            int j = i, cycle_size = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = map.get(arr.get(j));
                cycle_size++;
            }
            if (cycle_size > 0) ans += (cycle_size - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {5, 6, 7, 8, 9, 10, 11};
        int n = a.length;

        Vector<Integer> v = new Vector<>();
        inorder(a, v, n, 0);
        System.out.println(minSwaps(v));
    }
}
