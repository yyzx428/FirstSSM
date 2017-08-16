package com.ssm.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml","classpath:spring-servlet.xml"})

@WebAppConfiguration
public class ControllerTest {
	
	private Logger logger=Logger.getLogger(ControllerTest.class);
	protected MockMvc mockMvc;
	
	@Autowired
	protected WebApplicationContext wac;
	
	@Before
	public void setup() {
		mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void AccountIndexTest() throws Exception {
		ModelAndView mdoelAndView=mockMvc.perform(
				get("/Account/Index")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				).andExpect(status().isOk())
				.andDo(print())
				.andReturn().getModelAndView();
		logger.info("返回的视图 "+mdoelAndView.getViewName());
		logger.info("返回的模型 "+mdoelAndView.getModel().toString());
	}
	
	@Test
	public void AccountIndexJsonTest() throws Exception {
		String requestString=mockMvc.perform(
				get("/Account/IndexJson")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				).andExpect(status().isOk())
				.andDo(print())
				.andReturn().getResponse().getContentAsString();
		logger.info("返回的json:  "+requestString);
	}
}
