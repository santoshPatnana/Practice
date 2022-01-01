package com.khameleon.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.khameleon.util.DbConnection;

public class TestDbConnection {
	private DbConnection dbConnection;
	private Connection con;
	
	@BeforeEach
	public void init() {
		dbConnection = new DbConnection();		
	}
	
	@Test
	public void TestGetConnection() {		
		assertDoesNotThrow( () -> {
			con = dbConnection.getConnection();
		});
		//con = dbConnection.getConnection();
		//System.out.println(con);
		assertNotNull(con, "connection not created..");
	}
	
	@AfterEach
	public void clean() {
		dbConnection = null;
		con = null;
	}
}
