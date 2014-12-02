package com.atguigu.frame.core.status;

public enum EnumNumberStatus implements BaseEnum {
	YES("是", 1), NO("否", 0);

	// 成员变量
	private String label;
	private int num;

	// 构造方法
	private EnumNumberStatus(String label, int num) {
		this.label = label;
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	// 普通方法
	public static String getLabel(int num) {
		for (EnumNumberStatus c : EnumNumberStatus.values()) {
			if (c.getNum() == num) {
				return c.label;
			}
		}
		return null;
	}

	@Override
	public String getLabel() {
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(EnumNumberStatus.getLabel(0));
	}
}
