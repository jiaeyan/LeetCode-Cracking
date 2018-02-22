package mod;
/*
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * 
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * 
 * Example 1:
 * Input: 3
 * Output: 3
 * 
 * Example 2:
 * Input: 11
 * Output: 0
 * 
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, 
 * which is part of the number 10.
 */
public class NthDigit {
	
	/*
	 * 1.find the length of the number where the nth digit is from
	 * 2.find the actual number where the nth digit is from
	 * 3.find the nth digit and return
	 * 
	 * 1 ~ 9 include 9 one digit number;
	 * 10 ~ 99 include 90 two digits number;
	 * 100 ~ 999 include 900 three digits number;
	 * 1000 ~ 9999 include 9000 four digits number;
	 * …
	 * len is how many digits:1 or 2 or 3 ..., range is 9 or 90 or 900 ...
	 */
	public int findNthDigit(int n) {
        int len = 1;    // 1, 2, 3, ... to maintain length
        int base = 1;   // 1, 10, 100, ... to compute target
        long range = 9; // 9, 90, 900, ... use long to avoid overflow
        
        // 1.find the length
        while(n > len * range){
        	    n -= len * range; // to find the digit length zone
        	    len++;            // go to next length zone
        	    range *= 10;      // next zone's range is 10 times bigger, e.g. from 9 to 90
        	    base *= 10;       // next zone's number's base is 10 times bigger, e.g. from 10 to 100
        }
        
        // 2.find the target number
        // (n-1)/len: how many numbers after base
        // The reason why we reduce 1 from n is to calibrate the difference between rank and natural number.
        // We initialize ‘start’ as 1, which is the 1st element in the sequence.
        // It is the same as an array, where the index should be now 0-based.
        // Actually, we can subtract 1 from n at the very beginning.
        int target = base + (n - 1) / len;
        String res = Integer.toString(target);
        
        // 3.find the position
        // (n-1)%len: the position from the target number
        int pos = (n - 1) % len;
        return Character.getNumericValue(res.charAt(pos));
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
