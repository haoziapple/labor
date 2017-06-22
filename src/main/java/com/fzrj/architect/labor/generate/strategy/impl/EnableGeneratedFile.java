package com.fzrj.architect.labor.generate.strategy.impl;

public interface EnableGeneratedFile
{
	/**
	 * Target File Name (e.g : pom.xml、mvn.sh、${model}Service.java、DB.java,
	 * especially, "${model}" will be replaced by actual model name.
	 * 
	 * @return
	 */
	String getTargetFileName();

	String getTargetFileAbsoluteBaseDir();

	String getTargetFileRelativeDir();

	String getTemplateFileRelativeDir();

	String getTemplateFileName();

	String getOriginalModelName(String originalModelName);
}
