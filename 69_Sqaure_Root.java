package square;

/*
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * x is guaranteed to be a non-negative integer.
 * Example 1:
 * Input: 
 * Output: 2
 * 
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., 
 * and since we want to return an integer, 
 * the decimal part will be truncated.
 */

public class Sqaure_Root {
	
	/*
	 * Binary search, set a variable to keep track the low value "res".
	 */
    public int mySqrt(int x) {
    	    long l = 0;
    	    long h = x;
    	    long res = 0;
    	    while (l <= h) {
    	    	    long mid = (l+h)/2;
    	    	    if (mid * mid <= x) {
    	    	    	    l = mid + 1;
                res = mid;
            }
    	    	    else h = mid - 1;
    	    }
    	    return (int)res;
    }
    
    /*
     * The sequence 1, 2, ... , n has no duplication.
     * Near the very end, closest step, before while loop, left = mid = right.
     * In while, If mid < sqrt(x), left = mid + 1 executed, right pointer is not moving, and right is the answer.
     * If while, If mid > sqrt(x), right = mid - 1 executed, right pointer shifts left 1, closest to sqrt(x), right is also the answer.
     */
//    public int mySqrt(int x) {
//        int left = 1, right = x;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (mid == x / mid) {
//                return mid;
//            } else if (mid < x / mid) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return right;
//    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
