package ch14;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookie01")
public class cookie01 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("cookie01 get방식 연결됨");
		
		RequestDispatcher ds = req.getRequestDispatcher("ch14/cookie01.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("cookie01 post방식 연결됨");
		
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		req.setAttribute("id", id);
		req.setAttribute("passwd", passwd);
		
		RequestDispatcher ds = req.getRequestDispatcher("ch14/cookie01_process.jsp");
		ds.forward(req, resp);
	}
	
}
