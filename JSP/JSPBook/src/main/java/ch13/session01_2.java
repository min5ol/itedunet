package ch13;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/session01_2")
public class session01_2 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
        System.out.println("GET 요청으로 session01_2 연결됨");
        
        HttpSession session = req.getSession(false);
        String id = (String) session.getAttribute("id");
        String pw = (String) session.getAttribute("pw");
        
        System.out.println(id);
        System.out.println(pw);
        
        RequestDispatcher ds = req.getRequestDispatcher("ch13/session01.jsp");
        ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
        System.out.println("POST 요청으로 session01 연결됨");
        
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        
        if("admin".equals(id)&& pw.equals("1234"))
        {
        	// 로그인 성공 로직
        	// true : 없으면 새로 만들고 있으면 그냥 그거 줘
        	// false : 없으면 null을 주고 있으면 그냥 그거 줘
        	// 빈 값일 경우 true
        	
        	HttpSession session = req.getSession(true);
        	session.setAttribute("id", id);
        	session.setAttribute("pw", pw);
        }
        	
        RequestDispatcher ds = req.getRequestDispatcher("ch13/session01_success.jsp");
        ds.forward(req, resp);
	}
	
}
