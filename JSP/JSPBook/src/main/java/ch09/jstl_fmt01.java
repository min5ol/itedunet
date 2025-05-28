package ch09;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl_fmt01")
public class jstl_fmt01 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("jstl_fmt01 doget 접속 완료");
		RequestDispatcher ds = req.getRequestDispatcher("ch09/jstl_fmt01.jsp");
		ds.forward(req,resp);
	}
	
}
