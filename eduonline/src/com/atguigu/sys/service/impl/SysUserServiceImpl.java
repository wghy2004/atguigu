package com.atguigu.sys.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.frame.core.dao.impl.BaseServiceImpl;
import com.atguigu.sys.dao.UserDao;
import com.atguigu.sys.domain.SysUser;
import com.atguigu.sys.service.SysUserService;

/**
 * UserServiceImpl
 * 
 * @Description
 * @author wg
 * @date 2014年10月5日 下午2:55:18
 *
 */
@Service("userService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements
		SysUserService {

	@Autowired
	private UserDao userDao;

	@Override
	protected BaseDao<SysUser> getBaseDao() {
		return userDao;
	}

	@Override
	public SysUser login(SysUser user) {

		return userDao.selectByLogin(user);

	}

	@Override
	public int getRegisterCount(Date date) {
		
		return userDao.selectRegCount(date);
	}
	

}
