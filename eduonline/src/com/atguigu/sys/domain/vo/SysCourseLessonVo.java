package com.atguigu.sys.domain.vo;

import com.atguigu.sys.domain.SysCourse;
import com.atguigu.sys.domain.SysCourseLesson;

public class SysCourseLessonVo extends SysCourseLesson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SysCourse sysCourse;

	public SysCourse getSysCourse() {
		return sysCourse;
	}

	public void setSysCourse(SysCourse sysCourse) {
		this.sysCourse = sysCourse;
	}

	

}