import java.util.*;

// "static void main" must be defined in a public class.
import java.util.*;
public class MS2 {

    //public static Map<String, Integer> res = new HashMap<>();
    public static void main(String[] args) {
        Map<String, String> data = new HashMap<>();
        data.put("a", "b");
        data.put("b", "c");
        data.put("d", "c");
        data.put("b", "d");
        data.put("e", "c");

        // a ->b -> c;  b->d->c   e->

        System.out.println(report(data));
    }
    public static int report(Map<String, String> data) {
        Map<String, List<String>> mMap = new HashMap<>();

        for (Map.Entry<String, String> entry : data.entrySet()) {
            String e = entry.getKey();
            String m = entry.getValue();

            if (!e.equals(m)) {
                if (mMap.get(m) == null) {
                    mMap.put(m, new ArrayList<>());
                }
                mMap.get(m).add(e);
            }
        }
        int cnt = 0;
        for (String name : data.keySet()) {
            cnt += getSize(name, mMap, 0);
        }
        return cnt;
    }
    public static int getSize(String name, Map<String, List<String>> mMap, int cnt) {

        if (!mMap.containsKey(name)) return 1;

        for (String s : mMap.get(name)) {
            cnt += getSize(s, mMap, cnt + 1);
        }
        return cnt;
    }
}

