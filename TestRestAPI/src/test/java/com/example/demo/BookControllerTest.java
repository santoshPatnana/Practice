package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = BookController.class)
public class BookControllerTest {
	
	@MockBean
	BookService mockBookService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testAddBook() throws Exception {
		when(mockBookService.addBook(ArgumentMatchers.any())).thenReturn(true);
		
		Book book = new Book(1,"Great book",123);
		
		ObjectMapper obj = new ObjectMapper();
		String jsonBook = obj.writeValueAsString(book);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addBook")
													.contentType(MediaType.APPLICATION_JSON)
													.content(jsonBook);//build request
		ResultActions resultActions = mockMvc.perform(requestBuilder);//to call request
		MvcResult mvcResult = resultActions.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		//String content = response.getContentAsString();
		//System.out.println(content);
		assertEquals(201, status);
	}
	
	@Test
	public void testAddBook2() throws Exception {
		when(mockBookService.addBook(ArgumentMatchers.any())).thenReturn(false);
		
		Book book = new Book(1,"Great book",123);
		
		ObjectMapper obj = new ObjectMapper();
		String jsonBook = obj.writeValueAsString(book);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addBook")
													.contentType(MediaType.APPLICATION_JSON)
													.content(jsonBook);//build request
		ResultActions resultActions = mockMvc.perform(requestBuilder);//to call request
		MvcResult mvcResult = resultActions.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		//String content = response.getContentAsString();
		//System.out.println(content);
		assertNotEquals(201, status);
	}
	
}
