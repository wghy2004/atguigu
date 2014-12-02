package com.atguigu.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.frame.core.dao.impl.BaseServiceImpl;
import com.atguigu.sys.dao.SysCourseDao;
import com.atguigu.sys.domain.SysCourse;
import com.atguigu.sys.service.SysCourseService;

@Service
public class SysCourseServiceImpl extends BaseServiceImpl<SysCourse> implements
		SysCourseService {
	@Autowired
	private SysCourseDao sysCourseDao;

	@Override
	protected BaseDao<SysCourse> getBaseDao() {
		return sysCourseDao;
	}

}
