package com.raju.algos.search;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBinarySearch {

	@Test
	public void testSearch1() {
		BinarySearch bs = new BinarySearch();
		int index = bs.search(new int[]{1,4,8,10,24,56,73}, 10);
		assertEquals(3, index);
	}
	
	@Test
	public void testSearch2() {
		BinarySearch bs = new BinarySearch();
		int index = bs.search(new int[]{1}, 1);
		assertEquals(0, index);
	}
	
	@Test
	public void testSearch3() {
		BinarySearch bs = new BinarySearch();
		int index = bs.search(new int[]{1}, 10);
		assertEquals(-1, index);
	}
	
	@Test
	public void testSearch4() {
		BinarySearch bs = new BinarySearch();
		int index = bs.search(new int[]{1,4,8,10,24,56,73}, 73);
		assertEquals(6, index);
	}
	
	@Test
	public void testSearch5() {
		BinarySearch bs = new BinarySearch();
		int index = bs.search(new int[]{1,4,8,10,24,56,73}, 100);
		assertEquals(-1, index);
	}
}
