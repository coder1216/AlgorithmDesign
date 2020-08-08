import java.util.*;

public class MergeKSortedArray {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4, 7, 9));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(6, 8, 10));
        
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        
        System.out.println(mergeK(lists));
    }

    public static List<Integer> mergeK(List<List<Integer>> numbs) {
        if (numbs == null || numbs.size() == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        PriorityQueue<ArrayContainer> minHeap = new PriorityQueue<>();
        int len = 0;

        for (int i = 0; i < numbs.size(); i++) {
            len +=  numbs.get(i).size();
            minHeap.offer(new ArrayContainer(numbs.get(i), 0));
        }

        while (!minHeap.isEmpty()) {
            ArrayContainer n = minHeap.poll();
            res.add(n.list.get(n.index));
            if (n.index < n.list.size() - 1)
                minHeap.offer(new ArrayContainer(n.list, n.index + 1));
        }

        return res;
    }

    public static class ArrayContainer implements Comparable<ArrayContainer> {
        List<Integer> list;
        int index;

        public ArrayContainer(List<Integer> list, int index) {
            this.index = index;
            this.list = list;
        }

        @Override
        public int compareTo(ArrayContainer o) {
            return this.list.get(this.index) - o.list.get(o.index);
        }
    }
}
