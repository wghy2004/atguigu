package com.atguigu.frame.core.utils;

import java.io.IOException;
import java.util.Properties;

public class SystemConfig {

	public static String basePath = "";
	static {
		try {
			Properties properties = new Properties();
			properties.load(SystemProperties.class.getClassLoader()
					.getResourceAsStream("system.properties"));
			basePath = (String) properties.get("basePath");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
