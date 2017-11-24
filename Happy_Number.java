package hashtable;

import java.util.HashSet;
import java.util.Set;

/*
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the sum 
 * of the squares of its digits, and repeat the process until the number 
 * equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
 * Those numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */

/*
 * Non-happy number produces a finite set of results, meaning its process
 * leads to a loop. As long as we detect a repeated integer in set, we know
 * it's not happy, because the following procedures will be the same with the same integer. 
 * Otherwise the result converges to 1.
 */
public class Happy_Number {
	
	public boolean isHappy(int n) {
		int squareSum, remain;
		Set<Integer> loop = new HashSet<>();
		while (loop.add(n)) {
			squareSum = 0;
			while (n > 0) {      //this is a procedure of picking digits of an integer from right to left
				remain = n % 10;
				squareSum += remain * remain;
				n /= 10;
			}
			if (squareSum == 1) return true;
			n = squareSum;
		}
		return false;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
