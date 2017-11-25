package string;


/*
 * Given a non-negative integer represented as a non-empty array of digits, 
 * plus one to the integer.
 * You may assume the integer do not contain any leading zero, 
 * except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 */

/*
 * Go from the last digit in the array, if it's <9, +1 doesn't change anything,
 * do it and we know we don't need to proceed anymore so return; if >=10, we know
 * this digit must be 9, and after +1 it must become 0. 
 * We do this in a loop for each digit, until some of it is <9.
 * The only situation where the first digit becomes 0 is that all digits after it
 * all become 0, aka 99999..., in this case we create a new array to make it 100000...
 */

public class Plus_One {
	
	
	public int[] plusOne(int[] digits) {
        int last = digits.length - 1;
        for (int p = last; p >= 0; p--) {
        	    if (digits[p] < 9) {
        	    	    digits[p]++;
        	    	    return digits;
        	    }
        	    digits[p] = 0;
        }
        int[] newDigits = new int[last + 2];
        newDigits[0] = 1;
        return newDigits;
    }
	
	public static void main(String[] args) {
		Plus_One po = new Plus_One();
		for (int num:po.plusOne(new int[] {1,2,3,4,0,9})) System.out.println(num);
	}

}
