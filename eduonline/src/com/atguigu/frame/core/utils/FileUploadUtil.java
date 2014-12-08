package com.atguigu.frame.core.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * 功能描述: 上传工具类<br>
 * 创建时间：2009-10-11<br>
 * 版本信息：1.0 <br>
 * 更改时间：2010—12-9<br>
 * 说明：文件上传完成返回Map，若：Map.get("error")==null，则：上传成功，Map.get("uploadPath")返回上传路径；
 * 若：Map.get("error")!=null，则：上传失败，Map.get("error")返回上传错误信息；
 *
 */
public class FileUploadUtil {

	private static final int BUFFER_SIZE = 100 * 1024;
	private static final int MAX_SIZE = 200 * 1024; // 文件的默认上传大小
	private static final String TYPE = "jpg,jpeg,gif,png,"; // 文件的默认上传类型

	private static final String NOT_EXIST = "上传文件不存在";
	private static final String TOO_LARGE = "上传文件太大";
	private static final String TYPE_MSIMATCH = "上传文件类型不匹配";

	/**
	 * 
	 * @param file
	 *            上传文件
	 * @param path
	 *            上传路径
	 * @param request
	 * @return
	 */
	public static Map upload(MultipartFile file, String path,
			HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		if (file == null) {
			map.put("error", NOT_EXIST);// 上传文件不存在
			return map;
		}

		long len = file.getSize();
		if (len > MAX_SIZE) {
			map.put("error", TOO_LARGE);// 上传文件不能超过
			return map;
		}

		if (type(file, "")) {
			String reaPath = upload1(file, path, request);
			map.put("uploadPath", reaPath);
		} else {
			map.put("error", TYPE_MSIMATCH);// 上传文件类型不匹配
		}
		return map;
	}

	/**
	 * 
	 * @param file
	 *            上传文件
	 * @param path
	 *            上传路径
	 * @param fileType
	 *            上传类型
	 * @param request
	 * @return
	 */
	public static Map upload(MultipartFile file, String path, String fileType,
			HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		if (file == null) {
			map.put("error", NOT_EXIST);
			return map;
		}

		long len = file.getSize();
		if (len > MAX_SIZE) {
			map.put("error", TOO_LARGE);
			return map;
		}

		if (type(file, fileType)) {
			String reaPath = upload1(file, path, request);
			map.put("uploadPath", reaPath);
		} else {
			map.put("error", TYPE_MSIMATCH);
		}
		return map;
	}

	/**
	 * 
	 * @param file
	 *            上传文件
	 * @param path
	 *            上传路径
	 * @param fileType
	 *            上传类型
	 * @param size
	 *            上传大小
	 * @param request
	 * @return
	 */
	public static Map upload(MultipartFile file, String path, String fileType,
			int size, HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		if (file == null) {
			map.put("error", NOT_EXIST);// 上传文件不存在
			return map;
		}

		long len = file.getSize();
		if (len > size * 1024) {
			map.put("error", TOO_LARGE);// 上传文件不能超过
			return map;
		}

		if (type(file, fileType)) {
			String reaPath = upload1(file, path, request);
			map.put("uploadPath", reaPath);
		} else {
			map.put("error", TYPE_MSIMATCH);// 上传文件类型不匹配
		}
		return map;
	}

	/**
	 * 
	 * @param file
	 *            上传文件
	 * @param path
	 *            上传路径
	 * @param size
	 *            上传大小
	 * @param request
	 * @return
	 */
	public static Map upload(MultipartFile file, String path, int size,
			HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		if (file == null) {
			map.put("error", NOT_EXIST);
			return map;
		}

		long len = file.getSize();
		if (len > size * 1024) {
			map.put("error", TOO_LARGE);
			return map;
		}

		if (type(file, "")) {
			String reaPath = upload1(file, path, request);
			map.put("uploadPath", reaPath);
		} else {
			map.put("error", TYPE_MSIMATCH);
		}
		return map;
	}

	private static String upload1(MultipartFile file, String path,
			HttpServletRequest request) {
		InputStream in = null;
		OutputStream out = null;
		String reaPath = null;
		try {

			String fileName = file.getOriginalFilename();
			String type = fileName.substring(fileName.lastIndexOf("."));
			int a = 1000;
			int b = 9999;
			String filename = String.valueOf(System.currentTimeMillis())
					+ String.valueOf((long) Math.rint(Math.random()
							* (b - a + 1) + a));

			reaPath = "/upload" + "/" + path + "/" + filename + type;
			String dstPath = request.getRealPath("") + File.separator
					+ "/upload" + File.separator + path + File.separator
					+ filename + type;
			String dstPathDir = request.getRealPath("") + File.separator
					+ "/upload" + File.separator + path;

			// 判断路径是否存在
			File dstDir = new File(dstPathDir);
			if (!dstDir.exists()) {
				dstDir.mkdirs();
			}

			File dstFile = new File(dstPath);
			in = file.getInputStream();
			out = new BufferedOutputStream(new FileOutputStream(dstFile),
					BUFFER_SIZE);
			fileUpload(in, out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (null != in) {
					in.close();
					in = null;
				}
				if (null != out) {
					out.close();
					out = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return reaPath;
	}

	private static void fileUpload(InputStream in, OutputStream out) {
		try {
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != in) {
					in.close();
					in = null;
				}
				if (null != out) {
					out.close();
					out = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static boolean type(MultipartFile file, String types) {
		String fileType = TYPE;
		if (!"".equals(types)) {
			fileType = TYPE + types;
		}
		boolean fla = false;
		String fileName = file.getOriginalFilename();
		if (fileName.lastIndexOf(".") > 0) {
			String type = fileName.substring(fileName.lastIndexOf("."));
			String[] split = null;
			if (!"".equals(fileType)) {
				split = fileType.split(",");
			}

			for (int i = 0; i < split.length; i++) {
				String t = "." + split[i].trim();
				if (type.equalsIgnoreCase(t)) {
					fla = true;
					break;
				}
			}
		}
		return fla;
	}

	/**
	 * @param file
	 * @param request
	 * @return
	 */
	public static Map uploadProductFile(MultipartFile file,
			HttpServletRequest request) {
		String path = "products";
		String fileType = "";
		int size = 1024 * 40;
		Map<String, String> map = new HashMap<String, String>();
		if (file == null) {
			map.put("error", NOT_EXIST);// 上传文件不存在
			return map;
		}

		long len = file.getSize();
		if (len > size * 1024) {
			map.put("error", TOO_LARGE);// 上传文件不能超过
			return map;
		}

		if (type(file, fileType)) {
			String reaPath = upload1(file, path, request);
			map.put("uploadPath", reaPath);
		} else {
			map.put("error", TYPE_MSIMATCH);// 上传文件类型不匹配
		}
		return map;
	}

}
