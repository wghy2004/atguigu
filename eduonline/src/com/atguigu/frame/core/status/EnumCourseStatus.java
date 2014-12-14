package com.atguigu.frame.core.status;

/**
 * 课程状态 EnumCourseStatus
 * 
 * @Description
 * @author wg
 * @date 2014年12月13日 上午10:48:19
 *
 */
public enum EnumCourseStatus implements BaseEnum {
	draft("草稿"), published("已发布"), closed("已关闭");

	private String label;

	private EnumCourseStatus(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
