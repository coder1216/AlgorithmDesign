import java.util.*;
/*
* Amazon price for a book is $50 for you.
* Amazon prime price for a book is $40 for you.
* */
public class Amazon1 {
    public static void main(String[] args) {
        String words = "Amazon price for a book is $52 for you";
        System.out.println(discount(words));
    }

    public static String discount(String words) {
       if (words == null || words.length() == 0) return words;
       String[] strs = words.split("\\s+");
       StringBuilder sb = new StringBuilder();

       for (int i = 0; i < strs.length; i++) {
           if (strs[i].charAt(0) == '$') {
               String disc = makeDiscount(strs[i]);
               strs[i] = disc;
           }
           sb.append(strs[i]).append(' ');
       }
       sb.setLength(sb.length() - 1);
       return sb.toString();
    }

    private static String makeDiscount(String words) {
        String[] res = words.split("\\$");
        List<Character> list = new ArrayList<>();
        for (char ch : res[1].toCharArray()) {
            list.add(ch);
        }

        if (list.contains('.')) {
            double ans = Double.parseDouble(res[1]);
            ans *= 0.8;
            return "$" + String.valueOf(ans);
        } else {
            int ans = Integer.parseInt(res[1]);
            ans *= 0.8;
            return "$" + String.valueOf(ans);
        }
    }
}
