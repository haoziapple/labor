package com.fzrj.architect.labor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import com.fzrj.architect.labor.utils.PinYinUtil;

public class FunctionTest
{
	// 获取系统env
	public static void getEnv()
	{
		System.out.println(System.getenv());
	}

	// 获取系统prop
	public static void getProps()
	{
		Properties props = System.getProperties();
		Iterator<Entry<Object, Object>> it = props.entrySet().iterator();
		while (it.hasNext())
		{
			Entry<Object, Object> ent = it.next();
			System.out.println(ent.getKey() + ":" + ent.getValue());
		}
	}

	// 获取工作目录
	public static void getWorkDir()
	{
		System.out.println(System.getProperty("user.dir"));
	}

	public static void dateFormat()
	{
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		String str = df.format(date);
		System.out.println(str);
	}

	public static void main(String[] args)
	{
		System.out.println(PinYinUtil.getFullSpell("王昊"));
		System.out.println(PinYinUtil.getFirstSpell("王昊"));
	}
}
