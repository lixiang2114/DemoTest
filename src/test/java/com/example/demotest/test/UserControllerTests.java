package com.example.demotest.test;

import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.example.demotest.UserApplication;

//@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes=UserApplication.class)
public class UserControllerTests {
	/**
	 * 测试工具
	 */
	private MockMvc mockMvc;
	
	/**
	 * Spring上下文
	 */
	@Autowired
	private WebApplicationContext applicationContext;
	
	@BeforeClass
	public static void globalInit(){
		System.out.println("======test start=====");
	}
	
	@Before
	public void init(){
		System.out.println("======test case init=====");
		if(null==mockMvc) mockMvc=MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}
	
	@After
	public void destory(){
		System.out.println("======test case destory=====");
		mockMvc=null;
		applicationContext=null;
	}
	
	@AfterClass
	public static void globalDestory(){
		System.out.println("======test over=====");
	}
	
	@Test
	public void testAddUser() throws Exception{
		//组装提交的表单数据
		MultiValueMap<String, String> params=new LinkedMultiValueMap<String, String>();
		params.put("userId", Collections.singletonList("16"));
		params.put("userName", Collections.singletonList("ligang"));
		params.put("groupId", Collections.singletonList("18"));
		
		//构造请求对象
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.request(HttpMethod.POST, "/user/add");
		requestBuilder.contentType(MediaType.APPLICATION_FORM_URLENCODED);
		requestBuilder.params(params);
		requestBuilder.accept(MediaType.TEXT_HTML);
		requestBuilder.characterEncoding("UTF-8");
		
		//发起请求并断言返回结果
		ResultActions requestActions=mockMvc.perform(requestBuilder);
		requestActions.andDo(MockMvcResultHandlers.print());
		
		//从响应结果中断言输出
		MvcResult mvcResult=requestActions.andReturn();
		MockHttpServletResponse response=mvcResult.getResponse();
		Integer statusCode=response.getStatus();
		String responseBody=response.getContentAsString();
		Assert.assertEquals(statusCode, new Integer(200));
		System.out.println("Response:\n"+responseBody);
	}
	
	@Test
	public void testGetUser() throws Exception{
		//组装提交的表单数据
		MultiValueMap<String, String> params=new LinkedMultiValueMap<String, String>();
		params.put("userId", Collections.singletonList("101"));
		
		//构造请求对象
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.request(HttpMethod.POST, "/user/get");
		requestBuilder.contentType(MediaType.APPLICATION_FORM_URLENCODED);
		requestBuilder.params(params);
		requestBuilder.accept(MediaType.TEXT_HTML);
		requestBuilder.characterEncoding("UTF-8");
		
		//发起请求并断言返回结果
		ResultActions requestActions=mockMvc.perform(requestBuilder);
		requestActions.andDo(MockMvcResultHandlers.print());
		
		//从响应结果中断言输出
		MvcResult mvcResult=requestActions.andReturn();
		MockHttpServletResponse response=mvcResult.getResponse();
		Integer statusCode=response.getStatus();
		String responseBody=response.getContentAsString();
		Assert.assertEquals(statusCode, new Integer(200));
		System.out.println("Response:\n"+responseBody);
	}
	
	@Test
	public void testListUser() throws Exception{
		//构造请求对象
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.request(HttpMethod.POST, "/user/list");
		requestBuilder.contentType(MediaType.APPLICATION_FORM_URLENCODED);
		requestBuilder.accept(MediaType.TEXT_HTML);
		requestBuilder.characterEncoding("UTF-8");
		
		//发起请求并断言返回结果
		ResultActions requestActions=mockMvc.perform(requestBuilder);
		requestActions.andDo(MockMvcResultHandlers.print());
		
		//从响应结果中断言输出
		MvcResult mvcResult=requestActions.andReturn();
		MockHttpServletResponse response=mvcResult.getResponse();
		Integer statusCode=response.getStatus();
		String responseBody=response.getContentAsString();
		Assert.assertEquals(statusCode, new Integer(200));
		System.out.println("Response:\n"+responseBody);
	}
}
