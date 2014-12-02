package com.atguigu.sys.domain.vo;

import com.atguigu.sys.domain.SysCategory;
import com.atguigu.sys.domain.SysCategoryGroup;
import com.atguigu.sys.domain.SysCourse;

public class SysCourseVo extends SysCourse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SysCategory sysCategory;

	private SysCategoryGroup sysCategoryGroup;

	public SysCategory getSysCategory() {
		return sysCategory;
	}

	public void setSysCategory(SysCategory sysCategory) {
		this.sysCategory = sysCategory;
	}

	public SysCategoryGroup getSysCategoryGroup() {
		return sysCategoryGroup;
	}

	public void setSysCategoryGroup(SysCategoryGroup sysCategoryGroup) {
		this.sysCategoryGroup = sysCategoryGroup;
	}

}