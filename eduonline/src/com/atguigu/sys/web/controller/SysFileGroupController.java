package com.atguigu.sys.web.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.frame.core.dao.BaseService;
import com.atguigu.frame.core.web.controller.BaseControllerImpl;
import com.atguigu.frame.core.web.domain.EasyUIPage;
import com.atguigu.sys.domain.SysFileGroup;
import com.atguigu.sys.service.SysFileGroupService;

/**
 * 文件组的基本操作 SysFileGroupController
 * 
 * @Description
 * @author wg
 * @date 2014年12月6日 下午8:15:15
 *
 */
@Controller
@RequestMapping("/sys/file/group")
public class SysFileGroupController extends
		BaseControllerImpl<SysFileGroup, SysFileGroup> {
	@Autowired
	private SysFileGroupService sysFileGroupService;

	@Override
	protected BaseService<SysFileGroup> getBaseService() {
		return sysFileGroupService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject selectListJson(SysFileGroup query,
			@PageableDefault Pageable pageable) {

		Page<SysFileGroup> page = sysFileGroupService.queryPageList(query,
				pageable);

		return EasyUIPage.formPage(page);
	}

}
