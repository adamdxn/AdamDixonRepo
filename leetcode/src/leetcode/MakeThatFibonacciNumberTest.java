package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class MakeThatFibonacciNumberTest {
	@Test
	public void test0() {
		assertEquals(true, MakeThatFibbonaciNumber.isPossible(10,3));
	}
	@Test
	public void test1() {
		assertEquals(true, MakeThatFibbonaciNumber.isPossible(22,3));
	}
	@Test
	public void test2() {
		assertEquals(true, MakeThatFibbonaciNumber.isPossible(6,2));
	}
	@Test
	public void test3() {
		assertEquals(true, MakeThatFibbonaciNumber.isPossible(8,10));
	}
	@Test
	public void test4() {
		assertEquals(true, MakeThatFibbonaciNumber.isPossible(0,0));
	}
	@Test
	public void test5() {
		assertEquals(false, MakeThatFibbonaciNumber.isPossible(20,0));
	}
	@Test
	public void test6() {
		assertEquals(true, MakeThatFibbonaciNumber.isPossible(24,6));
	}
	@Test
	public void test7() {
		assertEquals(true, MakeThatFibbonaciNumber.isPossible(1000,18));
	}
	@Test
	public void test8() {
		assertEquals(false, MakeThatFibbonaciNumber.isPossible(6,1));
	}
	@Test
	public void test9() {
		assertEquals(false, MakeThatFibbonaciNumber.isPossible(43,2));
	}
}
