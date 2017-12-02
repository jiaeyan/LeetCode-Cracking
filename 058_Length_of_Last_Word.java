package operation;

/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * Example:
 * Input: "Hello World"
 * Output: 5
 */

public class Length_of_Last_Word {
	/*
	 * Splitting maybe a good way, but wastes much time.
	 * Find the index of last ' ', the length of last word will be:
	 * s.length - lastIndexOf(' ')
	 * E.g.: "hello world", s.length = 11, while lastIndexOf(' ') = 5, 11 - 5 = 6, no,
	 * we should minus 1 more.
	 * "" returns 0
	 * " " returns 0
	 * "a " returns 1, note when no ' ' inside s, lastIndexOf(' ') returns -1
	 */ 
	public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(' ') - 1;
    }
	
	public static void main(String[] args) {
		Length_of_Last_Word llw = new Length_of_Last_Word();
		System.out.println(llw.lengthOfLastWord("hello world "));
	}

}
