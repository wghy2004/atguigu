package com.atguigu.sys.service;

import javax.servlet.http.HttpServletRequest;

import com.atguigu.frame.core.dao.BaseService;
import com.atguigu.sys.domain.SysFile;

public interface SysFileService extends BaseService<SysFile> {

	public SysFile addOne(HttpServletRequest request, SysFile entity);

}