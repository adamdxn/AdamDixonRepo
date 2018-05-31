package leetcode;
// https://leetcode.com/problems/multiply-strings/description/
public class MultiplyStrings {
	public static void main(String[] args) {
		System.out.println(solution("1228", "7"));
	}
	
	public static String solution(String s1, String s2){
		
		int n1 = 0;
		int n2 = 0;

		for(int i = 0; i < s1.length(); i++)
			n1 += (s1.charAt(i) - 48) * numZeroes(s1.length() - 1 - i);
		
		for(int i = 0; i < s2.length(); i++)
			n2 += (s2.charAt(i) - 48) * numZeroes(s2.length() - 1 - i);
		
		return String.valueOf(n2 * n1);
	}
	
	public static int numZeroes(int i){
		if (i == 0)
			return 1;
		int r = 1;
		for(int j = 0; j < i; j++)
			r*=10;
		return r;
	}
}
