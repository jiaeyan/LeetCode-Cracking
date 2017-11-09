package hashtable;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

/*
 * Simply two hash maps help. 
 * It can also be solved by splitting each string into char array and sort, then check if they are the same.
 */

public class Valid_Anagram {

	public static void main(String[] args) {
		String s = "abcdefgagg";
		String t = "gcdgfageba";
		Valid_Anagram va = new Valid_Anagram();
		System.out.println(va.isAnagram(s, t));
	}
	
	public boolean isAnagram(String s, String t) {
        Map<Character, Integer> s_map = new HashMap<>();
        Map<Character, Integer> t_map = new HashMap<>();
        for (Character ch:s.toCharArray()) {
        	    s_map.put(ch, s_map.getOrDefault(ch, 1)+1);
        }
        for (Character ch:t.toCharArray()) {
    	        t_map.put(ch, t_map.getOrDefault(ch, 1)+1);
        }
        if (s_map.size() != t_map.size()) {return false;}
        for (Character ch:s_map.keySet()) {
            if (!t_map.containsKey(ch) || !s_map.get(ch).equals(t_map.get(ch))) {return false;}
        }
        return true;
    }

}
