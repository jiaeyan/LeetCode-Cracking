package mod;

/*
 * Determine whether an integer is a palindrome.
 * Do this without extra space.
 * 
 * Some hints:
 * 1. Negative integers are not palindromes.
 * 2. Converting the integer to string uses extra space.
 * 3. Reversing the integer may cause overflow in the half way down.
 * 
 * There is a more generic way of solving this problem.
 */

/*
 * According to reverse integer's idea, every time we update the result,
 * a.k.a. res = res * 10 + x%10, we also do x /= 10, so during the reversing
 * period, the res becomes bigger while the input x becomes smaller.
 * 
 * For a palindrome integer, like 12321, if we do half way down to digit 3,
 * get the result as 123, and the input x will bee 12, we can directly compare
 * if result == input. To avoid odd number of digits in result, also compare
 * result/10 == input.
 */
public class PalindromeNumber {
	
	public boolean isPalindrome(int x) {
		if(x < 0 || (x % 10 == 0 && x != 0)) return false;
		
		// The very similar idea as reversing an integer.
		int half = 0;
		while(x > half) {
			half = half * 10 + x % 10;
			x /= 10;
		}
		
		return x == half || x == half/10; 
    }
	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.isPalindrome(123454321));
	}

}
