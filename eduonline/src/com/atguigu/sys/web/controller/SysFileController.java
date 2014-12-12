package com.atguigu.sys.web.controller;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.atguigu.frame.core.dao.BaseService;
import com.atguigu.frame.core.utils.FileUploadUtil;
import com.atguigu.frame.core.utils.SystemConfig;
import com.atguigu.frame.core.web.controller.BaseControllerImpl;
import com.atguigu.frame.core.web.domain.EasyUIPage;
import com.atguigu.frame.core.web.domain.Result;
import com.atguigu.frame.core.web.domain.Result.Status;
import com.atguigu.sys.domain.SysFile;
import com.atguigu.sys.service.SysFileService;

/**
 * 文件的基本操作 SysFileController
 * 
 * @Description
 * @author wg
 * @date 2014年12月6日 下午8:15:37
 *
 */
@Controller
@RequestMapping("/sys/file")
public class SysFileController extends BaseControllerImpl<SysFile, SysFile> {
	@Autowired
	private SysFileService sysFileService;

	@Override
	protected BaseService<SysFile> getBaseService() {
		return sysFileService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String selectListJson(SysFile query, Pageable pageable) {

		Page<SysFile> page = sysFileService.queryPageList(query, pageable);

		return EasyUIPage.formPage(page).toString();
	}

	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Result addOne(HttpServletRequest request,
			HttpServletResponse response, SysFile entity) {

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		MultipartFile file = multipartRequest.getFile("files");

		if (!StringUtils.isEmpty(file.getOriginalFilename())) {
			Map<String, String> map = FileUploadUtil.upload(file, "file", "",
					1024 * 40, request);// upload是文件夹名字
			String filePath = map.get("uploadPath");// 路径
			if (!StringUtils.isEmpty(filePath)) {
				entity.setUri(filePath);
			}
			entity.setSize((int) file.getSize());

			entity.setMime(file.getContentType());

			entity.setUserId(SystemConfig.getLoginUser(request).getId());

			if (null == entity.getGroupId()) {
				entity.setGroupId(0L);
			}

			if (null == entity.getStatus()) {
				entity.setStatus(0);
			}

			entity.setCreatedTime(new Timestamp(System.currentTimeMillis()));

		}

		sysFileService.insert(entity);

		return new Result(Status.OK, entity);
	}

}
