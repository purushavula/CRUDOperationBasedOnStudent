package com.tech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;


public class Student {
	
	private static final String url="jdbc:mysql://localhost:3306/palle";
	private  static Connection  con=null;
	private  static Statement s=null;
    private static PreparedStatement ps=null;
	private static ResultSet rs=null;

	
	
	public void creating() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url, "root", "purush");
			s=con.createStatement();
			s.executeUpdate("create table student(sid int primary key auto_increment,"
					+ "sname varchar(40),sub varchar (50),semail varchar(70))");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			finally {
				try {
					if(ps!=null) {

					ps.close();
				     } 
					if(con!=null) {
						con.close();
					}
				}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}
public void inserting(String name,String sub,String email) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url, "root", "purush");
			ps=con.prepareStatement("insert into student(sname,sub,semail) values(?,?,?)");
			ps.setString(1, name);
			ps.setString(2,sub);
			ps.setString(3, email);
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null) {

				ps.close();
			     } 
				if(con!=null) {
					con.close();
				}
			}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		
			
		
	}
public void updating(int sid,String email,String sub) {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection(url, "root", "purush");
		ps=con.prepareStatement("update student set sid=?,sub=?,semail=?");
		ps.setInt(1, sid);
		ps.setString(2,email);
		ps.setString(3, sub);
		ps.executeUpdate();
		

	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			if(ps!=null) {

			ps.close();
		     } 
			if(con!=null) {
				con.close();
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
}



public void deleting(int sid) {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection(url, "root", "purush");
		ps=con.prepareStatement("delete from student where sid=?");
		ps.setInt(1, sid);
		ps.executeUpdate();
		

	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			if(ps!=null) {

			ps.close();
		     } 
			if(con!=null) {
				con.close();
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void read() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url, "root", "purush");
			s=con.createStatement();
			rs=s.executeQuery("select * from student");
			while(rs.next()) {
				System.out.println(rs.getInt("sid"));
				System.out.println(rs.getString("sname"));
				System.out.println(rs.getString("sub"));
				System.out.println(rs.getString("semail"));
			}
			
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
				try {
					if(ps!=null) {

					ps.close();
				     } 
					if(con!=null) {
						con.close();
					}
				}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}
		
		
		
	}
	






