package com.atguigu.edu.dao;

import java.util.List;

import net.sf.json.JSONArray;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.sys.domain.SysCategory;

/**
 * 
 * CategoryDao
 * 
 * @Description
 * @author wg
 * @date 2014年10月19日 下午5:08:41
 *
 */
public interface CategoryDao extends BaseDao<SysCategory> {
	public List<SysCategory> toTree(List<SysCategory> list, long id);
}