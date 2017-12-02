package bit;

/*
 * Given an arbitrary ransom note string and another string containing letters 
 * from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Ransom_Note {
	
	/*
	 * A hashmap may help, but not efficiency.
	 * Main idea is put every thing as storage from magazine, 
	 * then count transactions from ransom note, minus each letter from
	 * storage, if there is not enough goods, <0, return false.
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
        int[] storage = new int[26];
        for (char c:magazine.toCharArray()) storage[c -'a']++;
        for (char c:ransomNote.toCharArray()){
            if (--storage[c - 'a'] < 0) return false;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
