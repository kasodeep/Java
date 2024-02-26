package graph;

import java.util.*;

/**
 * Hard On DSU, Crazy Technique!
 */
public class GCDTraversal {

    static int[] father;

    public static boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        int max = -1;
        for (int x : nums) max = Math.max(max, x);

        // Getting primes till max using eratosthenes.
        List<Integer> primes = eratosthenes(max);
        int m = primes.size();

        Map<Integer, Integer> primeIndex = new HashMap<>();
        for (int i = 0; i < m; i++) primeIndex.put(primes.get(i), i);

        // Initialization on DSU.
        father = new int[n + m];
        for (int i = 0; i < n + m; i++)
            father[i] = i;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            for (int j = 0; j < m; j++) {
                int p = primes.get(j);
                if (p > x) break;

                if (p * p > x) {
                    if (findFather(i) != findFather(n + primeIndex.get(x)))
                        union(i, n + primeIndex.get(x));
                    break;
                }

                if (x % p == 0) {
                    if (findFather(i) != findFather(n + j))
                        union(i, n + j);

                    while (x % p == 0)
                        x /= p;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (findFather(i) != findFather(i - 1)) return false;
        }
        return true;
    }

    // To find prime numbers till n. (n * log(log(n))).
    private static List<Integer> eratosthenes(int n) {
        boolean[] visited = new boolean[n + 1];
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (visited[i]) continue;

            // Table of i.
            for (int j = i * 2; j <= n; j += i)
                visited[j] = true;
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!visited[i]) primes.add(i);
        }
        return primes;
    }

    // Parent function of DSU.
    private static int findFather(int x) {
        if (father[x] != x) father[x] = findFather(father[x]);
        return father[x];
    }

    // Union function of DSU.
    private static void union(int x, int y) {
        x = father[x];
        y = father[y];
        if (x < y) father[y] = x;
        else father[x] = y;
    }
}
