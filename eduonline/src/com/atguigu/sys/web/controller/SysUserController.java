package com.atguigu.sys.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.frame.core.annotation.MethodLog;
import com.atguigu.frame.core.dao.BaseService;
import com.atguigu.frame.core.utils.MD5Util;
import com.atguigu.frame.core.web.controller.BaseControllerImpl;
import com.atguigu.frame.core.web.domain.EasyUIPage;
import com.atguigu.frame.core.web.domain.Result;
import com.atguigu.frame.core.web.domain.Result.Status;
import com.atguigu.sys.domain.SysUser;
import com.atguigu.sys.domain.SysUserProfile;
import com.atguigu.sys.service.SysUserProfileService;
import com.atguigu.sys.service.SysUserService;

/**
 * UserController
 * 
 * @Description
 * @author wg
 * @date 2014年10月5日 下午3:01:45
 *
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserController extends BaseControllerImpl<SysUser, SysUser> {

	@Autowired
	private SysUserService userService;

	@Autowired
	private SysUserProfileService userProfileService;

	@Override
	protected BaseService<SysUser> getBaseService() {
		return userService;
	}

	@Override
	@MethodLog(remark = "查询所有用户")
	public ModelAndView selectList(SysUser query, Pageable pageable) {
		return super.selectList(query, pageable);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String selectListJson(SysUser query, Pageable pageable) {

		Page<SysUser> page = userService.queryPageList(query, pageable);

		return EasyUIPage.formPage(page).toString();
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public List<SysUser> selectAll(SysUser query) {

		List<SysUser> list = userService.queryList(query);

		return list;
	}

	@Override
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Result addOne(SysUser entity) {

		entity.setPassword(MD5Util.MD5(entity.getPassword()));

		userService.insert(entity);

		SysUserProfile userProfile = new SysUserProfile();

		userProfile.setId(entity.getId());

		userProfileService.insert(userProfile);

		return new Result(Status.OK, entity);

	}
	
	@ResponseBody
	@RequestMapping(value="/edit",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result editOneByIdSelective(SysUser entity) {
		getBaseService().updateByIdSelective(entity);
		return new Result(Status.OK, entity);
	}


}
