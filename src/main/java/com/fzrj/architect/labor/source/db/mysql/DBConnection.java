package com.fzrj.architect.labor.source.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @className:com.fzrj.architect.labor.source.db.mysql.DBConnection
 * @description:数据库连接
 * @version:v1.0.0 
 * @date:2017年6月22日 下午4:58:51
 * @author:WangHao
 */
public class DBConnection
{
	private static Connection conn;

	static String host = "127.0.0.1";
	static String port = "3306";
	static String schema = "test";
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://" + host + ":" + port + "/" + schema;
	static String user;
	static String password;

	static boolean inited = false;

	private static String buildDBUrl()
	{
		return "jdbc:mysql://" + host + ":" + port + "/" + schema;
	}

	public static void init(String host, String port, String schema, String user, String password)
	{
		DBConnection.host = host;
		DBConnection.port = port;
		DBConnection.schema = schema;
		DBConnection.user = user;
		DBConnection.password = password;
		DBConnection.url = buildDBUrl();
		DBConnection.inited = true;
	}

	public static Connection getInstance()
	{
		if (!inited)
			throw new NullPointerException("please inti it beforce using getInstance ... ");
		try
		{
			if (conn == null || conn.isClosed())
			{
				try
				{
					Class.forName(DBConnection.driver);
					try
					{
						conn = DriverManager.getConnection(DBConnection.url, DBConnection.user, DBConnection.password);
					}
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
