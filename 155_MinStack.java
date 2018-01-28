package design;

import java.util.Stack;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */

/*
 * Set another normal stack inside, with a min value to record the min
 * of the rest elements in stack.
 * 
 * Every time push in a value, check if it is smaller or equal to min;
 * if yes, push the min into stack (even there is already a min down there),
 * so that next time when the new min is popped, we know immediately what's
 * the next smaller one. This idea makes full use of the stack property of
 * pop() and peek() (we can only check the top one and its next one).
 * 
 * By this, even when the min changes many times, the smallest ones will always
 * be at the upper part, while the bigger ones will be at the lower part. So
 * every time the min is popped, we still know the next smallest one.
 * 
 * When the min is popped, chenge the min to the top one (the next small one),
 * but since that's a duplicate we put there, we also pop that out.
 */
public class MinStack {
	Stack<Integer> s;
	int min;
	
	public MinStack() {
        this.s = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
    	    // "=" is important because there can be duplicated min values
    	    // pushed in.
        if(x <= min) {
        	    s.push(min);
        	    min = x;
        }
        s.push(x);
    }
    
    public void pop() {
        if(s.pop() == min)
        	    min = s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
