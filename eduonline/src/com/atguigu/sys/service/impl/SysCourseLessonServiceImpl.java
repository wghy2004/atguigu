package com.atguigu.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.frame.core.dao.impl.BaseServiceImpl;
import com.atguigu.sys.dao.SysCourseLessonDao;
import com.atguigu.sys.domain.SysCourseLesson;
import com.atguigu.sys.service.SysCourseLessonService;

@Service
public class SysCourseLessonServiceImpl extends
		BaseServiceImpl<SysCourseLesson> implements SysCourseLessonService {

	@Autowired
	private SysCourseLessonDao sysCourseLessonDao;

	@Override
	protected BaseDao<SysCourseLesson> getBaseDao() {
		return sysCourseLessonDao;
	}

}
