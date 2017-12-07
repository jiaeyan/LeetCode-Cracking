package operation;

/*
 * Given a string, find the first non-repeating character in it and return it's index. 
 * If it doesn't exist, return -1.
 * Examples:
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */

public class First_Unique_Character {
	
	/*
	 * Iterate over the string, for each char, get the first and last occurrences,
	 * if the same, return the index. 
	 */
	public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);
            if (first == last) return first;
        }
        return -1;
    }
	
	/*
	 * This idea is the same as above, difference here is rather iterate over
	 * string length, only iterate over 26 letters, which saves more time for on purpose long strings.
	 */
//	public int firstUniqChar(String s) {
//        char c;
//        int location = s.length();
//        for(c = 'a'; c <= 'z'; c++){
//            if (s.indexOf(c) != -1 && s.indexOf(c) == s.lastIndexOf(c)) {
//                location = Math.min(s.indexOf(c), location); //always keep the first unique letter
//            }
//        }
//        return location == s.length() ? -1 : location;
//    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
