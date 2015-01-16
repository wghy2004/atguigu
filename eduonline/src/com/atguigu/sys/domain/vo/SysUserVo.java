package com.atguigu.sys.domain.vo;

import com.atguigu.sys.domain.SysUser;
import com.atguigu.sys.domain.SysUserProfile;

/**
 * 
 * 
 * @date 2014年3月3日下午1:32:09
 */
public class SysUserVo extends SysUser {
	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -1742693268284282756L;

	private SysUserProfile sysUserProfile;

	public SysUserProfile getSysUserProfile() {
		return sysUserProfile;
	}

	public void setSysUserProfile(SysUserProfile sysUserProfile) {
		this.sysUserProfile = sysUserProfile;
	}

}
