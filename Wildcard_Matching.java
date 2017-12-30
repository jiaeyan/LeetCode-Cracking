package substring;

/*
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */

/*
 * Solution: dynamic programming.
 */

public class Wildcard_Matching {

	public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        
        // Empty pattern only matches empty txt.
        if(m == 0) return n == 0;
        
        // Create a table, where the row sequence represents the position
     	// of txt, while the column sequence represents the position of pat.
     	// So the DP solves the problem by prefix by prefix (substring) of 
     	// both txt and pattern.
     		
     	// Since an extra comparison of empty pattern with empty txt
     	// is needed, the table size should enlarge by 1.
        boolean[][] dp = new boolean[n+1][m+1];
        
        // An empty pattern matches an empty txt.
        dp[0][0] = true;
        
        // Only '*' can match with empty string.
        for (int j = 1; j <= m; j++)
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
        
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
            	
            	    // If meet a '?' (matches any char), or both chars in txt and pat match, 
				// grow both prefixes of pat and txt by 1, in the table means fill in the cell
				// along diagonal, because only this cell grows both pat and txt.
				// This cell's value depends on its former one, because if former is true, this
				// is matched all so also true; if former is false, this match succeeds in vain,
				// like 'abc?' and 'abbc', 'ab' match, '?' and 'c' match, but former 'c' and 'b' no.
				
				// pat.charAt(j-1) rather j is because num_col here is m+1, to go back to
				// original pat to find corresponding char, the j should minus 1.
                if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                
                // If meet a '*':
				// 1. treat it as 0 sequence in pat, so pat's j go back to j-1 (no advance due to 0 '*'),
				//    the comparison point will be dp[i][j-1];
				// 2. treat txt[j] as a part of '*' sequence, in other words, no advance in txt, so txt's i
				//    go back to i-1, the comparion point will be dp[i-1][j]
				// Check 11:30 to see above interpretations:
				// https://www.youtube.com/watch?v=3ZDZ-N0EPV0&list=PLrmLmBdmIlpvm7VaC0NTR27A_3i2sU3zd&index=1
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        
        return dp[n][m];
    }

}
