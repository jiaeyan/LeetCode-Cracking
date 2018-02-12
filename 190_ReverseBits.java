package bitmanipulatiuon;

/*
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * 
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * Related problem: Reverse Integer
 */

public class ReverseBits {
	
	// check the least digit of n by &1, append the result to output;
	// if it's 1, append to it; if 0, simply signed shift output to
	// left by 1 bit (fill with 0); this idea can also be interpreted as:
	// every shift, get the result of n & 1 (least is 1 or 0), also shift
	// output to left by 1 bit, fill with 0, then do | on the two results,
	// the output gets 1 as least bit if n & 1 ends with 1, or 0 if 0.
	// then we shift n to right to check the next least digit.
	public int reverseBits(int n) {
		int res = 0;
		for(int i = 0; i < 32; i++){
			res = (n & 1) | res << 1;
			n >>= 1;
		}
        return res;
    }
	
	public static void main(String[] args) {
		ReverseBits rb = new ReverseBits();
		System.out.println(rb.reverseBits(43261596));
		System.out.println(7&1);
	}

}
