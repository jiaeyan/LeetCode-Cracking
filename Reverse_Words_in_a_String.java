package twoptr;

/*
 * Given a string, you need to reverse the order of characters in each word 
 * within a sentence while still preserving whitespace and initial word order.
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */

public class Reverse_Words_in_a_String {
	
	/*
	 * Iterate the string, stop when meet a space, reverse the word, reset the
	 * right side, go on.
	 * The reverse step in by two pointer.
	 */
	public String reverseWords(String s) {
        char[] words = s.toCharArray();
        int r = 0;
        int l = 0;
        while (l <= s.length()){
            if(l == s.length() || words[l] == ' ') { //if multiple spaces exist, roll while for l until not a space
                reverse(words, r, l - 1);
                r = l + 1;
            }
            l++;
        }
        return new String(words);
    }
    
    public void reverse(char[] words, int r, int l){
        while(r < l){
            char temp = words[r];
            words[r] = words[l];
            words[l] = temp;
            r++;
            l--;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
