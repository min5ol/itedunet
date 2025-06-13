package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.member_repository;
import dto.member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/read_all")
public class readAll_controller extends HttpServlet
{
	member_repository repo = member_repository.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("readAll : get");
		
		// 전처리
		
		// 모델 이동
		ArrayList<member> arr = repo.readAll();
		
		// 뷰 이동
		req.setAttribute("arr", arr);
		RequestDispatcher ds = req.getRequestDispatcher("allview.jsp");
		ds.forward(req, resp);
	}
}
