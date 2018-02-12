package bitmanipulatiuon;

/*
 * Write a function that takes an unsigned integer and 
 * returns the number of ’1' bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation 
 * 00000000000000000000000000001011, so the function should return 3.
 */

public class Numberof1Bits {
	
	// you need to treat n as an unsigned value
	// smart approach: avoid checking prefix 0s in vain
	// just check if the shifted n is 0 or not, if yes, already all 0,
	// no need to do further check
    public int hammingWeight(int n) {
    	    int count = 0;
    	    while(n != 0){
    	    	    
    	    	    // count + 0 or 1
    	    	    count += n & 1;
    	    	    
    	    	    // n must do unsinged shift because only 0 should be filled,
    	    	    // no 1s
    	    	    n >>>= 1;
    	    }
    	    return count;
    }
    
    // naive approach
    // check the least digit at every shift to right, then
 	// return the count
    public int naive(int n){
    	    int count = 0;
	    for(int i = 0; i < 32; i++){
	    	    if((n & 1) == 1) count++;
	    	    n >>= 1;
	    }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
