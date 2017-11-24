package string;

/*
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */

/*
 * See "Add Strings". 
 * Difference is that for binary, plus 1 to left when the sum of right meets 2, and change left to 0.
 */

public class Add_Binary {
	
	public String addBinary(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int last1 = num1.length() - 1; //the pointer to digit of the number string, initialized to the last
		int last2 = num2.length() - 1;
		int plus1 = 0; //indicate if the sum of two digits surpasses 1, if so, value set to 1, and adds it to the sum of next pair
		for (int p1 = last1, p2 = last2; p1 >= 0 || p2 >= 0; p1--, p2--) { //not stop until run out of both strings' lengths
			int d1 = p1 < 0 ? 0 : num1.charAt(p1) - '0';         //and 0 should be inclusive because of course we want 1st digit
			int d2 = p2 < 0 ? 0 : num2.charAt(p2) - '0';         //since when i = 0 but j > 0, i-- and j-- still goes on, so we have to check negative situation
			int sum = d1 + d2 + plus1; 
			int last = sum % 2;   // we only need the last digit of the sum to be inserted into result
			sb.insert(0, last);
			plus1 = sum / 2;      // if sum > 2 the plus1 will be 1, other wise 0
		}
		if (plus1 > 0) sb.insert(0, 1); //check if the last step yields a >2 result
        return sb.toString();
    }
	
	
	public static void main(String[] args) {
		Add_Binary ab = new Add_Binary();
		System.out.println(ab.addBinary("11", "1"));
	}

}
