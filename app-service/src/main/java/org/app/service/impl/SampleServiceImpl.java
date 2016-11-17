package org.app.service.impl;


import java.util.List;

import org.app.dao.SampleMapper;
import org.app.entity.Sample;
//import org.app.mongoDao.SampleMongoDao;
import org.app.service.SampleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SampleServiceImpl implements SampleService {
	
	@Autowired
    private SampleMapper sampleMapper;
	
	//@Autowired
//    private SampleMongoDao sampleMongoDao;

//	@Override
//	public Sample getCacheByName(String id) {
//		// TODO Auto-generated method stub
//		Sample sample = sampleMongoDao.findOne(Criteria.where("name").is(id));
//		return sample;
//	}
	
	public Sample getById(String id) {
		return sampleMapper.selectByPrimaryKey(id);
	}

	public List<Sample> getList() {
		return sampleMapper.selectByExample(null);
	}

	@Transactional
	public int updateItem(Sample sample) {
//		String oldName = sample.getName();
//		sample.setName("error");
//		sampleMapper.updateByPrimaryKey(sample);
//		
//		if(1==1){
//			throw new RuntimeException("Exception");
//		}
//		sample.setName(oldName);
		
		return sampleMapper.updateByPrimaryKey(sample);
	}


}
