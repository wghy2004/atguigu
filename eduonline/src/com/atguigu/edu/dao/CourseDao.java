package com.atguigu.edu.dao;

import java.util.List;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.sys.domain.SysCourse;

public interface CourseDao extends BaseDao<SysCourse> {
	/**
	 * 限制个数
	 * @param count
	 * @return
	 */
	public List<SysCourse> selectList(int count);

}