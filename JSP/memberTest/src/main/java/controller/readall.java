package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao1.memberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/readall")
public class readall extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//전처리
		//모델이동
		memberRepository repository = new memberRepository();
		ArrayList arr = repository.readall();
		
		//뷰이동
		req.setAttribute("arr", arr);
		RequestDispatcher ds = req.getRequestDispatcher("allview.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

	}
	
}
