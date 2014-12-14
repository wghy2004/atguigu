package com.atguigu.frame.core.web.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.data.domain.Page;

public class EasyUIPage {

	/**
	 * 转分页为easyui page
	 * 
	 * @param page
	 * @return
	 */
	public static JSONObject formPage(Page page) {

		JSONObject jo = new JSONObject();

		jo.put("total", page.getTotalElements());
		jo.put("pageNumber", page.getNumber());
		jo.put("pageSize", page.getSize());

		jo.put("rows", page.getContent());

		return jo;
	}

	public static Map toMap(Page page) {

		Map map = new HashMap();

		map.put("total", page.getTotalElements());
		map.put("pageNumber", page.getNumber());
		map.put("pageSize", page.getSize());

		map.put("rows", page.getContent());

		return map;
	}

}
