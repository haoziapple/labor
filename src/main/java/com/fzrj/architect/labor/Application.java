package com.fzrj.architect.labor;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fzrj.architect.labor.generate.Generator;
import com.fzrj.architect.labor.parameter.UserInputParamters;
import com.fzrj.architect.labor.utils.DownloadUtil;
import com.fzrj.architect.labor.utils.ZipUtil;

/**
 * @className:com.fzrj.architect.labor.Application
 * @description:服务启动类
 * @version:v1.0.0
 * @date:2017年6月22日 上午11:16:33
 * @author:WangHao
 */
@SpringBootApplication
@Controller
public class Application
{
	private static final String PATH = "/home/labor_generated";
//	private static final String PATH = "F:\\myLaborProject";
	
	private static final String STRATEGY = "ssm";

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	private static final Object locker = new Object();

	public static void main(String[] args)
	{
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames)
		{
			System.out.println(beanName);
		}
	}

	@RequestMapping("/gen")
	public String gen()
	{
		return "index";
	}

	// 执行项目构建
	@RequestMapping(value = "/labor/build", method = RequestMethod.POST)
	@ResponseBody
	public GenRsp build(GenInfo genInfo) throws Exception
	{
		System.out.println(genInfo);

		synchronized (locker)
		{
			Generator.execute(UserInputParamters.genInputArgs(
					PATH, 
					genInfo.getProjectName(), 
					genInfo.getHost(), 
					genInfo.getPort(),
					genInfo.getUsername(),
					genInfo.getPassword(),
					genInfo.getSchema(),
					STRATEGY,
					genInfo.getPackageName()));
		}
		ZipUtil.ZipMultiFile(PATH + File.separator + genInfo.getProjectName(),
				PATH + File.separator + genInfo.getProjectName());
		return new GenRsp();
	}

	// 下载生成项目的zip文件
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(@RequestParam String fileName, HttpServletResponse rsp)
	{
		String dir = PATH + File.separator + fileName;

		System.out.println(fileName);

		DownloadUtil.downloadLocalFile(dir, fileName, rsp);
	}
}
