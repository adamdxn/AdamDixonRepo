package leetcode;

public class MakeThatFibbonaciNumber {
	
	/*
	 *  You are given an integer n and you want to determine if it is possible to transform n to a Fibonacci
	 *	number in at most m steps, where m is also a given bound. At each step, you can: add 1 to the
	 *	number at hand (addition step), or multiply it by 2 (doubling step).
	 */
	public static boolean isPossible(int n, int m) {
		int max = n;
		for (int i = 0; i < m; i++) {
			max *= 2;
		}
		return help(n,m, max);
	}
	

	// A utility method that returns true if x is perfect square
    static  boolean isPerfectSquare(int x)
    {
        int s = (int) Math.sqrt(x);
        return (s*s == x);
    }
      
    // Returns true if n is a Fibonacci Number, else false
    static boolean isFib(int n)
    {
        // n is Fibonacci if one of 5*n*n + 4 or 5*n*n - 4 or both
        // is a perfect square
        return isPerfectSquare(5*n*n + 4) ||
               isPerfectSquare(5*n*n - 4);
    }
    
	private static boolean help(int n, int m, int max) {
		if (isFib(n) && n <= max) {
			return true;
		}
		
		if (n < max && m - 1 >= 0 && help(2*n, m - 1, max)){
			return true;
		}
		else if (n < max && m - 1 >= 0 && help(n + 1, m - 1, max))  {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		System.out.println(isPossible(20,0));
	}
}
