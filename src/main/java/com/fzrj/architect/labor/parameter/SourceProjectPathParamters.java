package com.fzrj.architect.labor.parameter;

import java.io.File;

import com.fzrj.architect.labor.utils.DirectoryUtil;

public abstract class SourceProjectPathParamters
{
	/**
	*
	*/
	static String sourceProjectClassPath = (System.getProperty("user.dir") + "/target/classes/").replace("/",
			File.separator);

	static String sourceProjectStaticFilePath = (sourceProjectClassPath + "template/common/src/main/resources/static/")
			.replace("/", File.separator);

	public static String getSourceProjectClassPath()
	{
		return sourceProjectClassPath;
	}

	public static void setSourceProjectClassPath(String sourceProjectClassPath)
	{
		SourceProjectPathParamters.sourceProjectClassPath = sourceProjectClassPath;
	}

	public static String getSourceProjectStaticFilePath()
	{
		return sourceProjectStaticFilePath;
	}

	public static void setSourceProjectStaticFilePath(String sourceProjectStaticFilePath)
	{
		SourceProjectPathParamters.sourceProjectStaticFilePath = sourceProjectStaticFilePath;
	}

	public static void main(String[] args)
	{
		DirectoryUtil.readFile(sourceProjectStaticFilePath);
	}
}
