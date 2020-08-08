import java.util.*;

public class Amazon5_1 {
    public static void main(String[] args) {
        String v1 = "1.0.0-alpha.0";
        String v2 = "1.0.0-alpha.0";

        System.out.println(result(v1, v2));
    }

    public static int result(String v1, String v2) {
        if (v1 == null || v2 == null) throw new IllegalArgumentException();
        List<String> res = new ArrayList<>();

        String[] s1 = v1.split("\\.");
        String[] s2 = v2.split("\\.");

        for (int i = 0; i < Math.max(s1.length, s2.length); i++) {
            String n1 = i < s1.length ? s1[i] : "0";
            String n2 = i < s2.length ? s2[i] : "0";

            if (isDigit(n1, n2)) {
                int cnt = Integer.parseInt(n1) - Integer.parseInt(n2);
                if (cnt != 0) return cnt;
            } else {
                int cnt = n1.compareTo(n2);
                if (cnt != 0) return cnt;
            }
        }
        return 0;
    }

    private static boolean isDigit(String s1, String s2) {

        for (int i = 0; i < s1.length(); i++) {
            if (!Character.isDigit(s1.charAt(i)))
                return false;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!Character.isDigit(s2.charAt(i)))
                return false;
        }

        return true;
    }
}
