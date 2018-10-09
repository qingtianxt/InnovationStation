package sist.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbBao {
	private static final String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	private static final String url = "jdbc:sqlserver://192.168.62.40:1433;DatabaseName=HBCXYZ";
	private static final String url = "jdbc:sqlserver://127.0.0.1;DatabaseName=HBCXYZ";
	private static final String username = "sa";
//	private static final String password = "qby*%*!1713";
//	private static final String password = "112971";
	private static final String password = "123456";
	private static Connection conn = null;
	private Statement sm = null;
	private ResultSet rs = null;

	// 初始化
	public DbBao() {
		try {
			Class.forName(dbDriver).newInstance();
			this.createConnection();
		} catch (Exception e) {
			System.out.println("数据库驱动加载失败" + e.getMessage());
		}
	}

	// 创建链接
	public boolean createConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("db---database connect error!");
		}
		return true;
	}

	// 返回connection对象
	public static Connection  getConnction() {
		return conn;
	}

	// 执行sql语句
	// return 结果集
	public ResultSet executeQuery(String sql) {
		if (conn == null) {
			this.createConnection();
		}
		try { 
			sm= getConnction().createStatement();
			rs = sm.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	// 执行sql语句
	// return 是否执行成功
	public boolean executeUpdate(String sql) {
		boolean flag = false;
		if (conn == null) {
			createConnection();
		}
		try {
			sm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			int count=sm.executeUpdate(sql);
			if(count>0)
			{
				flag=true;
			}
			// System.out.println("db---" + String.valueOf(count));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return flag;
		}
		return flag;
	}

	public void closeAll() {
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("db---failed to close ResultSet");
			}
		}
		if (sm != null) {
			try {
				sm.close();
			} catch (SQLException SqlE) {
				SqlE.printStackTrace();
				System.out.print("db---failed to close Statement");
			}

		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("db---failed to close connection!");
			}

		}
	}

	public void CloseDb()
	{
	    // TODO Auto-generated method stub
	    try{
		if(sm!=null){
			sm.close();
		}
		conn.close();
	}
	catch(SQLException SqlE){
		SqlE.printStackTrace();
		System.out.print("error");
	}
	}
}
