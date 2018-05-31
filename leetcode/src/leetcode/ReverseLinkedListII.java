package leetcode;

import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedListII {
	// Reverse a linked list from position m to n. Do it in one-pass.
	// Note: 1 ≤ m ≤ n ≤ length of list.
	// Input: 1->2->3->4->5->NULL, m = 2, n = 4
	// Output: 1->4->3->2->5->NULL
	public static LinkedList<Integer> solution(LinkedList<Integer> l, int m, int n){
		LinkedList<Integer> list = new LinkedList<>();
		
		if (n == m & n == 1 & l.size() == 1)
			return l;
		
		if(m > n)
			throw new IllegalArgumentException();
		
		if(l.isEmpty())
			return null;
		
		for (int i = 0; i < m; i++)
			list.add(l.get(i));
		
		for (int i = n; i > m-1; i--)
			list.add(l.get(i));
		
		for (int i = n+1; i < l.size(); i++)
			list.add(l.get(i));
		return list;
	}
}
