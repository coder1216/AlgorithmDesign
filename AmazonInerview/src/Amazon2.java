import java.util.*;

public class Amazon2 {
    public static void main(String[] args) {

        Component c1 = new Component("1", Arrays.asList("2", "3", "4"));
        Component c2 = new Component("5", Arrays.asList("2", "3"));
        //Component c3 = new Component("3", Arrays.asList("4", "11"));
        Component c4 = new Component("4", Arrays.asList("10", "11"));

        List<Component> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        //list.add(c3);
        list.add(c4);

        System.out.println(returnId(list, "11"));
    }

    public static List<Component> returnId(List<Component> components, String target) {
        if (components == null || components.size() == 0 || target == null) return new ArrayList<>();
        List<Component> res = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, List<String>> dic = new HashMap<>();

        for (Component c : components) {
            for (String s : c.subList) {
                if (!dic.containsKey(c.id)) {
                    dic.put(c.id, new ArrayList<>());
                }
                dic.get(c.id).add(s);
            }
        }

        System.out.println(dic);

        for (Component c : components) {
            for (String s : c.subList) {
                if (!map.containsKey(s)) {
                    map.put(s, new HashSet<>());
                }
                map.get(s).add(c.id);
            }
        }

        System.out.println(map);

        dfs(map, dic, target, res);
        for(Component c : res) {
            System.out.println(c.id);
            System.out.println(dic.get(c.id));
        }
        return res;
    }

    private static void dfs(Map<String, Set<String>> map, Map<String, List<String>> dic, String target, List<Component> res) {
        if (target == null || map.get(target) == null) return;

        for (String s : map.get(target)) {
            res.add(new Component(s, dic.getOrDefault(s, new ArrayList<>())));
            dfs(map, dic, s, res);
        }
    }

    public static class Component{
        String id;
        List<String> subList;

        public Component(String id, List<String> subList) {
            this.id = id;
            this.subList = subList;
        }
    }
}









