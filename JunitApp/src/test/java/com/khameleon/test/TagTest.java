package com.khameleon.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TagTest {
	@Test
	@Tag("dev")
	public void executeInDev() {
		//assertEquals("A","A");
		System.out.println("Dev--");
	}
	
	@Test
	@Tag("prod")
	public void executeInProd() {
		//assertEquals("A","A");
		System.out.println("Prod--");
	}
	
	@Test
	public void execute() {
		assertEquals("A","A");	
	}
}
