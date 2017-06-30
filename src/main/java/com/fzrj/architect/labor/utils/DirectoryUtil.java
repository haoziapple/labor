package com.fzrj.architect.labor.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.fzrj.architect.labor.Application;
import com.google.common.io.CharStreams;

/**
 * @className:com.fzrj.architect.labor.utils.DirectoryUtil
 * @description:文件夹工具类
 * @version:v1.0.0 
 * @date:2017年6月30日 上午9:32:11
 * @author:WangHao
 */
public abstract class DirectoryUtil
{
	private static int fileLevel;

	private static String createPrintStr(String pathname, int level)
	{
		String printStr = "";
		for (int i = 0; i < level; i++)
		{
			printStr = printStr + "│   ";
		}
		printStr = printStr + "├── " + pathname;
		return printStr;
	}

	private static void printDir(String dirPath)
	{
		String[] dirNameList = dirPath.split("\\\\");
		fileLevel = dirNameList.length;
		for (int i = 0; i < dirNameList.length; i++)
		{
			System.out.println(createPrintStr(dirNameList[i], i));
		}
	}
	
	public static void main(String[] args)
	{
		printDir("C:\\Users\\Administrator\\Desktop\\51服务solr备份");
	}

	public static void readFile(String dirPath)
	{

		Set<String> ignoreDirNamesSet = new HashSet<>();
		ignoreDirNamesSet.add(".idea");
		ignoreDirNamesSet.add("target");
		File file = new File(dirPath);
		File[] list = file.listFiles();
		for (int i = 0; i < list.length; i++)
		{
			if (list[i].isDirectory())
			{

				if (ignoreDirNamesSet.contains(list[i].getName()))
				{
					continue;
				}

				System.out.println(createPrintStr(list[i].getName(), fileLevel));
				fileLevel++;
				readFile(list[i].getPath());
				fileLevel--;
			}
			else
			{
				if (list[i].getName().trim().startsWith("."))
				{
					continue;
				}
				System.out.println(createPrintStr(list[i].getName(), fileLevel));
			}
		}
	}

	public static String readFile2String(String dirPath)
	{

		StringBuffer sb = new StringBuffer();
		Set<String> ignoreDirNamesSet = new HashSet<>();
		ignoreDirNamesSet.add(".idea");
		ignoreDirNamesSet.add("target");

		File file = new File(dirPath);
		File[] list = file.listFiles();
		for (int i = 0; i < list.length; i++)
		{
			if (list[i].isDirectory())
			{

				if (ignoreDirNamesSet.contains(list[i].getName()))
				{
					continue;
				}

				sb.append(createPrintStr(list[i].getName(), fileLevel) + "\n");
				fileLevel++;
				sb.append(readFile2String(list[i].getPath()));
				fileLevel--;
			}
			else
			{
				sb.append(createPrintStr(list[i].getName(), fileLevel) + "\n");
			}
		}

		return sb.toString();
	}

	public static void copyFolder(File src, File dest, final Set<String> ignoreFileSuffixs)
	{

		CodeSource codeSource = Application.class.getProtectionDomain().getCodeSource();
		String location = codeSource.getLocation().getPath();

		if (location.endsWith(".jar"))
		{
			String relativeSrcPath = "template/common/pagetemplate/static/";
			if (src != null)
			{
				URL jar = codeSource.getLocation();
				ZipInputStream zip = null;
				try
				{
					zip = new ZipInputStream(jar.openStream());
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				while (true)
				{
					ZipEntry zipEntry = null;
					try
					{
						zipEntry = zip.getNextEntry();
					}
					catch (IOException e1)
					{
						e1.printStackTrace();
					}
					if (zipEntry == null)
						break;
					String name = zipEntry.getName();
					if (name.startsWith(relativeSrcPath)
							&& (name.endsWith(".js") || name.endsWith(".css") || name.endsWith(".html")))
					{
						try
						{
							InputStream inputStream = Application.class.getClass()
									.getResourceAsStream(File.separator + name);
							String text = CharStreams.toString(new InputStreamReader(inputStream, "UTF-8"));
							// System.out.println(text);
							String filePath = dest.getPath() + name.replace(relativeSrcPath, File.separator);
							File newFile = new File(filePath);
							if (!newFile.exists())
							{
								newFile.createNewFile();
							}

							FileOutputStream fos = new FileOutputStream(newFile);
							fos.write(text.getBytes());
							fos.flush();
							inputStream.close();
							fos.close();
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
					}
				}
			}
			return;
		}

		if (src.isDirectory())
		{
			if (!dest.exists())
			{
				FileUtil.mkdir(dest.getPath());
			}
			String files[] = src.list();
			for (String file : files)
			{

				boolean flag = false;
				for (String ignoreFileSuffix : ignoreFileSuffixs)
				{
					if (file.endsWith(ignoreFileSuffix))
					{
						flag = true;
						break;
					}
				}
				if (flag)
					continue;
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				copyFolder(srcFile, destFile, ignoreFileSuffixs);
			}
		}
		else
		{
			InputStream in = null;
			try
			{
				in = new FileInputStream(src);
				OutputStream out = new FileOutputStream(dest);

				byte[] buffer = new byte[1024];

				int length;

				while ((length = in.read(buffer)) > 0)
				{
					out.write(buffer, 0, length);
				}
				in.close();
				out.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}
	}

	public static ArrayList<File> getListFiles(Object obj)
	{
		File directory = null;
		if (obj instanceof File)
		{
			directory = (File) obj;
		}
		else
		{
			directory = new File(obj.toString());
		}
		ArrayList<File> files = new ArrayList<File>();
		if (directory.isFile())
		{
			files.add(directory);
			return files;
		}
		else if (directory.isDirectory())
		{
			File[] fileArr = directory.listFiles();
			for (int i = 0; i < fileArr.length; i++)
			{
				File fileOne = fileArr[i];
				files.addAll(getListFiles(fileOne));
			}
		}
		return files;
	}
}
