package com.fzrj.architect.labor.generate.strategy.impl.support;

import java.util.List;

import com.fzrj.architect.labor.generate.strategy.GeneratorStrategy;
import com.fzrj.architect.labor.parameter.EnableSupportUserInputPatamter;
import com.fzrj.architect.labor.utils.ClassUtil;
import com.fzrj.architect.labor.utils.StringUtil;

public abstract class GeneratorStrategyFactory
{
	public static GeneratorStrategy getInstance(String s)
	{

		if (StringUtil.isEmpty(s))
			return null;

		List<Class<?>> list = null;//ClassUtil.getAllAssignedClass(AbstractGeneratorStrategy.class);
		for (Class<?> ec : list)
		{
			try
			{
				EnableSupportUserInputPatamter esu = (EnableSupportUserInputPatamter) ec.newInstance();
				if (s.equals(esu.getSpecifiedStr()))
				{
					return (GeneratorStrategy) esu;
				}
			}
			catch (InstantiationException e)
			{
				e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
}
