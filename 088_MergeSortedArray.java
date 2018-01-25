package twopointers;

/*
 * Given two sorted integer arrays nums1 and nums2, 
 * merge nums2 into nums1 as one sorted array.
 * 
 * Note:
 * You may assume that nums1 has enough space 
 * (size that is greater or equal to m + n) to hold 
 * additional elements from nums2. The number of elements 
 * initialized in nums1 and nums2 are m and n respectively.
 */

/*
 * If we check from the start, we have to move backward every element in
 * nums1 when one element from nums2 is inserted, making time complexity m*n;
 * instead, we can do from the end, because we already know the lengths of
 * given two arrays, and we also know the max will always be at the end, so
 * we can do backwards.
 */
public class MergeSortedArray {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
        	    if(nums1[i] > nums2[j]) {
        	    	    nums1[k] = nums1[i];
        	    	    i--;
        	    }
        	    else {
        	    	    nums1[k] = nums2[j];
        	    	    j--;
        	    }
        	    k--;
        }
        // if m=0, we simply copy everything from nums2 to nums1;
        // if n=0, the nums1 stays untouched (no further action needs to be done)
        while(j >= 0){
            nums1[j] = nums2[j];
            j--;
        }
    }
	
	public static void main(String[] args) {
		MergeSortedArray msa = new MergeSortedArray();
		int[] nums1 = new int[] {1,4,10,12,0,0,0,0,0,0};
		int[] nums2 = new int[] {2,8,12,13,15,16};
		msa.merge(nums1, 4, nums2, 6);
		for(int i:nums1) System.out.println(i);
	}

}
