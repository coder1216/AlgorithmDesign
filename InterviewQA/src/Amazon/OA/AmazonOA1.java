package Amazon.OA;

import com.sun.xml.internal.xsom.XSWildcard;

import java.util.*;

public class AmazonOA1 {
    public static void main(String[] args) {
        List<Pair> item1 = new ArrayList<>(Arrays.asList(new Pair("Item1", "Item2"), new Pair("Item3", "Item4"), new Pair("Item4", "Item5")));
        List<Pair> item2 = new ArrayList<>(Arrays.asList(new Pair("Item1", "Item2"), new Pair("item3", "Item4")));

        System.out.println(largestItemAssociation(item1));

    }

    public static List<String> largestItemAssociation(List<Pair> item) {
        // corner case
        if (item == null || item.size() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int index = 0; // used to mark index of each item, then could be union based on it

        // O(n)
        for (int i = 0; i < item.size(); i++) {
            if (!map.containsKey(item.get(i).first)) map.put(item.get(i).first, index++);
            if (!map.containsKey(item.get(i).second)) map.put(item.get(i).second, index++);
        }

        UnionFind uf = new UnionFind(map.size());

        // union O(n)
        for (int i = 0; i < item.size(); i++) {
            uf.union(map.get(item.get(i).first), map.get(item.get(i).second));
        }

        // O(n)
        int maxIndex = uf.maxSize();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();

            if (uf.findRoot(val) == maxIndex) {
                res.add(key);
            }
        }
        // Collections.sort(res);
        return res;
    }

    public static class UnionFind {
        int[] size;
        int[] parent;

        public UnionFind(int n) {
            size = new int[n];
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        private boolean find(int p, int q) {
            return findRoot(p) == findRoot(q);
        }

        private void union(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);

            if (size[rootP] > size[rootQ]) {
                size[rootP] += size[rootQ];
                parent[rootQ] = rootP;
            } else {
                size[rootQ] += size[rootP];
                parent[rootP] = rootQ;
            }
        }

        private int findRoot(int p) {
            int curr = p;
            while (curr != parent[curr]) {
                parent[curr] = parent[parent[curr]];
                curr = parent[curr];
            }
            parent[p] = curr;
            return curr;
        }

        private int maxSize() {
            int max = 0;
            int item = 0;

            for (int i = 0; i < size.length; i++) {
                if (size[i] > max) {
                    max = size[i];
                    item = i;
                }
            }
            return item;
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}
