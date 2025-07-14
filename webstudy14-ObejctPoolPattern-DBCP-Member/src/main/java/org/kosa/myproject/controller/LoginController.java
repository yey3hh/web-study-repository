package org.kosa.myproject.controller;

import org.kosa.myproject.model.MemberDao;
import org.kosa.myproject.model.MemberVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberVo memberVo = MemberDao.getInstance().login(request.getParameter("id"), request.getParameter("password"));
		
		String path = null;
		if (memberVo != null) {
			path = "login-ok.jsp";
			HttpSession session = request.getSession();
			session.setAttribute("mvo", memberVo);
		} else {
			path = "login-fail.jsp";
		}
		
		return path;
	}

}
