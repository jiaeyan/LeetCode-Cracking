package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *   [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

/*
 * Do as the definition of Pascal's triangle, pretty the same idea
 * as dynamic programming.
 */
public class PascalTriangle {
	
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		if(numRows == 0) return triangle;
		
		triangle.add(new ArrayList<Integer>());
		triangle.get(0).add(1);
		
		for(int i = 1; i < numRows; i++) {
			List<Integer> newRow = new ArrayList<>();
			
			// The first row element is always 1.
			newRow.add(1);
			
			// Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
			for(int j = 1; j < i; j++) {
				newRow.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
			}
			
			// The last row element is always 1.
			newRow.add(1);
			
            triangle.add(newRow);
		}
		
		return triangle;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
