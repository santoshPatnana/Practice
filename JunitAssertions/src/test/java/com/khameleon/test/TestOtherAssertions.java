package com.khameleon.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestOtherAssertions {
	@Test
	public void TestArrays() {
		int arr1[] = {1,2};
		int arr2[] = {1,2};
		
		assertArrayEquals(arr1, arr2);				
	}
	
	@Test
	public void TestBoolean() {
		boolean result = true;		
		assertTrue(result);		
		//assertFalse(result);
	}
	
	@Test
	public void TestException() {
		assertThrows(NullPointerException.class, () -> {
			throw new ArrayIndexOutOfBoundsException();
		});
	}
}
