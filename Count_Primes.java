package prime;

/*
 * Count the number of prime numbers less than a non-negative number, n.
 */

/*
 * Basic idea is to make n divide all integers less than it, if some mod result
 * is 0, we know it can be divided by other factors other than 1 and itself, it's not prime.
 * To speed things up, we only need to consider factors up to √n because, 
 * if n is divisible by some number p, then n = p × q and since p ≤ q, 
 * we could derive that p ≤ √n.
 */

public class Count_Primes {
	
	public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];      //an array of all possible integers below n
        int count = 0;                            //all default as false, aka, all prime
        for (int i = 2; i < n; i++) {             //count from the 1st prime
            if (notPrime[i] == false) {           //if not marked as true, it is prime, count++
                count++;                          
                for (int j = 2; i*j < n; j++) {   //if i is a prime, mark all possible composits containing a factor of i as not prime
                    notPrime[i*j] = true;
                }
            }
        }        
        return count;
    }
	public boolean isPrime(int num) {
		if (num <= 1) return false;
		// Loop's ending condition is i * i <= num instead of i <= sqrt(num)
		// to avoid repeatedly calling an expensive function sqrt().
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) return false;
			}
		return true;
	}
	
	public static void main(String[] args) {
		Count_Primes cp = new Count_Primes();
		System.out.println(cp.isPrime(14));
	}

}
