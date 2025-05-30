package ch12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/filter01_process")
public class filter01_process extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("filter_process 연결됨");
		
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		
		req.setAttribute("name", name);
		
		RequestDispatcher ds = req.getRequestDispatcher("ch12/filter01_process.jsp");
		ds.forward(req,resp);
	}
	
}
