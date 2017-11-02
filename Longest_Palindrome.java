package string;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string which consists of lowercase or uppercase letters, 
 * find the length of the longest palindromes that can be built with those letters.
 * Example:
 * Input: "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

/*
 * 1st intuition is if num%2=0, count+, if num%2=1, check oddFlag; however,
 * 1 ("a") and 3 ("aaa") all are num%2=1, but here we want to add 2 to count
 * from 2 "a"s from "aaa".
 */

public class Longest_Palindrome {

	public static void main(String[] args) {
		Longest_Palindrome lp = new Longest_Palindrome();
		String s = "abccccdd";
		System.out.println(lp.longestPalindrome(s));
	}
	
	public int longestPalindrome(String s) {
        boolean oddFlag = false;
        int length = 0;
        Map<Character, Integer> record = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (record.containsKey(s.charAt(i))) {
                record.put(s.charAt(i), record.get(s.charAt(i))+1);
            }
            else {record.put(s.charAt(i), 1);}
        }
        for (int num : record.values()){
            if (num == 1 && oddFlag == false) {
                length++;
                oddFlag = true;
            }
            if (num % 2 == 0) {length += num;}
            if (num > 1 && num % 2 == 1) {
                length += num - 1;
                if (oddFlag == false) {
                    length++;
                    oddFlag = true;
                }
            }
        }
        return length;
    }
}
