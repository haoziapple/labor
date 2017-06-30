package com.fzrj.architect.labor.utils;

import java.io.File;

/**
 * @className:com.fzrj.architect.labor.utils.FileUtil
 * @description:文件工具类
 * @version:v1.0.0
 * @date:2017年6月30日 上午9:22:01
 * @author:WangHao
 */
public abstract class FileUtil
{
	public static void mkdir(String path)
	{
		File fd = null;
		try
		{
			fd = new File(path);
			if (!fd.exists())
			{
				fd.mkdirs();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			fd = null;
		}
	}

	public static boolean isExists(String filePath)
	{
		boolean result = false;
		File fd = null;
		try
		{
			fd = new File(filePath);
			if (fd.exists())
			{
				result = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			result = false;
		}
		finally
		{
			fd = null;
		}
		return result;

	}
}
