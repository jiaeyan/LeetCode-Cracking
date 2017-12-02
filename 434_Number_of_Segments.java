package regex;

/*
 * Count the number of segments in a string, 
 * where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 * Example:
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class Number_of_Segments {
	//Use regex.
	public int countSegments(String s) {
        String s1 = s.trim();
        return s1.equals("") ? 0 : s1.split("\\s+").length;
    }
	
	//Use iteration.
//	public int countSegments(String s) {
//        int segmentCount = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
//                segmentCount++;
//            }
//        }
//        return segmentCount;
//    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
