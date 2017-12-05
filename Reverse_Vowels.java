package twoptr;

/*
 * Write a function that takes a string as input and 
 * reverse only the vowels of a string.
 * Example 1:
 * Given s = "hello", return "holle".
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * Note:
 * The vowels does not include the letter "y".
 */
public class Reverse_Vowels {
	
	/*
	 * Classic problem fit for two pointer approach.
	 */
	public String reverseVowels(String s) {
        int r = 0;
        int l = s.length() - 1;
        char[] word = s.toCharArray();
        String v = "aeiouAEIOU";
        while (r < l){
            while(r < l && v.indexOf(word[r]) < 0) r++;
            while(r < l && v.indexOf(word[l]) < 0) l--;
            char temp = word[r];
            word[r] = word[l];
            word[l] = temp;
            r++;
            l--;
        }
        return new String(word);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
