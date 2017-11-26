package factorial;


/*
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */

/*
 * 0 comes from 10, which is the product of 5 * 2. We can have as many as 2
 * in the factorial, so we only need to count how many 5s in those numbers.
 */
public class Factorial_Trailing_Zeroes {
	
	
	/*
	 * Naive counting approach, to certain number, keep stripping off 5
	 * and accumulate the number, time limitation exceeds.
	 */
//	public int trailingZeroes(int n) {
//		int count = 0;
//		for (int i = 1; i <= n; i++) {
//			int m = i;
//			while (m % 5 == 0) {
//				count++;
//				m /= 5;
//			}
//		}
//		return count;
//    }
	
	/*
	 * [n/k] is the number of factors from 1 to n that can be divided by k.
	 * From 15!, do 15/5 we get 3 5s from 5, 10, 15, from 25! we get 5 5s from 5, 10, 15, 20, 25,
	 * however, 25 has one more 5. To catch this, besides 25/5, we do 25/25.
	 * So we want to  compute n/5 + n/25 + n/125 + ... until n/? = 0, means ? > n.
	 */
	public int trailingZeroes(int n) {
        int cnt = 0;
        while(n > 0){
            cnt += n / 5;
            n /= 5; //strip one level 5 from all factors
        }
        return cnt;
    }
	
	public static void main(String[] args) {
		Factorial_Trailing_Zeroes ftz = new Factorial_Trailing_Zeroes();
		System.out.println(ftz.trailingZeroes(50));
	}

}
