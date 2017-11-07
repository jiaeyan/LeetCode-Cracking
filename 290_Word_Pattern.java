import java.util.HashMap;

/*
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */

/*
 * Make a hashtable, if the key is seen, check if its value is the same; if the key
 * is not seen, before putting the pair into the map, check if this value is already
 * in record, if yes, it means different keys point to the same values, definitely illegal.
 */

public class Word_Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean wordPattern(String pattern, String str) {
        String[] obs = str.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
        if (obs.length != pattern.length()) {return false;}
        for(int i = 0; i < obs.length; i++){
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if(!map.get(ch).equals(obs[i])) {return false;}
            }
            else {
                if(map.containsValue(obs[i])) {return false;}
                map.put(ch, obs[i]);
            }    
        }
        return true;
    }

}
