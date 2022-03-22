package blindseventyfive.groupanagrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String, List<String>> group = new HashMap<>();
    	for(int i = 0; i < strs.length; i++){
        	char[] charCount = new char[26];
        	strs[i].chars().forEach(c -> charCount[c - 'a']++);
        	String key = String.valueOf(charCount);
        	if(!group.containsKey(key))
        		group.put(key, new LinkedList<>());
        	group.get(key).add(strs[i]);
    	}
    	for(List<String> l : group.values())
    		Collections.sort(l);

        return new LinkedList<>(new ArrayList<>(group.values()));
        
    }
    public static void main(String[] args) {
    	
		Solution s = new Solution();
		List<List<String>> ll = s.groupAnagrams(new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"});
		for(List<String> l : ll){
			System.out.println();
			l.forEach(e -> System.out.println(e));
		}
		
    }
}
