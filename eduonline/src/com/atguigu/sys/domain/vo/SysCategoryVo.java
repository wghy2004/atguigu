package com.atguigu.sys.domain.vo;

import com.atguigu.sys.domain.SysCategory;
import com.atguigu.sys.domain.SysCategoryGroup;

public class SysCategoryVo extends SysCategory {

	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	private SysCategoryGroup sysCategoryGroup;

	public SysCategoryGroup getSysCategoryGroup() {
		return sysCategoryGroup;
	}

	public void setSysCategoryGroup(SysCategoryGroup sysCategoryGroup) {
		this.sysCategoryGroup = sysCategoryGroup;
	}

}