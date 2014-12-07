package com.atguigu.frame.core.web.domain;

import net.sf.json.JSONObject;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;

public class EasyUIPage {

	/**
	 * 转分页为easyui page
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

}
