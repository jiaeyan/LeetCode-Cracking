package substring;

/*
 * Write a function to find the longest common prefix string
 * amongst an array of strings.
 */

/*
 * All strings should share the same prefix, so if one word starts with
 * 'a' and another starts with 'b', the function returns "".
 */

public class LongestCommonPrefix {
	
	/*
	 * Word by word comparison. 
	 * 
	 * Assume the 1st word is the longest common prefix first (the lcp must be inside or equal to 1st word)
	 * then go through next word, check if the prefix appears in it. If yes, keep it
	 * (don't increment it because the max length is the 1st word's length) and go next word; 
	 * if no, shrink the prefix by 1 char, check the new prefix with the same word again...
	 * 
	 * Proof: the prefix may become shorter and shorter when compared with the same word,
	 *        but the length is ok because to be common it at least should satisfy that 
	 *        it appears in both 1st word and next word. 
	 *        Even it's short, it at least appears in the two words, it's the longest.
	 *        
     * Time complexity: O(S), where S is the sum of all characters in all strings.
	 * Space complexity: O(1). We only used constant extra space.
	 */
	public String HorizontalScan(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		
		// get the 1st word as prefix
	    String prefix = strs[0];
	    
	    // go through every other word
	    for (int i = 1; i < strs.length; i++) {
	    	    // if the prefix doesn't appear in next word, or appears in other positions
	    	    // rather 1st of it, not common prefix, shrink by 1 char to form a new prefix,
	    	    // then check with the same word again...
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            if (prefix.isEmpty()) return "";
	        } 
	    }         
	    return prefix;
    }
	
	
	/*
	 * Character by character comparison.
	 * 
	 * Assume the 1st word is the longest common prefix (the lcp must be inside or equal to 1st word),
	 * start from the 1st char in the prefix, check all chars at the same position of all other words,
	 * if not the same, return directly the prefix before the tested character.
	 * 
	 * Time complexity: O(S), where S is the sum of all characters in all strings.
	 * Space complexity: O(1). We only used constant extra space.
	 */
	public String VerticalScan(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		
		// get the 1st word as prefix
		for(int i = 0; i < strs[0].length(); i++) {
			// get the char at each position of the 1st word
			char c = strs[0].charAt(i);
			// go through all other words to compare the chars at the same position
			for(int j = 1; j < strs.length; j++) {
				// if the length of prefix exceeds the length of current word, stop and return the prefix - 1 char;
				// or if the current char of current word doesn't match the char, stop and return
				if(i == strs[j].length() || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
	
	public String DividnConquer(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		if (strs.length == 1) return strs[0];
		return null;
	}
	
	public String getPrefix(String s1, String s2) {
		
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println(lcp.HorizontalScan(new String[]{"abcede", "abass", "abbgt"}));
		System.out.println(lcp.VerticalScan(new String[]{"abcede", "abass", "abbgt"}));
	}

}
