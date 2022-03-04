package longestsubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
    public int lengthOfLongestSubstring(String s) {
    	Set<Character> seenCharacters = new HashSet<>();
    	int start = 0;
    	int end = 0;
    	
    	if(s == null)
    		return 0;
    	if(s.length() == 0)
    		return 0;
    	int maxLength = 1;
    	while(end < s.length()){
    		if(!seenCharacters.contains(s.charAt(end))){
    			seenCharacters.add(s.charAt(end));
    			if(end - start + 1 > maxLength)
    				maxLength = end - start + 1;
    			end++;
    		} else {
    			seenCharacters.remove(s.charAt(start));
    			start++;	
    		}    			
    	}
    	return maxLength;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int n = s.lengthOfLongestSubstring("asdfasdffffasdf");
    	System.out.println(n);
    }

}
