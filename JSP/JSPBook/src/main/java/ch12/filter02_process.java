package ch12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/filter02_process")
public class filter02_process extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("filter_process 연결됨");
		
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		req.setAttribute("id", id);
		req.setAttribute("passwd", passwd);
		
		RequestDispatcher ds = req.getRequestDispatcher("ch12/filter02_process.jsp");
		ds.forward(req,resp);
	}
	
}
