package org.app.web.controller;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( {
	"classpath:spring/spring-dao.xml",
	//"classpath:spring/spring-mongo.xml",
	"classpath:spring/spring-service.xml",	
	"classpath:spring/spring-web.xml"
	})
// �縸����@ContextConfiguration����̳�
@WebAppConfiguration(value = "src/main/webapp")
public class ControllerConfig{

}
