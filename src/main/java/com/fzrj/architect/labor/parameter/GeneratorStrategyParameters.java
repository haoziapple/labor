package com.fzrj.architect.labor.parameter;

import com.fzrj.architect.labor.generate.strategy.GeneratorStrategy;
import com.fzrj.architect.labor.generate.strategy.impl.ssm.SSMGeneratorStrategy;
import com.fzrj.architect.labor.generate.strategy.impl.support.GeneratorStrategyFactory;

public abstract class GeneratorStrategyParameters
{
	/**
	 * default strategy
	 */
	final static GeneratorStrategy defaultGeneratorStrategy = new SSMGeneratorStrategy();

	/**
	 * customized strategy
	 */
	static GeneratorStrategy generatorStrategy;

	public static void init()
	{
		GeneratorStrategy generatorStrategy = GeneratorStrategyFactory
				.getInstance(UserInputParamters.getStrategy4genParam());
		if (generatorStrategy != null)
			setGeneratorStrategy(generatorStrategy);
	}

	public static GeneratorStrategy getGeneratorStrategy()
	{
		if (generatorStrategy == null)
			return defaultGeneratorStrategy;
		return generatorStrategy;
	}

	public static void setGeneratorStrategy(GeneratorStrategy generatorStrategy)
	{
		GeneratorStrategyParameters.generatorStrategy = generatorStrategy;
	}
}
