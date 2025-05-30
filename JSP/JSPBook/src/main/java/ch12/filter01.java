package ch12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/filter01")
public class filter01 extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("GET 요청으로 filter01 연결됨");
        RequestDispatcher ds = req.getRequestDispatcher("ch12/filter01.jsp");
        ds.forward(req, resp);
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("filter01 연결됨");
		RequestDispatcher ds = req.getRequestDispatcher("ch12/filter01.jsp");
		ds.forward(req,resp);
	}
	
}
