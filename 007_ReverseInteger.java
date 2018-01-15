package mod;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * Input: 123
 * Output:  321
 * 
 * Example 2:
 * Input: -123
 * Output: -321
 * 
 * Example 3:
 * Input: 120
 * Output: 21
 * 
 * Note:
 * Assume we are dealing with an environment which could only hold
 * integers within the 32-bit signed integer range. For the purpose 
 * of this problem, assume that your function returns 0 when the 
 * reversed integer overflows.
 */

/*
 * Don't mind if the input is positive or negative, they both follow the
 * same procedure and rule.
 */

public class ReverseInteger {
	/*
	 * A very first and naive idea, slow.
	 */
	public int naive(int x) {
		if(x == 0) return 0;
		
		// divide 10 until the least significant digit is not 0; e.g., make 3200 to 32
		while(x % 10 == 0) x /= 10;
		
		// a list to store all digits
		List<Integer> digits = new ArrayList<>();
		
		// add all digits to the list in reverse order
		while(x / 10 != 0) {
			digits.add(x % 10);
			x /= 10;
		}
		digits.add(x);
		
		// accumulate each digit with corresponding exponent of 10
		int res = 0;
		for(int i = 0; i < digits.size(); i++) {
			if(digits.get(i) != 0) 
				res += digits.get(i) * Math.pow(10, digits.size() - i - 1);
			    if(res == Integer.MAX_VALUE || res == Integer.MIN_VALUE) return 0;
		}
        return res;
    }
	
	/*
	 * A standard way to reverse an integer.
	 * Not consider the range boundaries of 32bit.
	 */
	public int standard(int x) {
		int res = 0;
		
		// Since by mod, we already check with reverse order of digits,
		// to go from least to most significant digit, simply *10 on the result.
		while(x != 0) {
			res = res * 10 + x % 10;
			x /= 10;
		}
		return res;
	}
	
	/*
	 * The correct solution for this problem.
	 */
	public int reverse(int x) {
		int res = 0;
		
		while(x != 0) {
			int tail = x % 10;
	        int newResult = res * 10 + tail;
	        
	        // if the result is out of 32 bit range, the next output of *10 will be
	        // a totally ridiculous number, not able to convert back to former value,
	        // use this property to check if out of range
	        if ((newResult - tail) / 10 != res)
	        	    return 0;
	        
	        res = newResult;
	        x = x / 10;
		}
		return res;
	}

	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
//		ri.reverse(1534236469);
		System.out.println(ri.reverse(1534236469));
	}

}
