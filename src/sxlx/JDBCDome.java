package sxlx;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class JDBCDome {
    @SuppressWarnings("unused")
	private void textConnection() {
    	try {
    		//��������
    		Class.forName("com.mysql.jdbc.Driver");
    		//�������ݿ������ַ���
    		String dbURL = "jdbc:mysql://lovalhost:3306/text";
    		//�������ݿ�����
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