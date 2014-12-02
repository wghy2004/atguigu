package com.atguigu.sys.dao;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.sys.domain.SysCourse;
import com.atguigu.sys.domain.SysCourseExample;
import com.atguigu.sys.domain.SysCourseWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysCourseDao extends BaseDao<SysCourse> {
	
}