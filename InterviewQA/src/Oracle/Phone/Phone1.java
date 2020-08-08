package Oracle.Phone;

import javax.print.DocFlavor;
import java.util.*;
public class Phone1 {
    public static void main(String[] args) {
        String word1 = "I say Jay chou you say J!";
        String word2 = "      , ^ you say, you & & are you may say You good.";

        System.out.println(duplicatedReplace(word1));
        System.out.println(duplicatedReplace(word2));
    }

    public static String duplicatedReplace(String word) {
        if (word == null || word.length() == 0) return "";

        // use map to save the index of the word
        Map<String, Integer> map = new HashMap<>();

        // grab the non word character by using two pointers
        StringBuilder sb = new StringBuilder();
        int slow = 0;
        int fast = 0;
        int index = 0;
        int cnt = 0;

        while (fast < word.length()) {
            while (fast < word.length() && !Character.isAlphabetic(word.charAt(fast))) {
                fast++;
            }
            if (slow != fast) {
                sb.append(word.substring(slow, fast));
            }

            slow = fast;

            while (fast < word.length() && Character.isAlphabetic(word.charAt(fast))) {
                fast++;
            }

            String str = word.substring(slow, fast);
            if (!map.containsKey(str)) {
                map.put(str, cnt++);
                sb.append(str);
            } else {
                index = map.get(str);
                sb.append("$").append(index);
            }
            slow = fast;
        }
        return sb.toString();
    }
}
