package dao1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto1.member;

public class memberRepository
{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//DB연결 함수
	public Connection dbconn() throws Exception
	{
		String url="jdbc:mysql://localhost:3306/membertest";
		String id="root";
		String pw="0508";
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		
		return conn;
	}
	
	//create
	public void create(member mb)
	{
		System.out.println("repository : create 함수 입장");
		System.out.println(mb.toString());
		
		String sql = "insert into member values(?,?,?)";
		
		try
		{
			conn = dbconn();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPassword());
			pstmt.setString(3, mb.getName());
			
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//update
	public void update(member mb)
	{
		System.out.println("repository : update 함수 입장");
		
		String sql = "update member set password=?, name=? where id=?";
		
		try
		{
			conn = dbconn();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mb.getPassword());
			pstmt.setString(2, mb.getName());
			pstmt.setString(3, mb.getId());
			
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{	
			e.printStackTrace();
		}
	}
	
	
	//delete
	public void delete(String id)
	{
		System.out.println("repository : delete 함수 입장");

		String sql = "delete from member where id=?";

		try
		{
			conn = dbconn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//read
	public ArrayList readall()
	{
		System.out.println("repository : read 함수 입장");
		
		ArrayList memberset = null;
		
		try
		{
			//db 연결
			conn = dbconn();
			
			//쿼리 전송
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			memberset = new ArrayList();
			
			while(rs.next())
			{
				member mb = new member();
				mb.setId(rs.getString("id"));
				mb.setPassword(rs.getString("password"));
				mb.setName(rs.getString("name"));
				memberset.add(mb);
			}
		}
		catch(Exception e) {}

		return memberset;
	}
	
	public member readone(String id)
	{
		member mb = null;
		
		try
		{
			conn = dbconn();
			
			String sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				mb = new member();
				mb.setId(rs.getString("id"));
				mb.setPassword(rs.getString("password"));
				mb.setName(rs.getString("name"));
			}
		}
		catch(Exception e) {}

		return mb;
	}
}
