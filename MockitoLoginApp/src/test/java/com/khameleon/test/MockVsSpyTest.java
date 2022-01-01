package com.khameleon.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockVsSpyTest {
	
	@Test
	public void listTest() {
		List<String> mockList = Mockito.mock(ArrayList.class);
		List<String> spyList = Mockito.spy(ArrayList.class);
		
		mockList.add("Hello");
		spyList.add("Hello");
		
		System.out.println(mockList.size()+"::"+spyList.size());
		
		when(mockList.size()).thenReturn(10);
		when(spyList.size()).thenReturn(10);
		
		System.out.println(mockList.size()+"::"+spyList.size());
	}
}
