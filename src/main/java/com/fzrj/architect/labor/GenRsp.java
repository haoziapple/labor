package com.fzrj.architect.labor;

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
