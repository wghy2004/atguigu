package com.atguigu.sys.dao;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.sys.domain.SysCategory;
/**
 * 
*  SysCategoryDao 
*  @Description 
*  @author wg
*  @date 2014年10月19日 下午5:08:41 
*
 */
public interface SysCategoryDao extends BaseDao<SysCategory> {
	/**
	 * 删除子节点
	 * @param id
	 * @return
	 */
	public int deleteChild(long id);
	
}