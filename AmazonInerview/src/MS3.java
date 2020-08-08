import java.util.*;

public class MS3 {

    public static void main(String[] args) {

        System.out.println(maxTime(Arrays.asList(4, 1, 2), 7));
    }

    public static int currMax;
    public static List<Integer> path;
    public static List<Integer> maxTime(List<Integer> list, int k) {
        if (list == null || list.size() == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        currMax = 0;
        path = new ArrayList<>();

        dfs(list, k, res, 0, 0);
        return path;
    }

    private static void dfs(List<Integer> list, int k, List<Integer> res, int index, int currSum) {
        if (k < 0) return;
        if (currSum > currMax) {
            currMax = currSum;
            path = new ArrayList<>(res);
        }

        for (int i = index; i < list.size(); i++) {

            res.add(list.get(i));
            dfs(list, k - list.get(i), res, i + 1, currSum + list.get(i));
            res.remove(res.size() - 1);
        }
    }
}

//
//4, 2, 0.5
//
//k = 5


// 4, 3, 2
// 5





