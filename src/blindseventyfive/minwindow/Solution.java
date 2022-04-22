package blindseventyfive.minwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    
    public String minWindow(String s, String t) {
        if(t.length() > s.length() || s.length() == 0 || t.length() == 0)
            return "";

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            Character c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        int[] minRange = new int[2];
        int minLenght = Integer.MAX_VALUE;
        
        int hashToFind = 0;
        for (int idx = 0; idx < t.length(); idx++)
            hashToFind += t.charAt(idx);

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            if(map.containsKey(s.charAt(i)))
                indexes.add(i);
            
        int start = 0;
        int hash = 0;
        while(start + t.length() <= indexes.size()){
            //System.out.println(indexes.get(start));
            if(start == 0){
                for (int i = 0; i < t.length(); i++)
                    hash += s.charAt(indexes.get(i));
            }else{
                //we roll the hash (lol) to the next characterrrr
                hash -= s.charAt(indexes.get(start - 1));
                hash += s.charAt(indexes.get(start + t.length() - 1));
            }
            //System.out.println(s.substring(indexes.get(start), indexes.get(start + t.length() - 1)+1)+" : "+hash);
            if(hash == hashToFind && validate(s, indexes.get(start), indexes.get(start + t.length() - 1) + 1,map)){
                if((indexes.get(start + t.length() - 1) + 1 - indexes.get(start)) < minLenght){
                    minRange = new int[]{indexes.get(start), indexes.get(start + t.length() - 1) + 1};
                    minLenght = minRange[1] - minRange[0];
                }
            }
            start++;
        }
        
        if(minLenght == Integer.MAX_VALUE)
            return "";
        return s.substring(minRange[0], minRange[1]);
        
        
    }
    private boolean validate(String s, int start, int end, Map<Character, Integer> map) {
        Map<Character,Integer> m2 = new HashMap<>();
        for (int i = start; i < end; i++){
            Character c = s.charAt(i);
            m2.put(c, m2.getOrDefault(c, 0)+1);
        }
            
        for(Character c : map.keySet()){
            if(!m2.containsKey(c))
                return false;
            if(m2.get(c) < map.get(c))
                return false;
        }
        return true;
    }
    public static String getUniqueStr(String t, int start, int end, Set<Character> filter){
        char[] arr = new char[100];
        for (int i = start; i < end; i++) {
            char c = t.charAt(i);
            if(filter.contains(c)){
                int idx = Character.isUpperCase(c)? c - 'A': c - 'a';
                arr[idx]++;
            }
        }
        return String.valueOf(arr);
    }
    
    
    public static void main(String[] args) {
        
        Solution s = new Solution();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
        
    }
}
