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

@WebServlet("/update")
public class update_controller extends HttpServlet
{
	member_repository repo = member_repository.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("update : get");
		
		// 전처리
		String id = req.getParameter("id");
		
		// 모델 이동
		member mb = repo.readOne(id);
		
		// 뷰 이동
		req.setAttribute("mb", mb);
		RequestDispatcher ds = req.getRequestDispatcher("updateForm.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("update : post");
		
		// 전처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		// 모델 이동
		repo.update(id, pw);
		
		// 뷰 이동
		resp.sendRedirect("read_all");
	}
}
