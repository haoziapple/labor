package com.fzrj.architect.labor.generate.strategy.impl.ssm;

import com.fzrj.architect.labor.generate.strategy.AbstractGeneratorStrategy;
import com.fzrj.architect.labor.generate.strategy.impl.support.GeneratorStrategyCategory;

/**
 * @className:com.fzrj.architect.labor.generate.strategy.impl.ssm.SSMGeneratorStrategy
 * @description:Spring+SpringMVC+MyBatis生成策略(默认策略)
 * @version:v1.0.0 
 * @date:2017年6月23日 上午9:41:24
 * @author:WangHao
 */
public class SSMGeneratorStrategy extends AbstractGeneratorStrategy
{

	@Override
	public String getSpecifiedStr()
	{
		 return GeneratorStrategyCategory.SSM.value;
	}

	@Override
	protected boolean ignoreDefaultDBCode()
	{
		return false;
	}

	@Override
	protected boolean ignoreDefaultApplicationCode()
	{
		return false;
	}

	@Override
	protected boolean ignoreDefaultResourceFile()
	{
		return false;
	}

	@Override
	protected boolean ignoreDefaultAssemblyFile()
	{
		return false;
	}

	@Override
	protected boolean ignoreDefaultShellScriptFiles()
	{
		return false;
	}

	@Override
	protected boolean ignoreDefaultPomFile()
	{
		return false;
	}

	@Override
	protected boolean ignoreDefaultIndexControllerCode()
	{
		return false;
	}

	@Override
	protected boolean ignoreDefaultTemplateFile()
	{
		return false;
	}

}
