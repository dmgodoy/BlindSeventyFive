package blindseventyfive.minwindow;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        t.chars().forEach(c -> increment(map, (char) c));
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, count = t.length();
        int[] range = new int[2];
        while(end < s.length()){
            if(decrement(map, s.charAt(end)) >= 0)
                count --;
            while(count == 0){
                if((end - start) < minLen){
                    minLen = end - start;
                    range = new int[]{start, end};
                }
                if(increment(map, s.charAt(start)) == 1)
                    count++;
                start++;
            }
            end++;
        }
        if(minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(range[0], range[1] + 1);
        
    }
    
    private static int decrement(Map<Character,Integer> map, Character c){
        map.put(c, map.getOrDefault(c, 0) - 1);
        return map.get(c);
    }
    private static int increment(Map<Character,Integer> map, Character c){
        map.put(c, map.getOrDefault(c, 0) + 1);
        return map.get(c);        
    }
    
    public static void main(String[] args) {
        
        Solution2 s = new Solution2();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
        
    }
}
