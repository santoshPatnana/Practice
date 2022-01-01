package com.khameleon.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.khameleon.util.SingletonDbCon;

public class AssertAllTest {

	@Test
	public void testAll() {
		assertAll(() -> {
			assertNotNull(SingletonDbCon.getConnection());
		}, () -> {
			Connection con1 = SingletonDbCon.getConnection();
			Connection con2 = SingletonDbCon.getConnection();
			
			assertSame(con1, con2);
		}, () -> {
			Connection con1 = SingletonDbCon.getConnection();
			Connection con2 = SingletonDbCon.getConnection();
			
			if(con1 == null && con2 == null)
				fail();
		});
	}

}
