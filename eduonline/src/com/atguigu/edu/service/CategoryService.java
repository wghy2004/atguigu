package com.atguigu.edu.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.atguigu.frame.core.dao.BaseService;
import com.atguigu.sys.domain.SysCategory;

/**
 * 
 * SysCategoryService
 * 
 * @Description
 * @author wg
 * @date 2014年10月19日 下午5:10:14
 *
 */
public interface CategoryService extends BaseService<SysCategory> {

	/**
	 * 转换成easyui tree
	 * 
	 * @param list
	 * @param id
	 * @return
	 */

	public List<SysCategory> toTree(List<SysCategory> list, long id);

	public JSONArray getIndexCategory(int parentCount, int childCount);

}
