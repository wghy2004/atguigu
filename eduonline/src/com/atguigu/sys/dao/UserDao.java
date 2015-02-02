package com.atguigu.sys.dao;

import java.util.Date;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.sys.domain.SysUser;

/**
*  UserDao 
*  @Description :
*  @author wg
*  @date 2014年10月5日 下午2:43:15 
*
 */
public interface UserDao extends BaseDao<SysUser> {
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public SysUser selectByLogin(SysUser user);
	
	/**
	 * 查询注册人数
	 * @param date
	 * @return
	 */
	public int selectRegCount(Date date);
	
}

