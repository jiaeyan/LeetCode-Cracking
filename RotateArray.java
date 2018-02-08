package swap;

/*
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] 
 * is rotated to [5,6,7,1,2,3,4].
 * 
 * Note:
 * Try to come up as many solutions as you can, there are at least 
 * 3 different ways to solve this problem.
 * 
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * Related problem: Reverse Words in a String II
 */

public class RotateArray {
	
	// Swap the last k elements with the first k elements (even if they are across). 
    // The last k elements will be in the correct positions
    // but we need to rotate the remaining (n - k) elements 
    // to the right by k steps.
	 public void swap(int nums[], int k) {
		    int n = nums.length;
		    k=k%n;
		    for (int start=0; start<nums.length && k!=0 ; k = k%n){
		        for (int i = 0; i < k; i++) {
		            swapHelper(nums, start+i, nums.length-k+i);
		        }
		        n=n-k;
		        start=start+k;
		    }
		 }

		private void swapHelper(int[] nums, int a, int b){
		    int temp = nums[b];
		    nums[b]= nums[a];
		    nums[a]=temp;
		}
	
	
	// use extra array, record everything relative to positions as needed
	public void extraArray(int[] nums, int k) {
        int[] a = new int[nums.length];
        
        // copy the shifted part first, when (i+k) == nums.length, a[0] = nums[nums.length - k]
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        
        // copy everything in re-rotated array to original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
	
	/*
	 * [1,2,3,4,5,6,7], k = 3
	 * 
	 * step 1: reverse the whole
	 * [7,6,5,4,3,2,1]
	 * step 2: reverse the left (0 -- k)
	 * [5,6,7,4,3,2,1]
	 * step 3: reverse the right (k -- nums.length)
	 * [5,6,7,1,2,3,4] --> get the result
	 */
	public void reverse3times(int[] nums, int k) {
		// k may > nums.length
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
// there are more approaches
	}

}
