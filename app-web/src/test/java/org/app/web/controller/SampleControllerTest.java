package org.app.web.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class SampleControllerTest extends ControllerConfig{
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testListAll() throws Exception {
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.get("/sample/listAll"))
				.andExpect(MockMvcResultMatchers.view().name("listAll"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("samples"))
				.andDo(MockMvcResultHandlers.print())
				.andReturn();

		Assert.assertNotNull(result.getModelAndView().getModel().get("samples"));

	}
	
	@Test
	public void testListJson() throws Exception {
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.get("/sample/listJson"))
//				.andExpect(MockMvcResultMatchers.view().name("listAll"))
//				.andExpect(MockMvcResultMatchers.model().attributeExists("samples"))
				.andDo(MockMvcResultHandlers.print())
				.andReturn();

		//Assert.assertNotNull(result.getModelAndView().getModel().get("samples"));

	}

	@Test
	public void testUpdateItem() throws Exception {
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.get("/sample/1/update"))
				.andExpect(MockMvcResultMatchers.view().name("list"))
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		
		Assert.assertNotNull(result.getModelAndView().getModel().get("samples"));
	}

}
