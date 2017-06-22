package com.fzrj.architect.labor.generate.strategy;

/**
 * @className:com.fzrj.architect.labor.generate.strategy.GeneratorStrategy
 * @description:生成策略
 * @version:v1.0.0
 * @date:2017年6月22日 下午4:00:46
 * @author:WangHao
 */
public interface GeneratorStrategy
{
	boolean isNeedScript = true;

	String encoding = "utf-8";

	void execute();
}
