package com.atguigu.frame.core.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class TemplateUtil {
	/**
	 * 生成静态页面主方法
	 * 
	 * @param context
	 *            ServletContext
	 * @param data
	 *            一个Map的数据结果集
	 * @param templatePath
	 *            ftl模版路径
	 * @param targetHtmlPath
	 *            生成静态页面的路径
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	public static void crateHTML(ServletContext context,
			Map<String, Object> data, String templatePath, String targetHtmlPath) throws IOException, TemplateException {
		Configuration freemarkerCfg = new Configuration();
		// 加载模版
		freemarkerCfg.setServletContextForTemplateLoading(context, "/WEB-INF/ftl/edu/");
		freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8");
		// 指定模版路径
		Template template = freemarkerCfg.getTemplate(templatePath, "UTF-8");
		template.setEncoding("UTF-8");
		// 静态页面路径
		String htmlPath = context.getRealPath("/html") + "/" + targetHtmlPath;
		File htmlFile = new File(htmlPath);
		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(htmlFile), "UTF-8"));
		// 处理模版
		template.process(data, out);
		out.flush();
		out.close();
	}
}
