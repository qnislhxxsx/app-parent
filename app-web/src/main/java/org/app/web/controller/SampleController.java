package org.app.web.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.app.entity.Sample;
import org.app.service.SampleService;

@Controller
@RequestMapping("/sample") // url:/ģ��/��Դ/{id}/ϸ�� /sample/list
public class SampleController {
 
	public SampleController(){
		System.out.println("init");
	}
    private Logger logger = LoggerFactory.getLogger(this.getClass());
 
    @Autowired
    private SampleService sampleService;
 
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Sample> list = sampleService.getList();
        model.addAttribute("samples", list);
        // list.jsp + model = ModelAndView
        return "list";// WEB-INF/jsp/"list".jsp
    }
    
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public ModelAndView listAll() {
    	ModelAndView modelAndView = new ModelAndView();  
    	modelAndView.setViewName("listAll");
    	List<Sample> list = sampleService.getList();
    	modelAndView.addObject("samples", list);
        return modelAndView;// WEB-INF/tpl/list.tpl
    }
    
    @ResponseBody  
    @RequestMapping(value = "/listJson", method = RequestMethod.GET)
    public List<Sample> listJson() {
    	List<Sample> list = sampleService.getList();
        return list;// WEB-INF/tpl/list.tpl
    }
    
    @RequestMapping(value = "/{sampleId}/update", method = RequestMethod.GET)
    public String update(@PathVariable("sampleId") String sampleId, Model model) {
    	Sample sample = new Sample();
    	sample.setId(sampleId);
    	sample.setName("ccc");
        sampleService.updateItem(sample);
        // list.jsp + model = ModelAndView
        return "list";// WEB-INF/jsp/"list".jsp
    }
 
    // ajax json
    @RequestMapping(value = "/{sampleId}/detail", method = RequestMethod.GET)
    @ResponseBody
    public String detail(@PathVariable("sampleId") String sampleId, Model model) {
        if (sampleId == null) {
            return "redirect:/sample/list";
        }
        Sample sample = sampleService.getById(sampleId);
        if (sample == null) {
            return "forward:/sample/list";
        }
        model.addAttribute("sample", sample);
        return "detail";
    }

    @RequestMapping(value = "/arrayPost", method = RequestMethod.POST)
    @ResponseBody
    public String arrayPost(@RequestBody List<Sample> samples) {
    	
    	System.out.println(samples);
        return "OK";
    }
}
