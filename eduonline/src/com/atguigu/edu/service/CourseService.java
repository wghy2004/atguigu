package com.atguigu.edu.service;

import java.util.List;

import com.atguigu.frame.core.dao.BaseService;
import com.atguigu.sys.domain.SysCourse;

public interface CourseService extends BaseService<SysCourse> {
	
	/**
	 * 首页课程
	 * @return
	 */
	public List<SysCourse> getIndexCourse(int count);
	

}
