package com.atguigu.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.frame.core.dao.impl.BaseServiceImpl;
import com.atguigu.sys.dao.SysCategoryDao;
import com.atguigu.sys.domain.SysCategory;
import com.atguigu.sys.service.SysCategoryService;

@Service
public class SysCategoryServiceImpl extends BaseServiceImpl<SysCategory>
		implements SysCategoryService {

	@Autowired
	private SysCategoryDao sysCategoryDao;

	private List<SysCategory> list;

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
	public List<SysCategory> getChild(SysCategory sysCategory) {

		SysCategory tmp = null;

		List<SysCategory> childs = new ArrayList<SysCategory>();

		for (int i = 0, len = this.list.size(); i < len; i++) {
			tmp = this.list.get(i);
			if (tmp.getPath().equals(
					sysCategory.getPath() + sysCategory.getId() + "|")) {
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
	public List<SysCategory> getRoot() {
		SysCategory tmp = null;

		List<SysCategory> root = new ArrayList<SysCategory>();

		for (int i = 0, len = this.list.size(); i < len; i++) {
			tmp = list.get(i);
			if (tmp.getParentId() == 0) {
				root.add(tmp);
			}
		}

		return root;
	}

	public boolean hasChild(SysCategory sysCategory) {

		SysCategory tmp = null;

		List<SysCategory> childs = new ArrayList<SysCategory>();

		for (int i = 0, len = this.list.size(); i < len; i++) {

			if (tmp.getPath().equals(
					sysCategory.getPath() + sysCategory.getId() + "|")) {
				return true;
			}
		}

		return false;
	}

	public JSONObject toChildTreeJson(SysCategory sysCategory) {

		JSONObject treeJson = new JSONObject();

		treeJson.put("id", sysCategory.getId());
		treeJson.put("name", sysCategory.getName());
		treeJson.put("weight", sysCategory.getWeight());
		treeJson.put("code", sysCategory.getCode());
		treeJson.put("parentId", sysCategory.getParentId());

		if (hasChild(sysCategory)) {

			List<SysCategory> childs = this.getChild(sysCategory);

			for (int i = 0, len = childs.size(); i < len; i++) {

				toChildTreeJson(childs.get(i));

			}
		}

		return treeJson;

	}

	@Override
	public JSONArray toTreeJson(List<SysCategory> list) {

		this.list = list;

		JSONArray ja = new JSONArray();

		JSONObject treeJson = new JSONObject();

		JSONObject treeJsonTmp = null;

		List<SysCategory> root = this.getRoot();

		SysCategory rootCategory = null;
		for (int i = 0, len = root.size(); i < len; i++) {
			treeJsonTmp = new JSONObject();
			rootCategory = root.get(i);
			treeJsonTmp.put("id", rootCategory.getId());
			treeJsonTmp.put("name", rootCategory.getName());
			treeJsonTmp.put("weight", rootCategory.getWeight());
			treeJsonTmp.put("code", rootCategory.getCode());
			treeJsonTmp.put("parentId", rootCategory.getParentId());

			treeJsonTmp.put("children", toChildTreeJson(root.get(i)));

			ja.add(treeJsonTmp);
		}
		return ja;
	}

}
