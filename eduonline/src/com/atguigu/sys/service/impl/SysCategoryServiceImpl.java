package com.atguigu.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.frame.core.dao.impl.BaseServiceImpl;
import com.atguigu.sys.dao.SysCategoryDao;
import com.atguigu.sys.domain.SysCategory;
import com.atguigu.sys.service.SysCategoryService;
import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

@Service
public class SysCategoryServiceImpl extends BaseServiceImpl<SysCategory>
		implements SysCategoryService {

	@Autowired
	private SysCategoryDao sysCategoryDao;

	@Override
	protected BaseDao<SysCategory> getBaseDao() {
		return sysCategoryDao;
	}

	/**
	 * 获得子节点
	 * 
	 * @param list
	 * @param sysCategory
	 * @return
	 */
	public List<SysCategory> getChild(List<SysCategory> list,
			SysCategory sysCategory) {

		SysCategory tmp = null;

		List<SysCategory> childs = new ArrayList<SysCategory>();

		for (int i = 0, len = list.size(); i < len; i++) {
			tmp = list.get(i);
			if (sysCategory.getPath().equals(tmp.getPath() + tmp.getId() + "|")) {
				childs.add(tmp);
			}
		}

		return childs;
	}

	/**
	 * 取根节点
	 * 
	 * @param list
	 * @return
	 */
	public List<SysCategory> getRoot(List<SysCategory> list) {
		SysCategory tmp = null;

		List<SysCategory> root = new ArrayList<SysCategory>();

		for (int i = 0, len = list.size(); i < len; i++) {
			tmp = list.get(i);
			if (tmp.getParentId() == 0) {
				root.add(tmp);
			}
		}

		return root;
	}

	public JSONObject toChildTreeJson(List<SysCategory> list,
			SysCategory sysCategory, JSONObject treeJson) {

		SysCategory tmp = null;

		List<SysCategory> childs = this.getChild(list, sysCategory);

		treeJson.put("id", sysCategory.getId());
		treeJson.put("name", sysCategory.getName());
		treeJson.put("children", childs);

		for (int i = 0, len = childs.size(); i < len; i++) {
			this.toChildTreeJson(list, childs.get(i), treeJson);
		}

		return treeJson;

	}

	@Override
	public JSONArray toTreeJson(List<SysCategory> list) {
		System.out.println("dddddddddddddddddddddddddddddddddddddddddddd");

		JSONArray ja = new JSONArray();

		JSONObject treeJson = new JSONObject();

		List<SysCategory> root = this.getRoot(list);

		for (int i = 0, len = root.size(); i < len; i++) {
			ja.add(this.toChildTreeJson(list, root.get(i), treeJson));
		}
		return ja;
	}

}
