package com.atguigu.sys.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.frame.core.dao.BaseService;
import com.atguigu.frame.core.web.controller.BaseControllerImpl;
import com.atguigu.sys.domain.SysCategoryGroup;
import com.atguigu.sys.service.SysCategoryGroupService;

/**
 * 
*  SysCategoryGroupController 
*  @Description 
*  @author wg
*  @date 2014年10月19日 上午10:51:46 
*
 */
@Controller
@RequestMapping("/sys/category/group")
public class SysCategoryGroupController extends
		BaseControllerImpl<SysCategoryGroup, SysCategoryGroup> {

	@Autowired
	private SysCategoryGroupService sysCategoryGroupService;

	@Override
	protected BaseService<SysCategoryGroup> getBaseService() {
		
		return sysCategoryGroupService;
	}

}
