package com.khameleon.dao;

public interface ILoginDAO {
	public int authenticate(String userName, String password);
	public int addUser(String user, String role);
}
