package mod;

/*
 * Given a non-negative integer num, repeatedly add all its digits 
 * until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it.
 */

/*
 * General idea, simply adding all digits.
 */

public class Add_Digits {
	
	public int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            while (num > 0) {
                int digit = num % 10;
                sum += digit;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
	
//  O(1) time solutions: 
//	E.g.: 100a+10b+c, then (100a+10b+c)%9 = (a+99a+b+9b+c)%9 = (a+b+c)%9,
//  where (a+b+c) may still be something like (100d+10e+f), which still
//  equals (d+e+f), until done.
//  It is based on the mathematical property of congruence. The Digital Root 
//	of a number is same as the remainder when that number is divided by 9 
//	(and this remainder will always be a single digit).
	
//	public int addDigits(int num) {
//	    return 1 + (num - 1) % 9;
//	}
	
//	public int addDigits(int num) {
//        if(num == 0) return 0;
//        return num % 9 == 0 ? 9 : num % 9;
//    }
}
