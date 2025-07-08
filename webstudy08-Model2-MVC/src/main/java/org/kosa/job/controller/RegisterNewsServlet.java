package org.kosa.job.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.kosa.job.model.NewsService;

/**
 * Controller에서 View로 제어를 이동하는 방식 : redirect 방식 연습
 */
@WebServlet("/RegisterNews")
public class RegisterNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// client request를 분석 (form data를 받아온다.)
		String news = request.getParameter("news");
		NewsService.getInstance().registerNews(news);
		// 공부를 위해 일단 forward로 제어를 이동해본다.
		// 문제점 : forward로 처리한 후 클라이언트가 새로고침하면 뉴스가 다시 등록되는 문제 발생됨.
//		request.getRequestDispatcher("/news-register-result.jsp").forward(request, response);
		// 이후 redirect로 이동 후 비교해본다.
		// forward는 웹 컨테이너 상에서 이동되는 반면, redirect는 응답시에 브라우저에게 지정한 url로 재요청하여 응답 결과를 보라는 방식
		response.sendRedirect("news-register-result.jsp");
	}

}
