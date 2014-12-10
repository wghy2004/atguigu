package com.atguigu.frame.core.utils;

import java.io.IOException;
import java.util.Properties;

public class SystemProperties {

	private static Properties SYSTEMPROPERTIES = new Properties();

	static {
		try {
			SYSTEMPROPERTIES.load(SystemProperties.class.getClassLoader()
					.getResourceAsStream("system.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return (String) SYSTEMPROPERTIES.get(key);
	}

}
