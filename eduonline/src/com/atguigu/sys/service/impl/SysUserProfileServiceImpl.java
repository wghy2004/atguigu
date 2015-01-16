package com.atguigu.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.frame.core.dao.impl.BaseServiceImpl;
import com.atguigu.sys.dao.SysUserProfileDao;
import com.atguigu.sys.domain.SysUserProfile;
import com.atguigu.sys.service.SysUserProfileService;

/**
 * UserServiceImpl
 * 
 * @Description
 * @author wg
 * @date 2014年10月5日 下午2:55:18
 *
 */
@Service
public class SysUserProfileServiceImpl extends BaseServiceImpl<SysUserProfile> implements SysUserProfileService {

	@Autowired
	private SysUserProfileDao userDao;

	@Override
	protected BaseDao<SysUserProfile> getBaseDao() {
		return userDao;
	}

}
