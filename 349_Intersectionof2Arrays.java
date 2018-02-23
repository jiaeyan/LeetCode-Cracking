package hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class Intersectionof2Arrays {
	
	public int[] intersectionHashSet(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        
        // make nums1 as a set
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        
        // read element from nums2, if it's in nums1's set, add
        // it to the intersect set
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        
        // convert a set to an array
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
	
	public int[] intersectionTwoPointers(int[] nums1, int[] nums2){
		Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
