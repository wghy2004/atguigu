package com.atguigu.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.edu.service.CourseService;
import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.frame.core.dao.impl.BaseServiceImpl;
import com.atguigu.sys.dao.SysCourseDao;
import com.atguigu.sys.domain.SysCourse;

@Service
public class CourseServiceImpl extends BaseServiceImpl<SysCourse> implements
		CourseService {
	@Autowired
	private SysCourseDao sysCourseDao;

	@Override
	protected BaseDao<SysCourse> getBaseDao() {
		return sysCourseDao;
	}

	@Override
	public List<SysCourse> getIndexCourse(int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
