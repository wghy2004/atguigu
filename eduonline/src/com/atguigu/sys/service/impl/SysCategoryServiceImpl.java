package com.atguigu.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<SysCategory> getChild(List<SysCategory> list, long id) {

		SysCategory tmp = null;

		List<SysCategory> childs = new ArrayList<SysCategory>();

		for (int i = 0, len = list.size(); i < len; i++) {

			tmp = list.get(i);

			if (tmp.getParentId() == id) {

				childs.add(tmp);

			}
		}

		return childs;
	}
	/**
	 * 获得所有子节点
	 * 
	 * @param list
	 * @param sysCategory
	 * @return
	 */
	public List<SysCategory> getAllChild(List<SysCategory> list, long id) {

		SysCategory tmp = null;

		List<SysCategory> childs = new ArrayList<SysCategory>();

		for (int i = 0, len = list.size(); i < len; i++) {

			tmp = list.get(i);

			if (tmp.getPath().contains(id+"|")) {

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
	/**
	 * 判断子节点
	 * @param list
	 * @param id
	 * @return
	 */
	public boolean hasChild(List<SysCategory> list, long id) {

		SysCategory category = null;

		for (int i = 0, len = list.size(); i < len; i++) {
			category = list.get(i);
			if (category.getParentId() == id) {
				return true;
			}
		}

		return false;
	}

	@Override
	public JSONArray toTreeJson(List<SysCategory> list, long id) {

		JSONArray ja = new JSONArray();

		JSONObject treeJson = new JSONObject();

		List<SysCategory> categorys = null;

		if (id == 0) {
			categorys = getRoot(list);
		} else {
			categorys = getChild(list, id);
		}

		SysCategory category = null;
		for (int i = 0, len = categorys.size(); i < len; i++) {
			treeJson = new JSONObject();
			category = categorys.get(i);
			treeJson.put("id", category.getId());
			treeJson.put("name", category.getName());
			treeJson.put("weight", category.getWeight());
			treeJson.put("code", category.getCode());
			treeJson.put("parentId", category.getParentId());
			treeJson.put("path", category.getPath());
			if (hasChild(list, category.getId())) {
				treeJson.put(
						"children",
						toTreeJson(getAllChild(list, category.getId()),
								category.getId()));
			}
			ja.add(treeJson);
		}
		return ja;
	}

	@Override
	public JSONArray toCombotree(List<SysCategory> list, long id) {
		JSONArray ja = new JSONArray();

		JSONObject treeJson = new JSONObject();

		List<SysCategory> categorys = null;

		if (id == 0) {
			categorys = getRoot(list);
		} else {
			categorys = getChild(list, id);
		}

		SysCategory category = null;
		for (int i = 0, len = categorys.size(); i < len; i++) {
			treeJson = new JSONObject();
			category = categorys.get(i);
			treeJson.put("id", category.getId());
			treeJson.put("text", category.getName());
			treeJson.put("path", category.getPath());
			if (hasChild(list, category.getId())) {
				treeJson.put(
						"children",
						toCombotree(getAllChild(list, category.getId()),
								category.getId()));
			}
			ja.add(treeJson);
		}
		return ja;
	}

	@Override
	@Transactional
	public int deleteById(long id) {
		int count = sysCategoryDao.deleteById(id);
		count += sysCategoryDao.deleteChild(id);
		return count;
	}
	
}
