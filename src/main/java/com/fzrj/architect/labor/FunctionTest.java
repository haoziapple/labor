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

	// 比指定整数小的最大的2^N值
	public static int highestOneBit(int i)
	{
		i |= (i >> 1);
		i |= (i >> 2);
		i |= (i >> 4);
		i |= (i >> 8);
		i |= (i >> 16);
		return i - (i >>> 1);
	}

	public static void testInterrupt()
	{
		Thread t = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				while (true)
				{
					try
					{
						Thread.sleep(5000L);
						System.out.println("run once");
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		t.start();

		try
		{
			Thread.sleep(11000L);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		t.interrupt();
	}

	public static void doSomethingWhichThrowsException()
	{
		try
		{
			throw new RuntimeException("try block exception");
		}
		catch (Exception e)
		{
			System.out.println("catch exception");
			throw new RuntimeException("catch block exception");
		}
		finally
		{
			for (int i = 0; i < 10; i++)
			{
				if (3 == i)
				{
					break;
				}
			}
			return;
		}
	}
	
	public static void testString()
	{
		String t = new String("^01|0102\\");
		System.out.println(t);
	}

	public static void main(String[] args)
	{
		// 测试拼音工具类
		// System.out.println(PinYinUtil.getFullSpell("王昊"));
		// System.out.println(PinYinUtil.getFirstSpell("王昊"));

		// 测试无符号右移
		// System.out.println(29 >>> 1);

		// 测试finally块中抛出异常或return
		// doSomethingWhichThrowsException();
		// System.out.println("ok");

		// testInterrupt();

		// String newString = String.format("%04d", 5);
		// System.out.println(newString = newString + 1);
		
		testString();
	}
}
