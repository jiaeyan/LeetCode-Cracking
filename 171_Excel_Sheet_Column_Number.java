package mod;

/*
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 */

public class Excel_Sheet_Column_Number {
	
	/*
	 * 123 = 1*10^2 + 2*10^1 + 3*10^0, the same for 26
	 * ABC = 1*26^2 + 2*26^1 + 3*26^0
	 */
//	public int titleToNumber(String s) {
//        int n = 0;
//        int len = s.length();
//        for (int i = 0; i < len; i++) {
//        	    char letter = s.charAt(i);
//        	    int coefficient = letter - 64; //letter - 'A' + 1, where 'A' = 65
//        	    n += Math.pow(26, len - i - 1) * coefficient;
//        }
//        return n;
//    }
	
	/*
	 * 123 = 1*10^2 + 2*10^1 + 3*10^0
	 *     = 10*(10 *(1) + 2) + 3
	 * ABC = 26*(26*(26*0 + 1) + 2) + 3
	 */
	public int titleToNumber(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
        	    n = 26 * n + s.charAt(i) - 64;
        }
        return n;
    }
	
	public static void main(String[] args) {
		Excel_Sheet_Column_Number es = new Excel_Sheet_Column_Number();
		System.out.println(es.titleToNumber("ZZ"));
		System.out.println(26*26*2 + 26*2 + 26);
	}

}
