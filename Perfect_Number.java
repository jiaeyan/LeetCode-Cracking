package factorial;

/*
 * We define the Perfect Number is a positive integer that 
 * is equal to the sum of all its positive divisors except itself.
 * Now, given an integer n, write a function that returns true 
 * when it is a perfect number and false when it is not.
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 */

public class Perfect_Number {
	
	/*
	 * It's common sense we only need to get to squrt(n) to check if n%i=0.
	 * If it's divisor, we add it along with its counterpart n/i to sum, because i * n/i = n.
	 * Only exception is that when i*i = sum, we only need to add i once.
	 */
	public boolean checkPerfectNumber(int num) {
		if (num <= 1) return false;
		int sum = 0;
        for (int i = 1; i * i <= num; i++) {
        	    if (num % i == 0) {
        	    	    sum += i * i == num ? i : i + num / i;
        	    }
        }
        return sum - num == num;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
