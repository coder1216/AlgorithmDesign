import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;
public class Amazon3 {
    public static void main(String[] args) {
        String[] strs  = new String[]{"1.2.A.1", "1.1.A.1", "1.1.A.2", "1.1.A.3", "1.1.B.1", "1.1.C.1", "1.1.B.2"};
        System.out.println(sameRow(strs));
    }

    public static List<List<String>> sameRow(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        int len = strs.length;

       // Arrays.sort(strs, (a, b) -> b.compareTo(a));

        Arrays.sort(strs, (a, b) -> {
            String[] str1 = a.split("\\.");
            String[] str2 = b.split("\\.");

            for (int i = 0; i < str1.length; i++) {
                int n = str1[i].compareTo(str2[i]);
                if (n != 0) {
                    return n;
                } else {
                    continue;
                }
            }
            return 0;
        });

        List<String> list = new ArrayList<>();
        list.add(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            String last = list.get(list.size() - 1);
            String curr = strs[i];
            if (valid(curr, last) && Math.abs(curr.charAt(len - 1) - last.charAt(len - 1)) == 1) {
                list.add(curr);
            } else {
                res.add(list);
                list = new ArrayList<>();
                list.add(curr);
            }
        }
        return res;
    }

    public static boolean valid(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        String[] str1 = s1.split("\\.");
        String[] str2 = s2.split("\\.");

        for (int i = 0; i < str1.length - 1; i++) {
            if (str1[i].compareTo(str2[i]) != 0) {
                return false;
            }
        }
        return true;
    }
}
