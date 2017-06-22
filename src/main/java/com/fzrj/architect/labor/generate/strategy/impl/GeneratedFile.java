package com.fzrj.architect.labor.generate.strategy.impl;

public class GeneratedFile implements EnableGeneratedFile
{
	private String templateFileRelativeDir;

	private String templateFileName;

	private String targetFileAbsoluteBaseDir;

	private String targetFileRelativeDir;

	private String targetFileName;

	public GeneratedFile(String templateFileRelativeDir, String templateFileName, String targetFileAbsoluteBaseDir,
			String targetFileRelativeDir, String targetFileName)
	{
		this.templateFileRelativeDir = templateFileRelativeDir;
		this.templateFileName = templateFileName;
		this.targetFileAbsoluteBaseDir = targetFileAbsoluteBaseDir;
		this.targetFileRelativeDir = targetFileRelativeDir;
		this.targetFileName = targetFileName;
	}

	@Override
	public String getTargetFileName()
	{
		return targetFileName;
	}

	public void setTargetFileName(String targetFileName)
	{
		this.targetFileName = targetFileName;
	}

	@Override
	public String getTargetFileRelativeDir()
	{
		return targetFileRelativeDir;
	}

	public void setTargetFileRelativeDir(String targetFileRelativeDir)
	{
		this.targetFileRelativeDir = targetFileRelativeDir;
	}

	@Override
	public String getTemplateFileRelativeDir()
	{
		return templateFileRelativeDir;
	}

	public void setTemplateFileRelativeDir(String templateFileRelativeDir)
	{
		this.templateFileRelativeDir = templateFileRelativeDir;
	}

	@Override
	public String getTemplateFileName()
	{
		return templateFileName;
	}

	@Override
	public String getOriginalModelName(String originalModelName)
	{
		return originalModelName;
	}

	public void setTemplateFileName(String templateFileName)
	{
		this.templateFileName = templateFileName;
	}

	public String getTargetFileAbsoluteBaseDir()
	{
		return targetFileAbsoluteBaseDir;
	}

	public void setTargetFileAbsoluteBaseDir(String targetFileAbsoluteBaseDir)
	{
		this.targetFileAbsoluteBaseDir = targetFileAbsoluteBaseDir;
	}
}
