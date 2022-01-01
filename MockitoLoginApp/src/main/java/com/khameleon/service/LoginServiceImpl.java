package com.khameleon.service;

import com.khameleon.dao.ILoginDAO;

public class LoginServiceImpl implements ILoginService {

	private ILoginDAO iLoginDAO;
	public LoginServiceImpl(ILoginDAO iLoginDAO) {
		this.iLoginDAO = iLoginDAO;
	}

	@Override
	public boolean login(String userName, String password) {
		boolean success = false;
		if(userName.equals("") || password.equals(""))
			throw new IllegalArgumentException();

		int count = iLoginDAO.authenticate(userName, password);
		System.out.println("count::"+count);
		if(count == 1)
			success = true;								
		return success;
	}
	
	@Override
	public String registerUser(String user, String role) {
		if(!role.equalsIgnoreCase("") && !role.equalsIgnoreCase("visitor"))	{
			System.out.println("with in registerUser");
			iLoginDAO.addUser(user, role);
			return "User Added";
		}
		return "User Not Added";			
	}

}
