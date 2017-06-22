package com.fzrj.architect.labor.utils;

public abstract class StringUtil
{
	public static boolean isEmpty(String s)
	{
		return s == null || "".equals(s);
	}

	public static final String upperFirst(String s)
	{
		if (s == null)
			return "";
		int len = s.length();
		if (len <= 0)
			return "";
		StringBuffer sb = new StringBuffer();
		sb.append(s.substring(0, 1).toUpperCase());
		sb.append(s.substring(1, len));
		return sb.toString();
	}

	public static final String lowerFirst(String s)
	{
		int len = s.length();
		if (len <= 0)
			return "";
		StringBuffer sb = new StringBuffer();
		sb.append(s.substring(0, 1).toLowerCase());
		sb.append(s.substring(1, len));
		return sb.toString();
	}

	public static final String newTableName(String tableName)
	{
		String strS[] = tableName.split("_");
		StringBuilder sb = new StringBuilder("");
		for (String st : strS)
		{
			sb.append(StringUtil.upperFirst(st));
		}
		return sb.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(newTableName("drm_dept_staff_relate"));
	}
}
