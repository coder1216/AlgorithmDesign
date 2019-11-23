/**
 * 
 * 最少几个dict中的单词可以把word拼出来
 */

class Solution {
    public int wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        Boolean[] memo = new Boolean[s.length()];
        return dfs(s, wordDict, memo, 0);
    }
    private int dfs(String s, List<String> wordDict, Boolean[] memo, int index){
        int len = s.length();
        // base case
        if(index == len) return true;
        if(memo[index] != null) return memo[index];
        int min = Integer.MAX_VALUE;
        for(int i = index; i < len; i++){
            String str = s.substring(index, i+1);
            if(wordDict.contains(str)){
                int val = dfs(s, wordDict, memo, i+1);
                min = Math.min(min, val+1);
            }
        }
        return min;
    }
}