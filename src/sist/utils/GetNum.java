package sist.utils;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GetNum {
	String value1;
	String value2;
	String value3;
	String biao;

	public GetNum() {

	};

	public GetNum(String s1, String s2, String s3, String b) {
		value1 = s1;
		value2 = s2;
		value3 = s3;
		biao = b;
	};

	public String Getvalue() {

		 if (value3 != null&&!(value3.equals(""))&&!(value3.equals("null"))) {
		     if (value1.equals("«Î—°‘Ò")) {
			    return null;
			} 
			return select(value3);
		} else if (value2 != null&&!(value2.equals(""))&&!(value2.equals("null"))) {
		    if (value1.equals("«Î—°‘Ò")) {
			    return null;
			} 
			return select(value2);
		} else if (value1 !=null&&!(value1.equals(""))&&!(value1.equals("null"))) {
		    if (value1.equals("«Î—°‘Ò")) {
			    return null;
			} 
			return select(value1);
		} else {
			return null;
		}
	}

	public String select(String s) {
		String value = "";
		String sql = "";
		biao="";
		if (biao.equals("T_XKFL")) {
			sql = "select * from T_XKFL where Specialty='" + s + "'";
		} else {
			sql = "select * from GMJJ where Title='" + s + "'";
		}
		 System.out.print(sql);
		DbBao db = new DbBao();
		ResultSet rs = db.executeQuery(sql);
		try {
			rs.next();
			value = rs.getString(1).toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			db.closeAll();
		}
		return value;
	}
	
	
	
}

