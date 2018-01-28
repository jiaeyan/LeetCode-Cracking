package bitmanipulation;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using 
 * extra memory?
 */

public class SingleNumber {
	
	// Use a set to add anything new, remove anything in, by this
	// the left one will be the answer.
	// However, this approach takes extra memory.
	public int hashtable(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i:nums) {
        	    if(!s.contains(i)) s.add(i);
        	    else s.remove(i);
        }
        return (int) s.toArray()[0];
    }
	
	// bit: 1 and 0
	// 1 byte = 8 bytes
	// 1 int = 4 bytes = 32 bits
	// The leftmost digit indicates positive (0) or negative (1).
	//
	// The bitwise-AND (&), OR (|), and Ex-OR (^) operators compare 
	// two operands bit by bit, from right (low role) to left (high low).
	//
	// 1. The AND (&) operator sets the result bit to 1 only if both the operand bits are 1.
	// 2. The OR (|) operator sets the result bit to 1 when any one or both the operand bits is 1.
	// 3. The Ex-OR (^) operator sets the result bit to 1 if the corresponding bit of exactly one of its operands is 1.
	//    a XOR b = c, c XOR b = a --> a XOR b XOR b = a
	// 4. The bitwise complement operator (~) sets all the 0s bits in its operand to 1s and all 1s to 0s.
	// 5. Right shift a >> b, shift a to right by b digits, pad with 0s; a >> b = a / ( 2 ^ b )
	// 6. Left shift a << b, shift a to left by b digits, pad with 0s; a << b = a * (2 ^ b)
	public int bitman(int[] nums) {
		if (nums.length == 0) return 0;
		int res = nums[0];
		for(int i = 1; i < nums.length; i++) {
			// a XOR b = c, c XOR b = a --> a XOR b XOR b = a
			res ^= nums[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
