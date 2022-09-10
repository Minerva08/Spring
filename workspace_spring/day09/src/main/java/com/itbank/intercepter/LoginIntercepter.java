package com.itbank.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itbank.member.MemberDTO;

public class LoginIntercepter extends HandlerInterceptorAdapter {

	// Menu - Source - Override/Implement method
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		System.out.print("1) ");
		System.out.println(login != null ? "로그인 사용자 : " + login.getUserid() : "로그인 없음" );
		
		if(login != null) {
			return true;
		}
		
		String cpath = request.getContextPath();
		String url = request.getRequestURL().toString();
		// 클라이언트 요청한 주소 (원래 가려고 했던 주소)

		response.sendRedirect(cpath + "/login?url=" + url);
		return false;	// 반환값에 따라서 기존 요청에 대한 처리를 그대로 진행하거나	true
						// 혹은 진행을 중단하고 새로운 응답을 만들어서 보낸다		false
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	
}
