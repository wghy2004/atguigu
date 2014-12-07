package com.atguigu.sys.web.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.frame.core.dao.BaseService;
import com.atguigu.frame.core.web.controller.BaseControllerImpl;
import com.atguigu.frame.core.web.domain.EasyUIPage;
import com.atguigu.sys.domain.SysFile;
import com.atguigu.sys.domain.SysFileGroup;
import com.atguigu.sys.service.SysFileService;

/**
 * 文件的基本操作 SysFileController
 * 
 * @Description
 * @author wg
 * @date 2014年12月6日 下午8:15:37
 *
 */
@Controller
@RequestMapping("/sys/file")
public class SysFileController extends BaseControllerImpl<SysFile, SysFile> {
	@Autowired
	private SysFileService sysFileService;

	@Override
	protected BaseService<SysFile> getBaseService() {
		return sysFileService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject selectListJson(SysFile query, Pageable pageable) {

		Page<SysFile> page = sysFileService.queryPageList(query, pageable);

		return EasyUIPage.formPage(page);
	}

}
