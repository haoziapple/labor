package com.fzrj.architect.labor.generate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fzrj.architect.labor.parameter.DBSourceParameters;
import com.fzrj.architect.labor.parameter.TargetProjectParameters;
import com.fzrj.architect.labor.parameter.TemplateParameters;
import com.fzrj.architect.labor.parameter.UserInputParamters;

public class Generator
{
	static Logger logger = LoggerFactory.getLogger(Generator.class);

	public static void execute(String[] args) throws Exception
	{
		// Step 1
		UserInputParamters.init(args);
		// Step 1.1
		DBSourceParameters.init();
		// Step 1.2
		TargetProjectParameters.init();
		// Step 1.3
		TemplateParameters.init();
		// Step 1.4
		// GeneratorStrategyParameters.init();
		// Step 2
		// GeneratorStrategyParameters.getGeneratorStrategy().execute();
		// Step 3
		printlnResult();
	}

	private static void printlnResult()
	{
		// logger.info("\nTarget project directory is : " +
		// TargetProjectParameters.getTargetProjectStorePath());
		// DirectoryUtil.readFile(TargetProjectParameters.getTargetProjectStorePath());
		logger.info("\n\n");
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		logger.info("@      Genarate Successfully !       @");
		logger.info("@   Thank you for using Labor 1.0.0  @");
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
}
