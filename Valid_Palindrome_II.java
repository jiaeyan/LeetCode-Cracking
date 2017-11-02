package string;

/*
 * Given a non-empty string s, you may delete at most one character. 
 * Judge whether you can make it a palindrome.
 * The string will only contain lowercase characters a-z.
 */

/*
 * The 1st intuition may be to check start+1/end-1 's postion and 
 * compare with another, however, from case like "lcupuu...uupucul"
 * we know we have to check both sides from "cupuu...uupuc" and
 * "upuu...uupucu".
 */

public class Valid_Palindrome_II {

	public static void main(String[] args) {
		String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
		Valid_Palindrome_II vp2 = new Valid_Palindrome_II();
		System.out.println(vp2.validPalindrome(s));
	}
	
	public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            }                        //not start++ because this affects the next start
            start++;
            end--;
        }
        return true;
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while (start < end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else {return false;}
        }
        return true;
    }

}
