package com.atguigu.sys.domain.vo;

import com.atguigu.sys.domain.SysFile;
import com.atguigu.sys.domain.SysFileGroup;

public class SysFileVo extends SysFile {

	private SysFileGroup sysFileGroup;

	public SysFileGroup getSysFileGroup() {
		return sysFileGroup;
	}

	public void setSysFileGroup(SysFileGroup sysFileGroup) {
		this.sysFileGroup = sysFileGroup;
	}

}
