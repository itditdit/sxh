package sxlx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Book {
	private static Connection getConnection() {
    	try {
    		//加载驱动
    		Class.forName("com.mysql.jdbc.Driver");
    		//创建数据库连接字符串
    		String dbURL = "jdbc:mysql://localhost:3306/sjk";
    		//建立数据库连接
    		try {
    			Connection connection = DriverManager.getConnection(dbURL, "root", "root");
    			return connection;
    			}
    		catch(SQLException e) {
    		e.printStackTrace();	
    		}
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
		return null;
    }
	//封装释放数据库连接操作   
    private void close(Connection connection,Statement statement,ResultSet resultSet) {
    	try {
			if(resultSet  != null) {
				resultSet.close();
			}
			if(statement  != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
    	}catch(SQLException e) {
				e.printStackTrace();	
				}
	}
    //添加数据
    private void InsertData(String name,String publishers,String author) {
    	Connection connection=null;
    	Statement statement =null;
    	
    	try {
    	connection=getConnection();
    	  //2.构建添加数据的SQL语句
    	  String sql = "insert into book(book_name,book_publishers,book_author)"+ "values('"+name +"','"+publishers+"','"+author +"')";
    	  //3.执行sql语句
    	  statement = connection.createStatement();
    	  int rows = statement.executeUpdate(sql);
    	  System.out.println("所影响的行数为：" + rows);
    	}
    	  //4.得到执行后的结果，确定是否添加成功
    	  catch(SQLException e) {
    		e.printStackTrace();	
    		}finally {
				this.close(connection,statement,null);
			}
    		}
  //修改数据
    private void UpdateData(int id,String name,String publishers,String author) {
    	Connection connection = null;
    	Statement statement = null;
    	try {
    	connection = getConnection();
    	//2.创建sql语句
    	String sql ="update book set"+" book_name='"+name+"',book_publishers='"+publishers+"',book_author='"+author+"'" + " where id ="+id+"";
    	//3.执行update语句
    	statement = connection.createStatement();
    	//4.得到执行结果确定是否成功
    	int rows =statement.executeUpdate(sql);
		System.out.println("更新结果为" + (rows>0));
		}
		 catch(SQLException e) {
				e.printStackTrace();	
				}
    	finally {
			this.close(connection,statement,null);
		}
    	}
    //删除数据
    private void DeleteData(int id) {
    	Connection connection = null;
    	Statement statement = null;
    	try {
    		connection = getConnection();
    		String sql ="Delete from book where id="+id+"";
    	    statement = (Statement) connection.createStatement();
    		int rows =statement.executeUpdate(sql);
    		System.out.println("有" + rows +"行被删除成功！");
    	}
       catch(SQLException e) {
		e.printStackTrace();	
		}
    	finally {
			this.close(connection,statement,null);
		}
}
    //查询所有数据
    private void findAllData() {
    	Connection connection = null;
    	Statement statement = null;
    	ResultSet resultSet = null;
    	//1.获取数据库连接
        connection = getConnection();
    	//2.构建查询sql语句
    	String sql = "select  * from book";
    	try {
    		//3.执行sql 语句，并获得结果集
    		statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
    		//4.遍结果集，输出每条记录的信息
    		StringBuffer  buffer= new StringBuffer();
			buffer.append("----------------------------------------------------------"+System.lineSeparator());
			buffer.append("id\t\tname\t\tpublishers\t\t\tauthor\t\t\ttime"+System.lineSeparator());
			buffer.append("----------------------------------------------------------"+System.lineSeparator());
    		while(resultSet.next()){
    		    int id = resultSet.getInt("id");
    			String name = resultSet.getString("book_name");
    			String publishers = resultSet.getString("book_publishers");
    			String author= resultSet.getString("book_author");
    			String time = resultSet.getString("create_time");
    			buffer.append(id +"\t\t|"+name+"|\t\t"+publishers+"\t\t|"+author+"|\t\t"+time+"|\t"+System.lineSeparator());
    		}
    		System.out.println(buffer.toString());
       }catch (SQLException e) {
    		e.printStackTrace();
    	}
    	finally {
			this.close(connection,statement,resultSet);
		}
    	}
    //按关键字对书籍名，出版商，作者进行模糊搜索
	private void findBookDataLikeKey(String keyWord) {
		Connection connection = null;
    	Statement statement = null;
    	ResultSet resultSet = null;
	  	//1.获取数据库连接
         connection = getConnection();
    	//2.构建查询sql语句
    	String sql = "select *from book where book_name like '%"+keyWord+"%' or book_publishers like '%"+keyWord+"%' or book_author like '%"+keyWord+"%'";
    	try {
    		//3.执行sql 语句，并获得结果集
    	    statement = connection.createStatement();
    		resultSet = statement.executeQuery(sql);
    		//4.遍结果集，输出每条记录的信息
    		StringBuffer  buffer= new StringBuffer();
			buffer.append("----------------------------------------------------------"+System.lineSeparator());
			buffer.append("id\t\tname\t\tpublishers\t\t\tauthor\t\t\ttime\t\t"+System.lineSeparator());
			buffer.append("----------------------------------------------------------"+System.lineSeparator());
    		while(resultSet.next()){
    		   //int id = resultSet.getInt("id");
    			String name = resultSet.getString("book_name");
    			String publishers = resultSet.getString("book_publishers");
    			String author= resultSet.getString("book_author");
    			//String time = resultSet.getString("create_time");
    			buffer.append("\t\t|"+name+"|\t\t"+publishers+"\t\t|"+author+"|\t\t"+System.lineSeparator());
    		}
    		System.out.println(buffer.toString());
       }catch (SQLException e) {
    		e.printStackTrace();
    	}
    	finally {
			this.close(connection,statement,resultSet);
		}
    }
   //程序主入口
        public static void main(String arg []) {
	    Book book = new Book ();
	    Scanner scanner = new Scanner(System.in);
	    while(true) {
	    System.out.println("=================================================================================");
	    System.out.println("|                                欢迎使用图书管理系统                                                  |");
	    System.out.println("|1.添加数据        2.修改数据       3.删除数据      4.查看所有书籍     5.模糊搜索      6.退出系统  ");
	    System.out.println("=================================================================================");
	    System.out.println("请选择你要进行的操作……");
	    int select =0;// 接受用户的选项
	    select=scanner.nextInt();
	    while(select < 1 ||select >6) {
		System.out .println("选择的操作不能识别，请重新选择:");
		select=scanner.nextInt();
	}
	    String value =null;
	
	 if(select == 1) {
	     System.out.println("请输入要添加的书籍名，出版商，书籍作者");
         value = scanner.next();
	     String [] values =value.split(",");
	     book.InsertData(values[0],values[1],values[2]);
	 }
	 else if(select ==2) {//修改数据
		System.out.println("请输入要修改的书籍名，出版商，作者和id，系统将根据输入id进行修改");
		value = scanner.next();
		String [] values =value.split(",");
		book.UpdateData(Integer.parseInt(values[0]),values[1],values[2],values[3]);
    }
	else if(select ==3) {//删除数据
		System.out.println("请输入要删除的id");
		int id;
		id = scanner.nextInt();
		book.DeleteData(id);
    }
	else if(select ==4) {//查看所有书籍
		book.findAllData();
    }
	else if(select ==5) {//查找书籍
		System.out.println("请输入要模糊查找的KeyWord");
		value=scanner.next();
		book.findBookDataLikeKey(value);
	}
	else if(select ==6) {//退出系统
	    System.exit(-1);
    }
	}
	}
}

