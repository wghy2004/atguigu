package com.atguigu.edu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.edu.dao.CourseDao;
import com.atguigu.edu.service.CourseService;
import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.frame.core.dao.impl.BaseServiceImpl;
import com.atguigu.sys.domain.SysCourse;

@Service
public class CourseServiceImpl extends BaseServiceImpl<SysCourse> implements
		CourseService {
	@Autowired
	private CourseDao courseDao;

	@Override
	protected BaseDao<SysCourse> getBaseDao() {
		return courseDao;
	}

	@Override
	public List<SysCourse> getIndexCourse(int count) {

		Map<String, Object> map = new HashMap();

		map.put("status", "published");
		map.put("sorting", "id desc");
		map.put("offset", 0);
		map.put("limit" , count);
		
		return courseDao.selectList(map);
	}

}
