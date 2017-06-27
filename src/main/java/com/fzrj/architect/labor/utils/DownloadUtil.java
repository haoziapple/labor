package com.fzrj.architect.labor.utils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DownloadUtil
{
	private static final Logger log = LoggerFactory.getLogger(DownloadUtil.class);

	/**
	 * @Description:下载本地文件
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2017年6月27日 下午3:23:24
	 */
	public static void downloadLocalFile(String dir, String fileName, HttpServletResponse rsp)
	{
		// 设置下载的类型 告诉浏览器 需要以下载的方式操作
		rsp.setContentType("application/force=download");
		// 下载头设置
		try
		{
			rsp.setHeader("content-disposition",
					"attachment;fileName=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
		}
		catch (UnsupportedEncodingException e1)
		{
			log.error("文件名编码异常", e1);
		}

		File file = new File(dir);
		// 创建输入流对象
		java.io.FileInputStream fileInputStream = null;
		OutputStream fout = null;
		try
		{
			fileInputStream = new java.io.FileInputStream(file);
			fout = rsp.getOutputStream();

			byte[] buff = new byte[100];
			while (fileInputStream.read(buff) != -1)
			{
				fout.write(buff);
			}
		}
		catch (Exception e)
		{
			log.error("下载本地文件异常", e);
		}
		finally
		{
			try
			{
				fileInputStream.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			try
			{
				fout.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
