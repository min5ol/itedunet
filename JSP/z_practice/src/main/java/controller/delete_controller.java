package controller;

import java.io.IOException;

import dao.member_repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class delete_controller extends HttpServlet
{
	member_repository repo = member_repository.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("delete : get");
		
		// 전처리
		String id = req.getParameter("id");
		
		// 모델 이동
		repo.delete(id);
		
		// 뷰 이동
		resp.sendRedirect("read_all");
	}
}
