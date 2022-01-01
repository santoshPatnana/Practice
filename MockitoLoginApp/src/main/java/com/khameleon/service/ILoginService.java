package com.khameleon.service;

public interface ILoginService {
	public boolean login(String userName, String password);
	public String registerUser(String user, String role);
}
