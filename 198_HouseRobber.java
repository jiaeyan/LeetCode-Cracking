package dynamicprogramming;

/*
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint 
 * stopping you from robbing each of them is that adjacent houses have 
 * security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money 
 * of each house, determine the maximum amount of money you can rob tonight 
 * without alerting the police.
 */

/*
 * To decide if rob current house, look back if we robbed previous house.
 */
public class HouseRobber {
	
	// Space O(N) approach:
	// Maintain a 2-d arrays dp, while dp[i][1] means rob the current house, 
	// and dp[i][0] means we don’t. Initialize the first row with 0s for deciding
	// to rob 1st house or not.
	// Then for each house, if we rob, means we didn't rob previous one, so the total
	// amount now will be current house's money + previous money that didn't rob;
	// if we don't rob, tricky here, current house's money doesn't provide anything,
	// we only care if we robbed previously, and would like to get the bigger one.
	public int rob(int[] nums) {
		int[][] dp = new int[nums.length + 1][2];
		int i = 1;
		for(; i < nums.length + 1; i++){
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = nums[i-1] + dp[i-1][0];
		}
		return Math.max(dp[i][0], dp[i][1]);
    }
	
	// Space O(1) approach:
	// simply maintain two values: preyes and preno.
	public int rob2(int[] nums) {
		int preyes = 0;
		int preno = 0;
		for(int i = 0; i < nums.length; i++) {
			int temp = preyes;
			preyes = nums[i] + preno;
			preno = Math.max(temp, preno);
		}
		return Math.max(preyes, preno);
	}
	
	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.rob(new int[]{10, 30, 20, 8, 90}));;
	}

}
