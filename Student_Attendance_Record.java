package regex;

/*
 * You are given a string representing an attendance record for a student. 
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain 
 * more than one 'A' (absent) or more than two continuous 'L' (late).
 * You need to return whether the student could be rewarded according to his attendance record.
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */

public class Student_Attendance_Record {
	
	/*
	 * A hashmap may help, but too brutal. Use regex instead, but is way slow.
	 * Also, use string methods like indexOf(), lastIndexOf() and contains() also help.
	 */
//	public boolean checkRecord(String s) {
//		return !s.matches(".*LLL.*|.*A.*A.*");
//    }
	
	public boolean checkRecord(String s) {
        return !(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"));
    }
	
	public static void main(String[] args) {
		Student_Attendance_Record sar = new Student_Attendance_Record();
		System.out.println(sar.checkRecord("PLPLPL"));
	}

}
