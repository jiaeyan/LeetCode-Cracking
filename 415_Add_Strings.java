package string;

/*
 * Given two non-negative integers num1 and num2 represented as string, 
 * return the sum of num1 and num2.
 * Note:
 * 1. The length of both num1 and num2 is < 5100.
 * 2. Both num1 and num2 contains only digits 0-9.
 * 3. Both num1 and num2 does not contain any leading zero.
 * 4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

/*
 * Here we use unicode code point to compute since the string is a unicode object.
 * In java, char type operations can be done directly, like '1' - '0' = 'b' - 'a' = 1.
 * In python, the 1-len string should be argument of odr() method, e.g., odr('a') = 96.
 * 
 * We use stringbuilder to record the result.
 */

public class Add_Strings {
	
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int last1 = num1.length() - 1; //the pointer to digit of the number string, initialized to the last
		int last2 = num2.length() - 1;
		int plus1 = 0; //indicate if the sum of two digits surpasses 1, if so, value set to 1, and adds it to the sum of next pair
		for (int p1 = last1, p2 = last2; p1 >= 0 || p2 >= 0; p1--, p2--) { //not stop until run out of both strings' lengths
			int d1 = p1 < 0 ? 0 : num1.charAt(p1) - '0';         //and 0 should be inclusive because of course we want 1st digit
			int d2 = p2 < 0 ? 0 : num2.charAt(p2) - '0';         //since when i = 0 but j > 0, i-- and j-- still goes on, so we have to check negative situation
			int sum = d1 + d2 + plus1; 
			int last = sum % 10;   // we only need the last digit of the sum to be inserted into result
			sb.insert(0, last);
			plus1 = sum / 10;      // if sum > 10 the plus1 will be 1, other wise 0
		}
		if (plus1 > 0) sb.insert(0, 1); //check if the last step yields a >10 result
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Add_Strings as = new Add_Strings();
		System.out.println(as.addStrings("123", "21"));
	}
}
