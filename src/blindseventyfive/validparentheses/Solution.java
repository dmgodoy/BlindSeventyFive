package blindseventyfive.validparentheses;

import java.util.Stack;

public class Solution {
	public static boolean isClosingParenthesis(Character c){
		return c == '}' || c == ')' || c == ']';
	}
	public static boolean closes(Character c1, Character c2){
		return (c1 == '}' && c2 == '{') || (c1 == ']' && c2 == '[') || (c1 == ')' && c2 == '(');
	}
    public boolean isValid(String s) {
    	if(s.length() < 2)
    		return false;
    	Stack<Character> stack = new Stack<>();
    	stack.push(s.charAt(0));
    	for (int i = 1; i < s.length(); i++) {
    		if(isClosingParenthesis(s.charAt(i))){
    			if(stack.empty())
    				return false;
    			if(!closes(s.charAt(i), stack.peek()))
    				return false;
    			else stack.pop();
    		}
    		else stack.push(s.charAt(i));
		}
    	if(!stack.empty())
    		return false;
    	return true;
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isValid("()[]{}"));
	}
}
