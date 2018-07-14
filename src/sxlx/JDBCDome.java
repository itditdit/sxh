package sxlx;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class JDBCDome {
    @SuppressWarnings("unused")
	private void textConnection() {
    	try {
    		//加载驱动
    		Class.forName("com.mysql.jdbc.Driver");
    		//创建数据库连接字符串
    		String dbURL = "jdbc:mysql://lovalhost:3306/text";
    		//建立数据库连接
    		try {
    			Connection connection = (Connection)DriverManager.getConnection(dbURL, "root", "root");
    			}
    		catch(SQLException e) {
    		e.printStackTrace();	
    		}
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
}