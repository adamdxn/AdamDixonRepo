package leetcode;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class MultiplyStringsTest {
	@Test
	public void test0() {
		assertEquals("1", MultiplyStrings.solution("1","1"));
	}
	@Test
	public void test1() {
		assertEquals("0", MultiplyStrings.solution("0","1"));
	}
	@Test
	public void test2() {
		assertEquals("23", MultiplyStrings.solution("23","1"));
	}
	@Test
	public void test3() {
		assertEquals("714162048", MultiplyStrings.solution("123472","5784"));
	}
	@Test
	public void test4() {
		assertEquals("327877305", MultiplyStrings.solution("685","478653"));
	}
}
