package binarysearch;
/*
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results 
 * (-1, 1, or 0):
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * 
 * Example:
 * n = 10, I pick 6.
 * Return 6.
 */
public class GuessNumberHigherorLower {
	
	public int guessNumberBianry(int n) {
        int l = 1;
        int r = n;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(guess(mid) == 1) l = mid + 1;
            else if(guess(mid) == -1) r = mid - 1;
            else return mid;
        }
        return -1;
    }
	
	public int guessNumberTernary(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0)
                return mid1;
            if (res2 == 0)
                return mid2;
            else if (res1 < 0)
                high = mid1 - 1;
            else if (res2 > 0)
                low = mid2 + 1;
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }
	
	public int guess(int num){return -1;}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
