package com.fzrj.architect.labor.utils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fzrj.architect.labor.generate.strategy.AbstractGeneratorStrategy;
import com.fzrj.architect.labor.generate.strategy.GeneratorStrategy;
import com.fzrj.architect.labor.parameter.EnableSupportUserInputPatamter;

public abstract class ClassUtil
{
	static Logger logger = LoggerFactory.getLogger(ClassUtil.class);

	public static List<Class<?>> getClasses(Class<?> cls)
	{
		String pk = cls.getPackage().getName();
		String path = pk.replace('.', '/');
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource(path);
		try
		{
			return getClasses(new File(url.getFile()), pk);
		}
		catch (ClassNotFoundException e)
		{
			logger.error("类型查找异常", e);
		}
		return new ArrayList<>();
	}

	public static List<Class<?>> getAllAssignedClass(Class<?> cls)
	{
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (Class<?> c : getClasses(cls))
		{
			if (cls.isAssignableFrom(c) && !cls.equals(c))
			{
				classes.add(c);
			}
		}
		return classes;
	}

	private static List<Class<?>> getClasses(File dir, String pk) throws ClassNotFoundException
	{
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if (!dir.exists())
		{
			return classes;
		}
		for (File f : dir.listFiles())
		{
			if (f.isDirectory())
			{
				classes.addAll(getClasses(f, pk + "." + f.getName()));
			}
			String name = f.getName();
			if (name.endsWith(".class"))
			{
				classes.add(Class.forName(pk + "." + name.substring(0, name.length() - 6)));
			}
		}
		return classes;
	}

	public static void main(String[] args) throws IllegalAccessException, InstantiationException
	{
		List<Class<?>> l = getAllAssignedClass(AbstractGeneratorStrategy.class);
		for (Class<?> c : l)
		{
			EnableSupportUserInputPatamter g = (EnableSupportUserInputPatamter) c.newInstance();
			System.out.println(((GeneratorStrategy) g));
		}
	}
}
