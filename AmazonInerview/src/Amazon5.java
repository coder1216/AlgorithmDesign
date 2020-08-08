import java.util.*;

public class Amazon5 {
    public static void main(String[] args) {
        String version1 = "1.1.1.0.1";
        String version2 = "1.1.1-beta1.0";
        String version3 = "1.1.1-alpha1.1";
        String version4 = "1.0.1-alpha.1";
        String version5 = "1.1.1-beta.0";
        String version6 = "1.0.1.1";

        List<String> versions = new ArrayList<>();
        versions.add(version1);
        versions.add(version2);
        versions.add(version3);
        versions.add(version4);
        versions.add(version5);
        versions.add(version6);

        System.out.println(result(versions));
    }

    public static List<String> result(List<String> list) {
        if (list == null || list.size() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();

        Collections.sort(list, (a, b) -> {

            String[] str1 = a.split("\\.");
            String[] str2 = b.split("\\.");

            for (int i = 0; i < Math.max(str1.length, str2.length); i++) {
                String s1 = i < str1.length ? str1[i] : "0";
                String s2 = i < str2.length ? str2[i] : "0";
                if (isDigit(s1, s2)) {
                    int cnt = Integer.parseInt(str1[i]) - Integer.parseInt(str2[i]);
                    if (cnt != 0) return cnt;
                } else {
                    int cnt = str1[i].compareTo(str2[i]);
                    if (cnt != 0) return cnt;
                }
            }
            return 0;
        });

        return list;
    }

    private static boolean isDigit(String s1, String s2) {

            for (int j = 0; j < s1.length(); j++) {
                if (!Character.isDigit(s1.charAt(j)))
                    return false;
            }

            for (int k = 0; k < s2.length(); k++) {
                if (!Character.isDigit(s2.charAt(k)))
                    return false;
            }

        return true;
    }
}