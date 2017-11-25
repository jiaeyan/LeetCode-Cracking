package sum;

/*
 * You have a total of n coins that you want to form in a staircase shape, 
 * where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * Example 1:
 * n = 5
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * n = 8
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * Because the 4th row is incomplete, we return 3.
 */

/*
 * We want to compute 1+2+3+4+5+...stair <= n, which equals
 * x*(x+1)/2 <= n. To find the x, instead of doing it from 0,
 * we apply binary search to reduce the time complexity.
 */

public class Arranging_Coins {
	
	public int arrangeCoins(int n) {
        double start = 0;
        double end = n;
        while (start < end) {
        	    double mid = (end + start) / 2;
        	    double sum = mid * (mid + 1) / 2;
        	    if (sum > n) {end = mid - 1.0;}
        	    else {start = mid + 1.0;}
        }
        return (int)start;
    }
	
	/*
	 * This approach starts searching x from 0, 1, 2, 3,...
	 */
//	public int arrangeCoins(int n) {
//        int stair = 0;
//        while (n  > 2 * stair){ //as long as the rest of n is bigger than the last stair, n - stair > stair
//            n -= stair++;
//        }
//        return stair;
//    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
