package com.khameleon.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@TestMethodOrder(OrderAnnotation.class)
@TestMethodOrder(Alphanumeric.class)
public class EmployeeTest {
	
	@BeforeAll
	static void singleSetup() {
		System.out.println("Before All Tests.");
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("Before Test.");
	}
	
	
	@Test
	//@Order(1)
	@DisplayName("Testing Save Method")
	void testSave() {
		System.out.println("Hello-Save");
	}
	
	@Test
	//@Order(2)
	void testUpdate() {
		System.out.println("Hello-Update");
	}
	
	@Test
	//@Order(3)
	@Disabled
	void testDelete() {
		System.out.println("Hello-Delete");
	}
	
	@AfterEach
	void clear() {
		System.out.println("After Test.");
	}
	
	@AfterAll
	static void clearAll() {
		System.out.println("After All Tests..");
	}
	
}
