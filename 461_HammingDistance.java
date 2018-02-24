package bitmanipulatiuon;
/*
 * The Hamming distance between two integers is the number of positions at 
 * which the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 231.
 * 
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * 
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the 
 * corresponding bits are different.
 */
public class HammingDistance {

	public int hammingDistance(int x, int y) {
		return Integer.bitCount(x ^ y);
    }
	
	// https://tech.liuchao.me/2016/11/count-bits-of-integer/
	// see explanation of bitcount
	public int bitCount1(int n) {
	    int count = 0;
	    while (n != 0) {
	        count += n & 1;
	        n >>= 1;
	    }
	    return count;
	}
	
	public int bitCount2(int n) {
	    int count = 0;
	    while (n != 0) {
	        // this operation removes one last significant 1
	    	    // if the last digit is 0, it will jump to next 1 when do n-1
	        // n     = 1 1 0 1 0 0 0
	    	    // n - 1 = 1 1 0 0 1 1 1 (minus 1 from last 1 of n), do n &= n - 1
	    	    // n     = 1 1 0 0 0 0 0
	    	    // n - 1 = 1 0 1 1 1 1 1 (skip the last 0, directly to 2nd 1)
	    	    n &= n - 1;
	        count++;
	    }
	    return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
