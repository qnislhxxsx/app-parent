package org.app.service;


import java.util.List;

import org.app.entity.Sample;

public interface SampleService {
	
//	Sample getCacheByName(String id);
	
	Sample getById(String id);
	
	List<Sample> getList();
	
	int updateItem(Sample sample);
	
}
