package com.fzrj.architect.labor;

public class GenInfo
{
	private String host;

	private String port;

	private String username;

	private String password;

	private String schema;

	private String projectName;

	private String packageName;

	private String path;

	private String strategy;

	public String getHost()
	{
		return host;
	}

	public void setHost(String host)
	{
		this.host = host;
	}

	public String getPort()
	{
		return port;
	}

	public void setPort(String port)
	{
		this.port = port;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getSchema()
	{
		return schema;
	}

	public void setSchema(String schema)
	{
		this.schema = schema;
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public String getPackageName()
	{
		return packageName;
	}

	public void setPackageName(String packageName)
	{
		this.packageName = packageName;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getStrategy()
	{
		return strategy;
	}

	public void setStrategy(String strategy)
	{
		this.strategy = strategy;
	}

	@Override
	public String toString()
	{
		return "GenInfo [host=" + host + ", port=" + port + ", username=" + username + ", password=" + password
				+ ", schema=" + schema + ", projectName=" + projectName + ", packageName=" + packageName + ", path="
				+ path + ", strategy=" + strategy + "]";
	}
}
