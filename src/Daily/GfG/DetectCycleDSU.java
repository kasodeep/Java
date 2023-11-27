package Daily.GfG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DetectCycleDSU {

    public static int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        unionFind uf = new unionFind(V);
        Set<String> set = new HashSet<>();

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                if (set.contains(helper(i, it))) {
                    continue;
                }

                if (uf.findParent(i) != uf.findParent(it)) {
                    uf.union(i, it);
                    set.add(helper(i, it));
                    set.add(helper(it, i));
                } else {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static String helper(int a, int b) {
        String ans = Integer.toString(a);
        ans += Integer.toString(b);
        return ans;
    }

    public static void main(String[] args) {

    }

    static class unionFind {
        static int[] parent;
        static int[] rank;

        public unionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int b) {
            int ulp_a = findParent(a);
            int ulp_b = findParent(b);

            if (ulp_a == ulp_b) {
                return;
            } else if (ulp_a > ulp_b) {
                parent[ulp_b] = ulp_a;
            } else {
                parent[ulp_a] = ulp_b;
            }
        }

        int findParent(int a) {
            if (parent[a] == a) {
                return parent[a];
            }
            return parent[a] = findParent(parent[a]);
        }
    }
}
