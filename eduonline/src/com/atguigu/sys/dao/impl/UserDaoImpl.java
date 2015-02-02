package com.atguigu.sys.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.atguigu.frame.core.dao.impl.BaseDaoImpl;
import com.atguigu.frame.core.exception.DaoException;
import com.atguigu.sys.dao.UserDao;
import com.atguigu.sys.domain.SysUser;

/**
 * UserDaoImpl
 * 
 * @Description :
 * @author wg
 * @date 2014年10月5日 下午2:46:46
 *
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<SysUser> implements UserDao {

	@Override
	public SysUser selectByLogin(SysUser user) {
		try {
			return sqlSessionTemplate.selectOne(getSqlName("login"), user);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID删除对象出错！语句：%s",
					getSqlName("selectByLogin")), e);
		}
	}

	@Override
	public int selectRegCount(Date date) {

		Map<String, Date> map = new HashMap<String, Date>();

		map.put("regDate", date);

		try {
			return sqlSessionTemplate.selectOne(getSqlName("selectRegCount"),
					map);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID删除对象出错！语句：%s",
					getSqlName("selectByLogin")), e);
		}
	}

}
