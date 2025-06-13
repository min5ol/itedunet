package controller;

import java.io.IOException;

import dao.member_repository;
import dto.member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class create_controller extends HttpServlet
{
	member_repository repo = member_repository.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("create : get");
		
		// 전처리 없음
		// 모델이동 없음
		// 뷰 이동
		RequestDispatcher ds = req.getRequestDispatcher("createForm.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("create : post");
		
		// 전처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		// 전처리 2
		member mb = new member();
		mb.setId(id);
		mb.setPw(pw);
		
		// 모델 이동
		repo.create(mb);
		
		// 뷰 이동
		resp.sendRedirect("read_all");
	}
	
	
}
