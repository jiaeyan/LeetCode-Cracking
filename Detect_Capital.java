package bit;

/*
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class Detect_Capital {
	
	/*
	 * No fancy trick, just count the cap number and judge.
	 */
	public boolean detectCapitalUse(String word) {
        int capnum = 0;
        for (char c:word.toCharArray()){
            if (Character.isUpperCase(c)) capnum++;
        }
        return capnum == word.length() || capnum == 1 && Character.isUpperCase(word.charAt(0)) || capnum == 0;
    }
	
	/*
	 * A little bit trick is using the unicode digit. Weird thing is this approach is way slower than above.
	 */
//	public boolean detectCapitalUse(String word) {
//        int capnum = 0;
//        for (char c:word.toCharArray()){
//            if ('Z' - c >= 0) capnum++;
//        }
//        return capnum == word.length() || capnum == 1 && 'Z' - word.charAt(0) >= 0 || capnum == 0;
//    }
	
	public static void main(String[] args) {
		System.out.println('Z'-'A');
	}

}
