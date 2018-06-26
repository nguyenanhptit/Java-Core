package com.thuannd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thuannd.dao.JavaClazz;
import com.thuannd.dao.StudentDAO;
import com.thuannd.utils.XSLTUtils;

@Controller
public class ClazzController {

	@Autowired
	private StudentDAO studentDAO;

	@RequestMapping(value = "/clazz/xml", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody JavaClazz viewInXml() {
		return new JavaClazz(studentDAO.listStudent());
	}

	@RequestMapping(value = "/clazz/json", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody JavaClazz viewInJSON() {
		return new JavaClazz(studentDAO.listStudent());
	}

	@RequestMapping(value = "/clazz/xslt", method = RequestMethod.GET)
	public ModelAndView viewXSLT() {
		JavaClazz clazz = new JavaClazz(studentDAO.listStudent());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ClazzView");
		modelAndView.getModelMap().put("data", XSLTUtils.clazzToDomSource(clazz));
		return modelAndView;
	}

	@RequestMapping(value = "/clazz/excel", method = RequestMethod.GET)
	public ModelAndView viewExcel() {
		JavaClazz clazz = new JavaClazz(studentDAO.listStudent());
		ModelAndView model = new ModelAndView();
		model.setViewName("excelView");
		model.getModelMap().put("clazzObj", clazz);
		return model;
	}

	// view in pdf
	@RequestMapping(value = "/clazz/pdf", produces = "application/pdf")
	public ModelAndView viewPdf() {
		ModelAndView model = new ModelAndView();
		JavaClazz clazz = new JavaClazz(studentDAO.listStudent());
		model.setViewName("home");
		model.getModelMap().put("clazzObj", clazz);
		return model;
	}
}
