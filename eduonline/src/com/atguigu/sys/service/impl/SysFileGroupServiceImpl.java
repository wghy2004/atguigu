package com.atguigu.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.frame.core.dao.BaseService;
import com.atguigu.frame.core.dao.impl.BaseDaoImpl;
import com.atguigu.frame.core.dao.impl.BaseServiceImpl;
import com.atguigu.sys.dao.SysFileGroupDao;
import com.atguigu.sys.domain.SysFile;
import com.atguigu.sys.domain.SysFileGroup;
import com.atguigu.sys.service.SysFileGroupService;

/**
 * 文件组服务 SysFileGroupServiceImpl
 * 
 * @Description
 * @author wg
 * @date 2014年12月6日 下午8:11:42
 *
 */
@Service
public class SysFileGroupServiceImpl extends BaseServiceImpl<SysFileGroup>
		implements SysFileGroupService {

	@Autowired
	private SysFileGroupDao sysFileGroupDao;

	@Override
	protected BaseDao<SysFileGroup> getBaseDao() {
		return sysFileGroupDao;
	}

}