package com.fzrj.architect.labor;

/**
 * @className:com.fzrj.architect.labor.GenRsp
 * @description:生成请求返回
 * @version:v1.0.0 
 * @date:2017年6月30日 上午9:04:55
 * @author:WangHao
 */
public class GenRsp
{
	private int code = 1;

	private String msg = "success";

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	@Override
	public String toString()
	{
		return "GenRsp [code=" + code + ", msg=" + msg + "]";
	}
}
