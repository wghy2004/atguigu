package com.atguigu.sys.service;

import java.util.Date;

import com.atguigu.frame.core.dao.BaseService;
import com.atguigu.sys.domain.SysUser;

/**
 * SysUserService
 * 
 * @Description 用户基本信息服务类
 * @author wg
 * @date 2014年10月5日 下午2:52:50
 *
 */
public interface SysUserService extends BaseService<SysUser> {

	public SysUser login(SysUser user);

	public int getRegisterCount(Date date);

}
