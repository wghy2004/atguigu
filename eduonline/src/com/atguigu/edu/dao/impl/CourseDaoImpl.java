package com.atguigu.edu.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Repository;

import com.atguigu.edu.dao.CourseDao;
import com.atguigu.frame.core.dao.constants.SqlId;
import com.atguigu.frame.core.dao.impl.BaseDaoImpl;
import com.atguigu.frame.core.exception.DaoException;
import com.atguigu.frame.core.utils.BeanUtils;
import com.atguigu.sys.domain.SysCourse;

/**
 * 
 * CourseDaoImpl
 * 
 * @Description
 * @author wg
 * @date 2014年11月9日 下午3:09:51
 *
 */
@Repository
public class CourseDaoImpl extends BaseDaoImpl<SysCourse> implements CourseDao {

	@Override
	public List<SysCourse> selectList(Map map) {
		try {

			return sqlSessionTemplate.selectList(getSqlName("selectByMap"),
					map);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象列表出错！语句：%s",
					getSqlName("selectByMap")), e);
		}
	}

}
