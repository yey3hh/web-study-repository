package org.kosa.myproject.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 	Ver4 : MVC + Singleton + FrontController + Command Design Pattern
 */
@WebServlet("/FrontControllerServletVer4")
public class FrontControllerServletVer4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 공통 작업
			// client 요청 분석
			String command = request.getParameter("command");
			// 추상화된 인터페이스 타입
			Controller controller = null;
			if(command.equals("findbyid")) {
				controller = new FindCustomerByIdController();
			} else if(command.equals("registerCustomer")) {
				controller = new RegisterCustomerController();
			}
			// Command Patter 적용(캡슐화로 인해)으로 표준화된 단일한 방식으로
			// 다양한 컨트롤러들을 실행시켜 요청을 처리할 수 있음
			String path = controller.handleRequest(request, response);
//			String url = "redirect:register-result.jsp"; 
			if(path.trim().startsWith("redirect:")) {
				response.sendRedirect(path.trim().substring(9));
			} else {
				request.getRequestDispatcher(path).forward(request, response);
			}
			// Controller 영역에서 View로 제어를 이동하는 방식 : forward와 Redirect
			// forward 이동방식 : reqeust와 response가 유지되면서 이동하는 방식, 웹 컨테이너 상에서 이동하여 응답되는 방식, 정보 조회용도 -> request에 공유해서 response 되면 request, response는 소멸
			//					웹 어플리케이션 상에서 공유 객체 범위 : request < session < application
//			특징 : 기존 request가 유지되므로 새로고침시 재동작되는 특성 -> 등록 등 재동작되면 안되는 업무는 적합하지 않음
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");	// Front에서 예외 처리 공통 정책 실행
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doDispatch(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		하위 버전에서는 POST 방식일 경우 별도의 한글 처리 필요
		request.setCharacterEncoding("UTF-8");
		this.doDispatch(request, response);
	}

}
