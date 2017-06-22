package com.fzrj.architect.labor.utils;

import java.io.File;

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
