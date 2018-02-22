package binarysearch;

/*
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, all the versions 
 * after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad 
 * one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */

/* The isBadVersion API is defined in the parent class VersionControl.
 * boolean isBadVersion(int version); 
 */
public class FirstBadVersion {
	
	// if the middle one is bad, then probably there still is bad before,
	// or not, we are not sure, so make end bound to middle. rather than middle -1
	// (in case this is already the first bad one); 
	// if middle is good, the bad one probably is at the latter part, so make start to middle + 1
	public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end){
            int mid = start + (end - start)/2;
            if (isBadVersion(mid))
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
	
	public boolean isBadVersion(int i){
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
