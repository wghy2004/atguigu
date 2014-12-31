package com.atguigu.edu.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.edu.service.CategoryService;
import com.atguigu.edu.service.CourseService;
import com.atguigu.sys.domain.SysCategory;
import com.atguigu.sys.domain.SysCourse;
import com.atguigu.sys.service.SysUserService;

/**
 * 首页地址
 * 
 * @author wg
 *
 */
@Controller
@RequestMapping("/edu/index")
public class IndexController {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {

		List<SysCourse> list = courseService.getIndexCourse(20);
		
		List<SysCategory> list1 = categoryService.getIndexCategory(4, 6);

		ModelAndView model = new ModelAndView();

		model.addObject("courses", list);
		model.addObject("categorys", list1);

		model.setViewName("edu/index");

		return model;
	}

}
