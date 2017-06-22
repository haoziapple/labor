package com.fzrj.architect.labor.parameter;

import com.fzrj.architect.labor.generate.TemplateParameterInfo;

/**
 * @className:com.fzrj.architect.labor.parameter.TemplateParameters
 * @description:模板参数信息
 * @version:v1.0.0
 * @date:2017年6月22日 下午3:49:23
 * @author:WangHao
 */
public abstract class TemplateParameters
{
	private static TemplateParameterInfo templateParameterInfo = new TemplateParameterInfo();
	private static boolean inited = false;

	public static void init()
	{
		// Assemble DATA
		templateParameterInfo.setPackageName(TargetProjectParameters.getTargetPackage());
		templateParameterInfo.setProjectName(TargetProjectParameters.getTargetsName());
		templateParameterInfo.setSourceDbHost(DBSourceParameters.getSourceDbHost());
		templateParameterInfo.setSourceDbPassword(DBSourceParameters.getSourceDbPassword());
		templateParameterInfo.setSourceDbPort(DBSourceParameters.getSourceDbPort());
		templateParameterInfo.setSourceDbSchema(DBSourceParameters.getSourceDbSchema());
		templateParameterInfo.setSourceDbUsername(DBSourceParameters.getSourceDbUsername());
		inited = true;
	}

	public static TemplateParameterInfo getTemplateParameterInfo()
	{
		return templateParameterInfo;
	}
}
