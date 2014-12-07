package com.atguigu.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.frame.core.dao.impl.BaseServiceImpl;
import com.atguigu.sys.dao.SysFileDao;
import com.atguigu.sys.domain.SysFile;
import com.atguigu.sys.service.SysFileService;

/**
 * 文件服务 SysFileServiceImpl
 * 
 * @Description
 * @author wg
 * @date 2014年12月6日 下午8:09:48
 *
 */
@Service
public class SysFileServiceImpl extends BaseServiceImpl<SysFile> implements
		SysFileService {

	@Autowired
	private SysFileDao sysFileDao;

	@Override
	protected BaseDao<SysFile> getBaseDao() {
		return sysFileDao;
	}

}