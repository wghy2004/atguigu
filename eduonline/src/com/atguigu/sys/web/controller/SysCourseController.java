package com.atguigu.sys.web.controller;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.frame.core.dao.BaseService;
import com.atguigu.frame.core.web.controller.BaseControllerImpl;
import com.atguigu.sys.domain.SysCourse;
import com.atguigu.sys.domain.query.SysCourseQuery;
import com.atguigu.sys.domain.vo.SysCourseVo;
import com.atguigu.sys.service.SysCourseService;

@Controller
@RequestMapping("/sys/course")
public class SysCourseController extends
		BaseControllerImpl<SysCourse, SysCourseQuery> {
	@Autowired
	private SysCourseService sysCourseService;

	@Override
	protected BaseService<SysCourse> getBaseService() {
		return sysCourseService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView selectAll(SysCourseVo query,
			@PageableDefault Pageable pageable) {

		Page<SysCourseVo> page = sysCourseService.queryPageList(query, pageable);

		ModelAndView mav = new ModelAndView(path.getListViewPath(), "page",
				page);

		mav.addObject("query", query);

		return mav;

	}

}
