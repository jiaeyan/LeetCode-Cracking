package string;

/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */

public class Valid_Palindrome {

	public static void main(String[] args) {
		String s = "123a321";
		Valid_Palindrome vp = new Valid_Palindrome();
		System.out.println(vp.isPalindrome(s));

	}
	
	public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.isEmpty() || s.length() == 1) return true;
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            while (!Character.isLetterOrDigit(s.charAt(start)) && start < end) start++;
            while (!Character.isLetterOrDigit(s.charAt(end)) && start < end) end--;
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

}
