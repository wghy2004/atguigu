package com.atguigu.sys.service.impl;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.atguigu.frame.core.dao.BaseDao;
import com.atguigu.frame.core.dao.impl.BaseServiceImpl;
import com.atguigu.frame.core.utils.FileUploadUtil;
import com.atguigu.frame.core.utils.SystemConfig;
import com.atguigu.sys.dao.SysFileDao;
import com.atguigu.sys.domain.SysFile;
import com.atguigu.sys.service.SysFileService;

/**
 * 文件服务 SysFileServiceImpl
 * 
 * @Description
 * @author wg
 * @date 2014年12月6日 下午8:09:48
 *
 */
@Service
public class SysFileServiceImpl extends BaseServiceImpl<SysFile> implements
		SysFileService {

	@Autowired
	private SysFileDao sysFileDao;

	@Override
	protected BaseDao<SysFile> getBaseDao() {
		return sysFileDao;
	}

	@Override
	public SysFile addOne(HttpServletRequest request, SysFile entity) {

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

			entity.setCreatedTime(new Timestamp(System.currentTimeMillis()));

		}

		sysFileDao.insert(entity);

		return entity;
	}

}