package org.app.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.app.entity.Sample;
import org.app.service.SampleService;

public class SampleServiceTest extends ServiceConfig {
	@Autowired
	private SampleService sampleService;

//	@Test
//	public void testCacheByName() throws Exception {
//		Sample sample = sampleService.getCacheByName("mongo");
//		Assert.assertNotNull(sample);
//	}

	@Test
	public void testById() throws Exception {
		Sample sample = sampleService.getById("1");
		Assert.assertNotNull(sample);
	}

	@Test
	public void testUpdateItem() throws Exception {
		Sample sample = new Sample();
		sample.setId("1");
		sample.setName("test");
		System.out.println(sampleService.updateItem(sample));
	}

}
