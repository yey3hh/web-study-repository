package org.kosa.job.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.kosa.job.model.MemberDao;
import org.kosa.job.model.MemberVo;

/**
 * Servlet implementation class Test01Serlvet
 */
@WebServlet("/Test01Serlvet")
public class Test01Serlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			MemberDao dao = MemberDao.getInstance();
			MemberVo vo = dao.findMemberById(id);
			request.setAttribute("member", vo);
			// forward 방식이므로 request, response 유지
			request.getRequestDispatcher("step1-el.jsp").forward(request, response);
		} catch (Exception e) {	// 예외 처리 로직
			e.printStackTrace();
		}
		
	}

}
