package com.fzrj.architect.labor.utils;

/**
 * @className:com.fzrj.architect.labor.utils.StringUtil
 * @description:字符串工具类
 * @version:v1.0.0 
 * @date:2017年6月30日 上午9:19:26
 * @author:WangHao
 */
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
			sb.append(StringUtil.upperFirst(st.toLowerCase()));
		}
		return sb.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(newTableName("drm_dept_staff_relate"));
	}
}
