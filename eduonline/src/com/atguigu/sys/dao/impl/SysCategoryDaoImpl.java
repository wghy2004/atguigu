package com.atguigu.sys.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.atguigu.frame.core.dao.constants.SqlId;
import com.atguigu.frame.core.dao.impl.BaseDaoImpl;
import com.atguigu.frame.core.exception.DaoException;
import com.atguigu.sys.dao.SysCategoryDao;
import com.atguigu.sys.domain.SysCategory;

/**
 * 
 * SysCategoryDaoImpl
 * 
 * @Description
 * @author wg
 * @date 2014年10月19日 下午5:09:55
 *
 */
@Repository
public class SysCategoryDaoImpl extends BaseDaoImpl<SysCategory> implements
		SysCategoryDao {

	@Override
	public int deleteChild(long id) {
		Assert.notNull(id);
		try {
			return sqlSessionTemplate.delete(getSqlName("deleteChild"), id);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID删除对象出错！语句：%s",
					getSqlName("deleteChild")), e);
		}
	}

}
