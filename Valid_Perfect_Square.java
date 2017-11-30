package sqrt;

public class Valid_Perfect_Square {
	
	/*
	 * A brute force way is to iterate over all factors.
	 * A square number is 1+3+5+7+..., so minus 1, 3, till num < 0, 
	 * then check if num == 0.
	 */
	public boolean isPerfectSquare(int num) {
		int acc = 1;
        while (num > 0) {
        	    num -= acc;
        	    acc += 2;
        }
        return num == 0;
    }
	
	/*
	 * Binary search for the i that meets i * i == num.
	 */
//	public boolean isPerfectSquare(int num) {
//        long l = 1;
//        long h = num;
//        while (l <= h) {  //keep "=" in case num == 1, thus l == h
//        	    long mid = (l + h) / 2;
//        	    if (mid * mid == num) return true;
//        	    else if (mid * mid < num) l = mid + 1;
//        	    else h = mid - 1;
//        }
//        return false;
//    }
	
	public static void main(String[] args) {
		Valid_Perfect_Square vps = new Valid_Perfect_Square();
		System.out.println(vps.isPerfectSquare(2147483647));
	}

}
