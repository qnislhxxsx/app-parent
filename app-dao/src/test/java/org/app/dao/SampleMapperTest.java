package org.app.dao;

import java.util.List;
 
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
import org.app.dao.SampleMapper;
import org.app.entity.Sample;

public class SampleMapperTest extends MapperConfig{
	
	private static Logger log = LoggerFactory.getLogger(SampleMapperTest.class);
	
	@Autowired
    private SampleMapper sampleMapper;
 
    @Test
    public void testQueryById() throws Exception {
        String id = "1";
        Sample sample = sampleMapper.selectByPrimaryKey(id);
        System.out.println(sample);
        
        log.info("hello");
    }
 
    @Test
    public void testQueryAll() throws Exception {
        List<Sample> samples = sampleMapper.selectByExample(null);
        for (Sample sample : samples) {
            System.out.println(sample);
        }
    }
 

}
