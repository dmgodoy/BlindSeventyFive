package blindseventyfive.longestpalindrome;

class Solution {
    public String longestPalindrome(String s) {
    	int start = 0, end = 1, maxStart = 0, maxEnd = 1; // end character not included
    	int length = 1;
    	int maxLength = 1;
    	for (int pivot = 0; pivot < s.length(); pivot++) {
    		//look for odd palindrome
    		int distanceToEdge = Math.min(pivot + 1, s.length() - pivot);
    		for (int i = 0; i < distanceToEdge; i++) {
    			if(s.charAt(pivot - i) == s.charAt(pivot + i)){
    				start = pivot - i;
    				end = pivot + i + 1;
    				length = end - start;
    			} else break;
			}
    		if(length > maxLength){
    			maxLength = length;
    			maxStart = start;
    			maxEnd = end;
    		}
    		//look for even palindrome
    		distanceToEdge = Math.min(pivot + 1, s.length() - (pivot + 1));
    		System.out.println(s.length());
    		System.out.println("pivot : "+pivot);
    		System.out.println(distanceToEdge);
    		for (int i = 0; i < distanceToEdge; i++) {
    			if(s.charAt(pivot - i) == s.charAt(pivot + 1 + i)){
    				start = pivot - i;
    				end = pivot + i + 2;
    				length = end - start;
    			} else break;
			}
    		if(length > maxLength){
    			maxLength = length;
    			maxStart = start;
    			maxEnd = end;
    		}
		}
    	return s.substring(maxStart, maxEnd);
        
    }
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.longestPalindrome("asdffds"));
	}
}