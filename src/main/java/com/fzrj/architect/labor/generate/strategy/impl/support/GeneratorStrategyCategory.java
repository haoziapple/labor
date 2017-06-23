package com.fzrj.architect.labor.generate.strategy.impl.support;

/**
 * @className:com.fzrj.architect.labor.generate.strategy.impl.support.GeneratorStrategyCategory
 * @description:生成策略
 * @version:v1.0.0
 * @date:2017年6月23日 上午9:33:51
 * @author:WangHao
 */
public enum GeneratorStrategyCategory
{
	// Spring+SpringMVC+MyBatis
	SSM("ssm"),

	// Spring+SpringMVC+Jooq
	SSJ("ssj"),

	// Spring+SpringMVC+SpringJdbcTemplate
	SSS("sss"),

	SSD("ssd"),

	// JFinal Framework
	JFINAL("jfinal"),

	// Play Framework
	PLAY("play"),;

	public String value;

	private GeneratorStrategyCategory(String value)
	{
		this.value = value;
	}
}
