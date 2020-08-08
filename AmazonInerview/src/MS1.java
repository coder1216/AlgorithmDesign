import java.util.*;
public class MS1 {

    public static void main(String[] args) {

        for (List<String> list : footBall(8)) {
            System.out.println(list);
        }
    }

    public static List<List<String>> footBall(int target) {
        if (target < 0) throw new IllegalArgumentException();
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("safe", 2);
        map1.put("grab", 3);
        map1.put("touchdown", 6);
        map1.put("extra", 1);
        map1.put("buy", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("safe", 2);
        map2.put("grab", 3);
        map2.put("touchdown", 6);

        List<List<String>> res = new ArrayList<>();

        dfs(map1, map2, res, new ArrayList<>(), target);
        return res;
    }

    private static void dfs(Map<String, Integer> map1, Map<String, Integer> map2, List<List<String>> res, List<String> list, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) return;

        for (String action : map2.keySet()) {
            list.add(action);
            if (action.equals("touchdown")) {
                dfs(map2, map1, res, list, target - map1.get(action));
                list.remove(list.size() - 1);
            } else if (!action.equals("touchdown")){
                dfs(map1, map2, res, list, target - map2.get(action));
                list.remove(list.size() - 1);
            }
        }
    }
}