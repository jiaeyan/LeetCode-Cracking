package twopointers;

/*
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place 
 * with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * Example:
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 */

public class RemoveElement {
	
	// Two pointers.
	// Set one pointer as start, one as end. Go from start, if it
	// is the target, change its value with the end, then abandon the end
	// (reduce the size by 1). Then check the start again, if it
	// is still the target, do the same...until its value is not target,
	// then move start forward by 1.
	// This approach mix the end and start values in disorder.
	public int removeElement(int[] nums, int val) {
		int l = 0;
		int r = nums.length;
		
		// whatever the end is, just replace it, check its illegality at next iteration
		while(l < r) {
			if(nums[l] == val) {
				nums[l] = nums[r-1];
				r--;
			}
			else {
				l++;
			}
		}
		
//		while(l < r) {
//			if(nums[l] == val) {
		        // every time find a val, try to replace it from the end that is not val;
		        // but for [3,3] and 3, r becomes -1, thus nums[r] will be illegal
//				while(l < r && nums[r] == val) r--;
//				nums[l] = nums[r];
//				nums[r] = val;
//				r--;
//			}
//			l++;
//		}
		
        return r;
    }
	public static void main(String[] args) {
		RemoveElement re = new RemoveElement();
		System.out.println(re.removeElement(new int[] {2, 3, 4, 3}, 3));
	}

}
