package step4;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class SecurityInitializer
 * 
 * ServletContextListener : 웹 어플리케이션 시작시 이벤트를 감지하여 contextInitialized()를 실행시킨다. 
 * 							-> 웹 어플리케이션의 초기화 작업을 수행할 수 있다. -> 대표적인 예) SpringFramework의 Security 작업임
 * 
 * 웹 어플리케이션 종료 직전에 이벤트를 감지하여 contextDestroyed()를 실행시킨다 -> 웹 어플리케이션 종료 직전에 수행해야할 백업 작업 및 로깅 작업 등을 수행.
 *
 */
@WebListener
public class SecurityInitializer implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SecurityInitializer() {
        System.out.println(getClass() + " 객체 생성");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
    	System.out.println(getClass() + " contextInitialized Security 초기화 작업 security config : " + context.getInitParameter("securityConfigInfo"));
//    	웹 프로그램들이 공유할 수 있는 정보를 제공
//    	예) 데이타베이스의 빈번하게 조회되는 기본 정보들을 메모리(캐시)에 할당한 후 개발 웹프로그램들은 DB연동 없이 즉시 사용하게 하는 목적
    	context.setAttribute("securityRoleInfo", "보안 ROLE 공통 기준 정보");
    	System.out.println("contextInitialized에서 보낸 ROLE 공통 기준 정보 설정");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println(getClass() + " contextDestroyed Security 백업 작업");
    }
	
}
