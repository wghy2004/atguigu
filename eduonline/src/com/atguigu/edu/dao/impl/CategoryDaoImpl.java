package com.atguigu.edu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.atguigu.edu.dao.CategoryDao;
import com.atguigu.frame.core.dao.impl.BaseDaoImpl;
import com.atguigu.frame.core.exception.DaoException;
import com.atguigu.sys.domain.SysCategory;

/**
 * 
 * CategoryDaoImpl
 * 
 * @Description
 * @author wg
 * @date 2014年10月19日 下午5:09:55
 *
 */
@Repository
public class CategoryDaoImpl extends BaseDaoImpl<SysCategory> implements
		CategoryDao {
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
	public JSONArray toTree(List<SysCategory> list, long id) {

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
						toTree(getAllChild(list, category.getId()),
								category.getId()));
			}
			ja.add(treeJson);
		}
		return ja;
	}

}
