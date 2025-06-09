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

@WebServlet("/delete")
public class delete_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("delete : doget 입장");
		
		//전처리
		String id = req.getParameter("id");
		System.out.println("삭제할 id : "+id);
		
		memberRepository repository = new memberRepository();
		repository.delete(id);
		
		resp.sendRedirect("readall");
	}
	
}
