package com.atguigu.sys.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.edu.service.CategoryService;
import com.atguigu.edu.service.CourseService;
import com.atguigu.frame.core.utils.TemplateUtil;
import com.atguigu.frame.core.web.controller.BaseControllerImpl;
import com.atguigu.frame.core.web.domain.Result;
import com.atguigu.frame.core.web.domain.Result.Status;
import com.atguigu.sys.domain.SysCategory;
import com.atguigu.sys.domain.SysCourse;

import freemarker.template.TemplateException;

@Controller
@RequestMapping("/sys/template")
public class SysTemplateController {

	private Logger log = LoggerFactory.getLogger(SysTemplateController.class);
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView configView() {
		return new ModelAndView("sys/template/config");
	}
	
	@RequestMapping(value="index",method = RequestMethod.GET)
	@ResponseBody
	public Result createIndex(HttpServletRequest request) {
		
		ServletContext context = request.getServletContext();
		
		List<SysCourse> list = courseService.getIndexCourse(20);
		
		List<SysCategory> list1 = categoryService.getIndexCategory(4, 6);

		Map data = new HashedMap();

		data.put("courses", list);
		data.put("categorys", list1);
		data.put("base", request.getContextPath());
		
		try {
			TemplateUtil.crateHTML(context, data, "index.ftl", "index.html");
		} catch (IOException e) {
			e.printStackTrace();
			return new Result(Status.ERROR,"创建错误");
		} catch (TemplateException e) {
			e.printStackTrace();
			return new Result(Status.ERROR,"创建错误");
			
		}
		return new Result(Status.OK,"首页生成成功");
	}
	
}
