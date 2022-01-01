package com.khameleon.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInfo;

public class RepeatTest {

	@DisplayName("Repated Testing")
	@RepeatedTest(value = 3, name = "{displayName}-{currentRepetition}/{totalRepetitions}")
	public void repeatedTest(TestInfo testInfo) {
		System.out.println(testInfo.getDisplayName());
	}
	
}
