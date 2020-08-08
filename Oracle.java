import java.util.*;
public class MinimizeTheSentence {
    public static String solution(String s){
        if(s == null || s.length() == 0) return "";
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int slow = 0;
        int fast = 0;
        int count = 0;
        int len = s.length();
        while(fast < len){
            while(fast < len && !isWord(s.charAt(fast))){
                fast++;
            }
            if(slow != fast){
                sb.append(s.substring(slow, fast));
            }
            slow = fast;
            while(fast < len && isWord(s.charAt(fast))){
                fast++;
            }
            String subS = s.substring(slow, fast);
            Integer index = map.get(subS);
            if(index == null){
                map.put(subS, count++);
                sb.append(subS);
            }else{
                sb.append("$");
                sb.append(index);
            }
            slow = fast;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    private static boolean isWord(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    
    public static void main(String[] args){
        
        String s = "      , ^ you say, you & & are you may say You good.";
        System.out.println(solution(s));
    }
}
