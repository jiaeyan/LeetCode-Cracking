package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */

/*
 * The same idea as Pascal Triangle, except that to make the solution
 * cost O(k), modify the same array list all the time. To compute the
 * values in each cell, do backwards, for example:
 * 
 * 1, 3, 3, 1         ->3rd row
 * 1, 4, 6, 4, 1      ->4th row
 * 
 * To convert 3rd row to 4th row, do backwards, sum 1 and 3, get 4, 
 * replace 1 with 4; then sum 3 and 3, get 6, replace 3 with 3; then sum
 * 3 and 1, get 4, replace 3 with 4, then stop there. 
 */
public class PascalTriangleII {
	
    public List<Integer> getRow(int rowIndex) {
    	    List<Integer> res = new ArrayList<>();
    	    res.add(1);
    	    
    	    for(int i = 1; i < rowIndex + 1; i++) {
    	    	    for(int j = i-1; j >= 1; j--) {
    	    	    	    res.set(j, res.get(j-1) + res.get(j));
    	    	    }
    	    	    res.add(1);
    	    }
    	    return res;
    }
	public static void main(String[] args) {
		PascalTriangleII pt = new PascalTriangleII();
		for(int i:pt.getRow(3)) System.out.println(i);
	}

}
