package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.member;

public class member_repository
{
	// 싱글턴 생성
	private static member_repository repo = new member_repository();
	private member_repository() {}
	public static member_repository getInstance()
	{
		return repo;
	}
	
	// database connection 함수
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Connection dbconn() throws Exception
	{
		System.out.println("repo : database");
		
		String url = "jdbc:mysql://localhost:3306/test_crud";
		String id = "root";
		String pw = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		
		return conn;
	}
	
	// create 함수
	public void create(member mb)
	{
		System.out.println("repo : create");
		String sql = "insert into member values(?,?)";
		
		try
		{
			conn = dbconn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPw());
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// readAll 함수
	public ArrayList<member> readAll()
	{
		System.out.println("repo : readAll");
		ArrayList<member> arr = new ArrayList<member>();
		String sql = "select * from member";
		
		try
		{
			conn = dbconn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				member mb = new member();
				mb.setId(rs.getString("id"));
				mb.setPw(rs.getString("pw"));
				arr.add(mb);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return arr;
	}
	
	// readOne 함수
	public member readOne(String id)
	{
		System.out.println("repo : readOne");
		member mb = null;
		String sql = "select * from member where id=?";
		
		try
		{
			conn = dbconn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				mb = new member();
				mb.setId(rs.getString("id"));
				mb.setPw(rs.getString("pw"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return mb;
	}
	
	// update 함수
	public void update(String id, String pw)
	{
		System.out.println("repo : update");
		String sql = "update member set pw=? where id=?";
		
		try
		{
			conn = dbconn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// delete 함수
	public void delete(String id)
	{
		System.out.println("repo : delete");
		String sql = "delete from member where id=?";
		
		try
		{
			conn = dbconn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
