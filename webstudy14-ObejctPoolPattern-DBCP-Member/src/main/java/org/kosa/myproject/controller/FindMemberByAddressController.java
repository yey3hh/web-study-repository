package org.kosa.myproject.controller;

//import java.util.ArrayList;

import org.kosa.myproject.model.MemberDao;
//import org.kosa.myproject.model.MemberVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindMemberByAddressController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 내 버전
//		String address = request.getParameter("memberAddress");
//		ArrayList<MemberVo> list = MemberDao.getInstance().findMemberByAddress(address);
//		request.setAttribute("memberList", list);
		
		// 강사님 버전
		request.setAttribute("memberList", MemberDao.getInstance().findMemberByAddress(request.getParameter("memberAddress")));
		
		return "member-list.jsp";
	}

}
