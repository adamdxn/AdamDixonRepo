package leetcode;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class ReverseLinkedListIITest {

	@Test
	public void test1() throws Exception {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(1);
		list2.add(4);
		list2.add(3);
		list2.add(2);
		list2.add(5);
		assertEquals(list2, ReverseLinkedListII.solution(list, 1, 3));
	}
	
	@Test
	public void test2() throws Exception {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(5);
		list2.add(4);
		list2.add(3);
		list2.add(2);
		list2.add(1);
		assertEquals(list2, ReverseLinkedListII.solution(list, 0, 4));
	}
	
	@Test
	public void test3() throws Exception {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(1);
		
		assertEquals(list2, ReverseLinkedListII.solution(list, 0, 0));
	}
	
	@Test
	public void test4() throws Exception {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(2);
		list2.add(1);
		
		assertEquals(list2, ReverseLinkedListII.solution(list, 0, 1));
	}
	
	@Test
	public void test5() throws Exception {
		assertEquals(null, ReverseLinkedListII.solution(new LinkedList<>(), 0, 1));
	}

	@Test
	public void test6() throws Exception {
		LinkedList<Integer> list = new LinkedList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(4);
		list2.add(3);
		list2.add(2);
		list2.add(1);
		list2.add(5);
		list2.add(6);
		list2.add(7);

		assertEquals(list2, ReverseLinkedListII.solution(list, 0, 3));
	}
	
	@Test
	public void test7() throws Exception {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);

		
		assertEquals(list, ReverseLinkedListII.solution(list, 0, 4));
	}
}
