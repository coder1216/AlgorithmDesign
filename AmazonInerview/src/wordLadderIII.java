import java.util.*;

public class wordLadderIII {
    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordDict = Arrays.asList("hot", "dot", "dos", "log", "lot", "cog", "hop", "dog", "hog");

        System.out.print(wordLadderIII(beginWord, endWord, wordDict));
    }
    public static List<String> wordLadderIII(String beginWord, String endWord, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        Set<String> dic = new HashSet<>(wordDict);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Map<String, String> map = new HashMap<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String words = queue.poll();
                for (int i = 0; i < words.length(); i++) {
                    char[] chs = words.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (chs[i] == ch) continue;;
                        chs[i] = ch;
                        String curr = String.valueOf(chs);
                        if (dic.contains(curr)) {
                            map.put(curr, words);
                            if (curr.equals(endWord)) {
                                String temp = curr;
                                while (temp != beginWord) {
                                    res.add(0, temp);
                                    temp = map.get(temp);
                                }
                                res.add(0, beginWord);
                                return res;
                            }
                            queue.offer(curr);
                            dic.remove(curr);
                        }
                    }
                }
            }
        }
        return res;
    }
}
