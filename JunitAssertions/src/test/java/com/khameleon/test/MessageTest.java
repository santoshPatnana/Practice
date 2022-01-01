package com.khameleon.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.khameleon.Message;

public class MessageTest {
	private String expected;
	private String actual;
	private Message message;
	
	@BeforeEach
	public void setup() {
		message = new Message();
		expected = "welcome to the world:santosh";
		actual = "";
	}
	
	@Test
	public void sendMessageTest() {		
		actual = message.sendMessage("santosh");
		assertEquals(expected, actual,"Values not matched");
	}
	
	@AfterEach
	public void clean() {
		message = null;
		expected = null;
		actual = null;
	}

}
