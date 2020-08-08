import java.util.*;
/**
 * This solution can handle:
 *      1. case insensitive
 *      2. return at most top 3
 *      3. special characters appears only in user inputs.
 * Feel free to add special test cases in main function.
 * @author soll__hxc
 * Time: 2019/11/02 02:50
 * Created with IntelliJ IDEA
 */
public class TopThreeWord {
    public static void main(String[] args) {

    }
    // global variable root.
    private TrieNode root = new TrieNode('*');
    // method need to implemnet.
    public List<List<String>> threeKeywordSuggestions(int numreviews, List<String> repository, String customerQuery) {
        List<List<String>> res = new ArrayList<>();
        if(numreviews <= 0 || repository == null || repository.size() == 0 || customerQuery == null || customerQuery.length() < 2) return res;
        // build trie
        for(String word : repository) insert(word);
        TrieNode cur = root;
        char[] chars = customerQuery.toLowerCase().toCharArray();
        int index = -1;
        // user is typing:
        for(int i = 0; i < chars.length; i ++){
            char c = chars[i];
            if(c < 'a' || c > 'z'){
                res.add(new ArrayList<>());
                index = ++i;
                break;
            }
            if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode(c);
            cur = cur.children[c - 'a'];
            // add words to res for each type action of user.
            if(i > 0) addWords(cur, res);
        }
        // handle special characters post processing.
        if(index != -1){
            for(int i = index; i < chars.length; i ++) res.add(new ArrayList<>());
        }
        return res;
    }
    // helper function
    public void addWords(TrieNode cur, List<List<String>> res){
        Collections.sort(cur.words);
        // only return at most top 3 words.
        if(cur.words.size() <= 3){
            res.add(new ArrayList<>(cur.words));
        }else{
            List<String> result = new ArrayList<>();
            for(int j = 0; j < 3; j ++) result.add(cur.words.get(j));
            res.add(result);
        }
    }
    // insert a word into trie.
    public void insert(String word){
        if(word == null || word.length() == 0) return;
        TrieNode cur = root;
        String wordLower = word.toLowerCase();
        for(char c : wordLower.toCharArray()){
            if(cur.children[c - 'a'] == null){
                TrieNode next = new TrieNode(c);
                cur.children[c - 'a'] = next;
            }
            cur = cur.children[c - 'a'];
            cur.words.add(wordLower);
        }
    }
    // self defined TireNode class
    class TrieNode{
        char ch;
        TrieNode[] children;
        List<String> words;
        private TrieNode(char ch){
            this.ch = ch;
            children = new TrieNode[26];
            words = new ArrayList<>();
        }
    }
}