package mod;

/*
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB 
 */

public class Excel_Sheet_Column_Title {
	
	/*
	 * 123 = 1*10^2 + 2*10^1 + 3*10^0
	 *     = 10*(10 *((10*0 + 1)) + 2) + 3
	 * ABC = 26*(26*(26*0 + 1) + 2) + 3
	 * ZZZ = 26*26^2 + 26*26^1 + 26*26^0
	 *     = 26*(26*(26*0 + 26) + 26) + 26
	 *     
	 * If we do 1 -> A, 26 -> Z, we don't have a 0 letter, so
	 * we can assume that 0 -> A, 25 -> Z, to get around with the corner case 26/z,
	 * and then here comes the base 26 representation, 
	 * it's similar when you convert a number from base 10 to base 2.
	 * 
	 * The idea is this: suppose you have excel title 52 = AZ = A * 26 + Z * 1, 
	 * where A = 1, Z = 26. Now you shift each digit down i.e. A' = 0, and Z' = 25.
	 * Then 52 = AZ = (A' + 1) * 26 + (Z' + 1) * 1.
	 * So now you need to find A' and Z'. Z' = (52 - 1) % 26 = 25, 
	 * which is (n-1)%26 in the code above. Now you need to get A' + 1 
	 * from 26 * (A' + 1) + (Z' + 1). If you simply do n/=26, Z' + 1 will give additional 1. 
	 * So you will get n = 2 instead of n = 1. To avoid this you do n = (n-1)/26
	 */
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			char letter = (char)((n-1) % 26 + 'A');
			sb.insert(0, letter);
			n = (n-1)/26;
		}
		return sb.toString();
    }
	
	//A little bit more concise approach:
//	public String convertToTitle(int n) {
//        StringBuilder sb = new StringBuilder();
//        while (n-- > 0) {
//            sb.insert(0, (char)('A' + (n % 26)));
//            n /= 26;
//        }
//        return sb.toString();
//    }
	
	public static void main(String[] args) {
//		System.out.println('A'+1);
//		System.out.println('B'-1);
//		System.out.println((char)(64+1));
		Excel_Sheet_Column_Title es = new Excel_Sheet_Column_Title();
		System.out.println(es.convertToTitle(26));
		System.out.println(es.convertToTitle(52));
		System.out.println(es.convertToTitle(53));
	}

}
