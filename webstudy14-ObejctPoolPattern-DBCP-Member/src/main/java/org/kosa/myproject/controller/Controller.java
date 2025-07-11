package org.kosa.myproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 	Command Design Pattern : 요청 처리 객체들을 캡슐화, 다형성을 지원(꼭 웹에서만 정형화 하는 패턴은 아님)
 * 
 * 	다양한 요청을 처리할 개별 컨트롤러들이 implements 할 표준화를 위한 인터페이스 
 * 		: 이렇게 계층 구조를 형성해 표준화하면 사용하는 FrontControllerServlet 에서는 단일한 소통방식으로
 * 		  수많은 개별 컨트롤러를 제어(실행)할 수 있다.
 * 
 * 	Spring에서 동일한 이름으로 동일한 역할을 함
 * 	
 */
public interface Controller {
	// HttpServletRequest request, HttpServletResponse response : 요청 처리를 위해 사용
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
