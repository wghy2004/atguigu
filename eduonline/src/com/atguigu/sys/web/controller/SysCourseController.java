package com.atguigu.sys.web.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.annotate.JsonSerialize;
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
import com.atguigu.frame.core.utils.SystemConfig;
import com.atguigu.frame.core.web.controller.BaseControllerImpl;
import com.atguigu.frame.core.web.domain.EasyUIPage;
import com.atguigu.frame.core.web.domain.Result;
import com.atguigu.frame.core.web.domain.Result.Status;
import com.atguigu.sys.domain.SysCourse;
import com.atguigu.sys.domain.SysFile;
import com.atguigu.sys.domain.SysUser;
import com.atguigu.sys.domain.query.SysCourseQuery;
import com.atguigu.sys.domain.vo.SysCourseVo;
import com.atguigu.sys.service.SysCourseService;
import com.atguigu.sys.service.SysFileService;

@Controller
@RequestMapping("/sys/course")
public class SysCourseController extends
		BaseControllerImpl<SysCourse, SysCourseQuery> {
	
	@Autowired
	private SysCourseService sysCourseService;
	@Autowired
	private SysFileService sysFileService;
	@Autowired
	private HttpServletRequest request;
	

	@Override
	protected BaseService<SysCourse> getBaseService() {
		return sysCourseService;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView selectList(SysCourseQuery query, Pageable pageable) {

		ModelAndView mav = new ModelAndView(path.getListViewPath());

		mav.addObject("query", query);

		return mav;
	}
	@Override
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Result addOne(SysCourse entity) {
		
		entity.setUserId(SystemConfig.getLoginUser(request).getId());
		entity.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		entity.setFreeStartTime(new Timestamp(System.currentTimeMillis()));
		entity.setFreeEndTime(new Timestamp(System.currentTimeMillis()));
		
		sysCourseService.insert(entity);
		
		return new Result(Status.OK, entity);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	public String selectAll(SysCourseVo query,
			@PageableDefault Pageable pageable) {

		Page<SysCourseVo> page = sysCourseService
				.queryPageList(query, pageable);

		return EasyUIPage.formPage(page).toString();
	}

}
