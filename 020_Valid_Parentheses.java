package stack;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, 
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class Valid_Parentheses {
	
	/*
	 * Push all left sides into stack, whenever encounter a right side, check
	 * the top of the stack, it must match, so pop the top (no need to push the right).
	 * So stack only grows when only left in, every time a right comes in, must be a match,
	 * otherwise directly return false because we know the pushed in right one will
	 * never be popped out.
	 */
//	public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        for (char ch : s.toCharArray()) {
//        	    if (!stack.isEmpty()) {
//        	    	    if (stack.peek() == '(' && ch == ')') stack.pop();
//        	    	    else if (stack.peek() == '[' && ch == ']') stack.pop();
//        	    	    else if (stack.peek() == '{' && ch == '}') stack.pop();
//        	    	    else stack.push(ch);
//        	    }
//        	    else stack.push(ch);
//        }
//        return stack.isEmpty();
//    }
	
	/*
	 * Another more concise solution: treat '(' the same as ')'. When we
	 * encounter '(', we push a ')', and when we encounter a ')', we should
	 * make sure the popped out one should be the same, because it equals '(',
	 * if not, directly return false
	 */
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		Valid_Parentheses vp = new Valid_Parentheses();
		System.out.println(vp.isValid("[][][({[]})]"));
	}

}
