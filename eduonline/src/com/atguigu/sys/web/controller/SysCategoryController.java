package com.atguigu.sys.web.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.frame.core.dao.BaseService;
import com.atguigu.frame.core.web.controller.BaseControllerImpl;
import com.atguigu.sys.domain.SysCategory;
import com.atguigu.sys.domain.SysCategoryGroup;
import com.atguigu.sys.domain.vo.SysCategoryVo;
import com.atguigu.sys.service.SysCategoryGroupService;
import com.atguigu.sys.service.SysCategoryService;

/**
 * 
 * SysCategoryController
 * 
 * @Description
 * @author wg
 * @date 2014年10月19日 下午5:11:55
 *
 */
@Controller
@RequestMapping("/sys/category")
public class SysCategoryController extends
		BaseControllerImpl<SysCategory, SysCategory> {

	@Autowired
	private SysCategoryService sysCategoryService;

	@Autowired
	private SysCategoryGroupService sysCategoryGroupService;

	@Override
	protected BaseService<SysCategory> getBaseService() {

		return sysCategoryService;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView selectList(SysCategory query,
			@PageableDefault Pageable pageable) {

		List<SysCategoryGroup> groupList = sysCategoryGroupService.queryAll();

		Map map = new HashedMap();

		map.put("groupList", groupList);

		query.setGroupId(Integer.valueOf(String.valueOf(groupList.get(0)
				.getId())));

		Page<SysCategory> page = getBaseService()
				.queryPageList(query, pageable);

		map.put("categoryList", page);

		ModelAndView mav = new ModelAndView(path.getListViewPath(), "model",
				map);

		mav.addObject("query", query);

		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray selectListJson(SysCategory query,
			@PageableDefault Pageable pageable) {
		Page<SysCategory> page = sysCategoryService.queryPageList(query,
				pageable);
		// [{"0":"7","id":"7","1":"1","parentId":"1","2":"Printers","name":"Printers","3":null,"quantity":null,"4":null,"price":null,"state":"closed","total":0}]
		System.out.println(page.getContent());
		System.out.println(this.sysCategoryService.getClass().getMethods());

		Method[] ms = this.sysCategoryService.getClass().getMethods();

		for (int i = 0; i < ms.length; i++) {
			System.out.println(ms[i].getName());
		}

		JSONArray ja = this.sysCategoryService.toTreeJson(page.getContent());

		System.out.println(ja);

		return ja;
	}

	@Override
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editView(@PathVariable("id") long id) {
		System.out.println("sss--------------");

		SysCategory category = getBaseService().queryById(id);

		SysCategory pcategory = getBaseService().queryById(
				(long) category.getParentId());

		if (pcategory == null) {
			pcategory = new SysCategory();
			pcategory.setName("根节点");
		}

		SysCategoryVo categoryVo = (SysCategoryVo) category;

		categoryVo.setParentName(pcategory.getName());

		List<SysCategoryGroup> list = sysCategoryGroupService.queryAll();

		Map<String, Object> map = new HashedMap();

		map.put("category", categoryVo);

		map.put("groups", list);

		map.put("rootCategorys", selectListByMap(0));

		return new ModelAndView(path.getEditViewPath(), "model", map);

	}

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addOne(SysCategory sysCategory) {

		SysCategory parent = sysCategoryService.queryById((long) sysCategory
				.getParentId());

		sysCategory.setPath(parent.getPath() + parent.getId() + "|");

		getBaseService().insert(sysCategory);

		return new ModelAndView(path.getRedirectListPath());
	}

	@Override
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addView() {

		List<SysCategoryGroup> list = sysCategoryGroupService.queryAll();

		Map<String, Object> map = new HashedMap();

		map.put("groups", list);

		return new ModelAndView(path.getAddViewPath(), "model", map);
	}

	@RequestMapping(value = "/child/{parentId}", method = RequestMethod.GET)
	@ResponseBody
	public List<JSONObject> selectChild(@PathVariable("parentId") int parentId) {

		// {"text":"New node","children":true,"id":"New node\/New node\/New
		// node","icon":"folder"}

		List<SysCategory> categorys = selectListByMap(parentId);

		List<JSONObject> list = new ArrayList<JSONObject>();

		JSONObject json = null;

		SysCategory sysCategory = null;

		for (int i = 0, len = categorys.size(); i < len; i++) {
			json = new JSONObject();
			sysCategory = categorys.get(i);
			json.element("id", sysCategory.getId());
			json.element("text", sysCategory.getName());
			json.element("children", true);
			list.add(json);
		}

		return list;

	}

	/**
	 * 取子分类
	 * 
	 * @param parentId
	 * @return
	 */
	public List<SysCategory> selectListByMap(int parentId) {

		SysCategory query = new SysCategory();

		query.setParentId(parentId);

		return getBaseService().queryList(query);

	}

}
