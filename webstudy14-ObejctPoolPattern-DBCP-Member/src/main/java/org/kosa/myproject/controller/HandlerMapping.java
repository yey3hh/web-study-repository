package org.kosa.myproject.controller;

import java.lang.reflect.InvocationTargetException;

/**
 * 	Factory Design Pattern : 객체 생성을 위임하여 전담하는 설계 패턴 (외부에서 생성하는 것의 부담을 덜게 한다.)
 * 							 구체적 객체 생성부를 캡슐화
 * 	HandlerMapping : 요청(request or command)처리를 위한 각 컨트롤러 객체 생성을 전담하는 Factory class
 * 					 Spring에서 동일한 이름으로 동일한 역할을 함
 * 	일반적으로 Factory는 시스템 상에서 단 하나만 존재하여 운영되므로 Singleton Pattern을 적용한다.
 * 	
 */
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		return instance;
	}
	
	/*
	 * 	요청 command에 의거해 요청을 처리할 구체적인 컨트롤러 객체 생성을 전담하는 메서드
	 * 
	 * 	런타임시 동적으로 컨트롤러 객체를 생성하기 위해 Reflection API를 이용 -> Dynamic Factory
	 */
	public Controller create(String command) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		// 현재 위치의 package와 class 정보를 저장하는 문자열 (동적으로)
		StringBuilder packageAndClassInfo = new StringBuilder(this.getClass().getPackageName());
//		package 명이 바뀔 수 있으니까 동적으로 바뀌면서
		packageAndClassInfo.append(".").append(command).append("Controller");
		
		return (Controller) Class.forName(packageAndClassInfo.toString()).getDeclaredConstructor().newInstance();
	}
}
