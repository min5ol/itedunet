package controller;

import java.io.IOException;

import dao1.memberRepository;
import dto1.member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class create_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("create : doget");
		RequestDispatcher ds = req.getRequestDispatcher("form.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("create : dopost");
		
		//전처리
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		
		System.out.println(id);
		System.out.println(password);
		System.out.println(name);
		
		member mb = new member(id,password,name);
		System.out.println(mb.toString());
		
		//모델 이동
		memberRepository repository = new memberRepository();
		repository.create(mb);
		
		//뷰 이동
		resp.sendRedirect("readall");
	}

}
