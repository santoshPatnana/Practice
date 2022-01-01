package com.khameleon.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.khameleon.dao.ILoginDAO;
import com.khameleon.service.LoginServiceImpl;

public class TestLoginServiceImplWithAnnotations {
	
	@InjectMocks
	private LoginServiceImpl loginServiceImpl;
	
	@Mock
	private ILoginDAO mockILoginDAO;
	
	@Spy
	private ILoginDAO spyILoginDAO;// ambigutiy arises if we use it in testRegisterUserWithSpy
									//@InjectMocks tries to inject both mock and spy
	
	public TestLoginServiceImplWithAnnotations() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testLoginEmpty() {		
		assertThrows(IllegalArgumentException.class, () -> {
			loginServiceImpl.login("", "");
		});
	}
	
	@Test
	public void testLoginValidCredentials() {
		//Mockito.when(mockILoginDAO.authenticate("raja", "rani")).thenReturn(1);
		BDDMockito.given(mockILoginDAO.authenticate("raja", "rani")).willReturn(1);//alternate way of when and then
		assertTrue(loginServiceImpl.login("raja", "rani"));
	}
	
	@Test
	public void testLoginInvalidCredentials() {
		Mockito.when(mockILoginDAO.authenticate("raja", "rani1")).thenReturn(0);
		assertFalse(loginServiceImpl.login("raja", "rani1"));
	}
	
	@Test
	public void testRegisterUserWithSpy() {
		ILoginDAO iLoginDaoSpy = spy(ILoginDAO.class);
		LoginServiceImpl newLoginServiceImpl = new LoginServiceImpl(iLoginDaoSpy);
		newLoginServiceImpl.registerUser("raja", "admin");
		newLoginServiceImpl.registerUser("suresh", "visitor");
		newLoginServiceImpl.registerUser("john", "");
		
		Mockito.verify(iLoginDaoSpy, times(1)).addUser("raja", "admin");
		Mockito.verify(iLoginDaoSpy, times(0)).addUser("suresh", "visitor");
		Mockito.verify(iLoginDaoSpy, never()).addUser("john", "");
				
	}
}
