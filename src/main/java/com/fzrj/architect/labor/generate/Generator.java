package com.fzrj.architect.labor.generate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fzrj.architect.labor.parameter.DBSourceParameters;
import com.fzrj.architect.labor.parameter.GeneratorStrategyParameters;
import com.fzrj.architect.labor.parameter.TargetProjectParameters;
import com.fzrj.architect.labor.parameter.TemplateParameters;
import com.fzrj.architect.labor.parameter.UserInputParamters;
import com.fzrj.architect.labor.utils.DirectoryUtil;

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
		GeneratorStrategyParameters.init();
		// Step 2
		GeneratorStrategyParameters.getGeneratorStrategy().execute();
		// Step 3
		printlnResult();
	}

	private static void printlnResult()
	{
		logger.info("\nTarget project directory is : " + TargetProjectParameters.getTargetProjectStorePath());
		DirectoryUtil.readFile(TargetProjectParameters.getTargetProjectStorePath());
		logger.info("\n\n");
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		logger.info("@      Genarate Successfully !       @");
		logger.info("@   Thank you for using Labor 1.0.0  @");
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}

	public static void main(String[] args) throws Exception
	{
		if (args == null || args.length == 0)
		{
			// setting demo paramters
			String path = "F:\\myLaborProject";
			String projectName = "test1";
			// bdm26934148.my3w.com
			// 10.108.26.11
			String dbHost = "bdm26934148.my3w.com";
			String dbPort = "3306";
			// bdm26934148
			// fz_aquatic_zf
			String dbUser = "bdm26934148";
			// haozi1009
			// fuzhong2015
			String dbPassword = "haozi1009";
			// bdm26934148_db
			// fz_aquatic_zf
			String dbName = "bdm26934148_db";
			String strategy = "ssm";
			String packageName = "com.labor.test";
			// generating
			Generator.execute(UserInputParamters.genInputArgs(path, projectName, dbHost, dbPort, dbUser, dbPassword,
					dbName, strategy, packageName));
		}
		else
		{
			// generating
			Generator.execute(args);
		}
	}
}
