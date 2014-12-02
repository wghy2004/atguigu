package com.atguigu.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.frame.core.dao.impl.BaseServiceImpl;
import com.atguigu.sys.dao.SysCategoryGroupDao;
import com.atguigu.sys.domain.SysCategoryGroup;
import com.atguigu.sys.service.SysCategoryGroupService;

@Service
public class SysCategoryGroupServiceImpl extends
		BaseServiceImpl<SysCategoryGroup> implements SysCategoryGroupService {

	@Autowired
	private SysCategoryGroupDao sysCategoryGroupDao;

	@Override
	protected BaseDao<SysCategoryGroup> getBaseDao() {
		return sysCategoryGroupDao;
	}

}
