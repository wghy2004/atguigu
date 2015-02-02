package com.atguigu.sys.web.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.frame.core.dao.BaseService;
import com.atguigu.frame.core.utils.SystemConfig;
import com.atguigu.frame.core.web.controller.BaseControllerImpl;
import com.atguigu.frame.core.web.domain.EasyUIPage;
import com.atguigu.frame.core.web.domain.Result;
import com.atguigu.frame.core.web.domain.Result.Status;
import com.atguigu.sys.domain.SysCourse;
import com.atguigu.sys.domain.SysCourseLesson;
import com.atguigu.sys.domain.SysUser;
import com.atguigu.sys.domain.vo.SysCourseLessonVo;
import com.atguigu.sys.service.SysCourseLessonService;
import com.atguigu.sys.service.SysFileService;

@Controller
@RequestMapping("/sys/course/lesson")
public class SysCourseLessonController extends
		BaseControllerImpl<SysCourseLesson, SysCourseLesson> {

	@Autowired
	private SysCourseLessonService sysCourseLessonService;
	@Autowired
	private SysFileService sysFileService;
	@Autowired
	private HttpServletRequest request;

	@Override
	protected BaseService<SysCourseLesson> getBaseService() {
		return sysCourseLessonService;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView selectList(SysCourseLesson query, Pageable pageable) {

		ModelAndView mav = new ModelAndView(path.getListViewPath());

		mav.addObject("query", query);

		return mav;
	}

	@RequestMapping(value = "/addBaseCourse", method = RequestMethod.GET)
	public ModelAndView addViewBaseCourse(SysCourseLessonVo entity) {
		return new ModelAndView(path.getAddViewPath(), "model", entity);
	}

	@Override
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Result addOne(SysCourseLesson entity) {

		entity.setUserId(SystemConfig.getLoginUser(request).getId());
		entity.setCreatedTime(new Timestamp(System.currentTimeMillis()));

		sysCourseLessonService.insert(entity);

		return new Result(Status.OK, entity);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	public String selectAll(SysCourseLesson query,
			@PageableDefault Pageable pageable) {

		Page<SysCourseLesson> page = sysCourseLessonService.queryPageList(
				query, pageable);

		return EasyUIPage.formPage(page).toString();
	}

	@Override
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result editOne(SysCourseLesson entity) {
		entity.setUserId(SystemConfig.getLoginUser(request).getId());
		getBaseService().updateById(entity);
		return new Result(Status.OK, entity);
	}

	@ResponseBody
	@RequestMapping(value = "/edit", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result editOneByIdSelective(SysCourseLesson entity) {
		getBaseService().updateByIdSelective(entity);
		return new Result(Status.OK, entity);
	}

}
