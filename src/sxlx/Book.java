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
    		//��������
    		Class.forName("com.mysql.jdbc.Driver");
    		//�������ݿ������ַ���
    		String dbURL = "jdbc:mysql://localhost:3306/sjk";
    		//�������ݿ�����
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
	//��װ�ͷ����ݿ����Ӳ���   
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
    //�������
    private void InsertData(String name,String publishers,String author) {
    	Connection connection=null;
    	Statement statement =null;
    	
    	try {
    	connection=getConnection();
    	  //2.����������ݵ�SQL���
    	  String sql = "insert into book(book_name,book_publishers,book_author)"+ "values('"+name +"','"+publishers+"','"+author +"')";
    	  //3.ִ��sql���
    	  statement = connection.createStatement();
    	  int rows = statement.executeUpdate(sql);
    	  System.out.println("��Ӱ�������Ϊ��" + rows);
    	}
    	  //4.�õ�ִ�к�Ľ����ȷ���Ƿ���ӳɹ�
    	  catch(SQLException e) {
    		e.printStackTrace();	
    		}finally {
				this.close(connection,statement,null);
			}
    		}
  //�޸�����
    private void UpdateData(int id,String name,String publishers,String author) {
    	Connection connection = null;
    	Statement statement = null;
    	try {
    	connection = getConnection();
    	//2.����sql���
    	String sql ="update book set"+" book_name='"+name+"',book_publishers='"+publishers+"',book_author='"+author+"'" + " where id ="+id+"";
    	//3.ִ��update���
    	statement = connection.createStatement();
    	//4.�õ�ִ�н��ȷ���Ƿ�ɹ�
    	int rows =statement.executeUpdate(sql);
		System.out.println("���½��Ϊ" + (rows>0));
		}
		 catch(SQLException e) {
				e.printStackTrace();	
				}
    	finally {
			this.close(connection,statement,null);
		}
    	}
    //ɾ������
    private void DeleteData(int id) {
    	Connection connection = null;
    	Statement statement = null;
    	try {
    		connection = getConnection();
    		String sql ="Delete from book where id="+id+"";
    	    statement = (Statement) connection.createStatement();
    		int rows =statement.executeUpdate(sql);
    		System.out.println("��" + rows +"�б�ɾ���ɹ���");
    	}
       catch(SQLException e) {
		e.printStackTrace();	
		}
    	finally {
			this.close(connection,statement,null);
		}
}
    //��ѯ��������
    private void findAllData() {
    	Connection connection = null;
    	Statement statement = null;
    	ResultSet resultSet = null;
    	//1.��ȡ���ݿ�����
        connection = getConnection();
    	//2.������ѯsql���
    	String sql = "select  * from book";
    	try {
    		//3.ִ��sql ��䣬����ý����
    		statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
    		//4.�����������ÿ����¼����Ϣ
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
    //���ؼ��ֶ��鼮���������̣����߽���ģ������
	private void findBookDataLikeKey(String keyWord) {
		Connection connection = null;
    	Statement statement = null;
    	ResultSet resultSet = null;
	  	//1.��ȡ���ݿ�����
         connection = getConnection();
    	//2.������ѯsql���
    	String sql = "select *from book where book_name like '%"+keyWord+"%' or book_publishers like '%"+keyWord+"%' or book_author like '%"+keyWord+"%'";
    	try {
    		//3.ִ��sql ��䣬����ý����
    	    statement = connection.createStatement();
    		resultSet = statement.executeQuery(sql);
    		//4.�����������ÿ����¼����Ϣ
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
   //���������
        public static void main(String arg []) {
	    Book book = new Book ();
	    Scanner scanner = new Scanner(System.in);
	    while(true) {
	    System.out.println("=================================================================================");
	    System.out.println("|                                ��ӭʹ��ͼ�����ϵͳ                                                  |");
	    System.out.println("|1.�������        2.�޸�����       3.ɾ������      4.�鿴�����鼮     5.ģ������      6.�˳�ϵͳ  ");
	    System.out.println("=================================================================================");
	    System.out.println("��ѡ����Ҫ���еĲ�������");
	    int select =0;// �����û���ѡ��
	    select=scanner.nextInt();
	    while(select < 1 ||select >6) {
		System.out .println("ѡ��Ĳ�������ʶ��������ѡ��:");
		select=scanner.nextInt();
	}
	    String value =null;
	
	 if(select == 1) {
	     System.out.println("������Ҫ��ӵ��鼮���������̣��鼮����");
         value = scanner.next();
	     String [] values =value.split(",");
	     book.InsertData(values[0],values[1],values[2]);
	 }
	 else if(select ==2) {//�޸�����
		System.out.println("������Ҫ�޸ĵ��鼮���������̣����ߺ�id��ϵͳ����������id�����޸�");
		value = scanner.next();
		String [] values =value.split(",");
		book.UpdateData(Integer.parseInt(values[0]),values[1],values[2],values[3]);
    }
	else if(select ==3) {//ɾ������
		System.out.println("������Ҫɾ����id");
		int id;
		id = scanner.nextInt();
		book.DeleteData(id);
    }
	else if(select ==4) {//�鿴�����鼮
		book.findAllData();
    }
	else if(select ==5) {//�����鼮
		System.out.println("������Ҫģ�����ҵ�KeyWord");
		value=scanner.next();
		book.findBookDataLikeKey(value);
	}
	else if(select ==6) {//�˳�ϵͳ
	    System.exit(-1);
    }
	}
	}
}

