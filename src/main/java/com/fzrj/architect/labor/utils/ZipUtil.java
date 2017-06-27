package com.fzrj.architect.labor.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

public class ZipUtil
{
	private static final Logger log = LoggerFactory.getLogger(ZipUtil.class);

	public static final String ZIP = ".zip";

	/** 一次性压缩多个文件，文件存放至一个文件夹中 */
	public static void ZipMultiFile(String filepath, String zippath)
	{
		try
		{
			File file = new File(filepath);// 要被压缩的文件夹
			File zipFile = new File(zippath + ZIP);
			ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));

			if (file.isDirectory() && zipFile.isFile())
			{
				zipFiles(file, zipOut, zipFile.getName().substring(0, zipFile.getName().length() - ZIP.length()),
						File.separator);
			}
			else
			{
				log.error("文件路径信息错误");
			}

			zipOut.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void zipFiles(File dir, ZipOutputStream zipOut, String rootPath, String relativePath)
	{
		try
		{
			InputStream input = null;
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; ++i)
			{
				if (files[i].isFile())
				{
					input = new FileInputStream(files[i]);
					zipOut.putNextEntry(new ZipEntry(rootPath + relativePath + files[i].getName()));
					int temp = 0;
					while ((temp = input.read()) != -1)
					{
						zipOut.write(temp);
					}
					input.close();
				}
				else
				{
					zipFiles(files[i], zipOut, rootPath, relativePath + files[i].getName() + File.separator);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		ZipMultiFile("F:\\myLaborProject\\test1", "F:\\myLaborProject\\test1");
	}
}
