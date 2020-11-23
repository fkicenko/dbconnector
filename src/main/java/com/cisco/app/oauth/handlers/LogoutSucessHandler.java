//package com.cisco.app.oauth.handlers;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
//
//public class LogoutSucessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {
//	private static final Logger log = LoggerFactory.getLogger(LogoutSucessHandler.class);
//
//	
//	@Override
//	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
//		log.info("public void onLogoutSuccess");
//		try {
//			request.logout();
//			super.onLogoutSuccess(request, response, authentication);
//			if (authentication != null) {
//				new SecurityContextLogoutHandler().logout(request, response, authentication);
//			}
//
//			SecurityContextHolder.getContext().setAuthentication(null);
//
//			Cookie cookie = new Cookie("XSRF-TOKEN", "");
//			cookie.setMaxAge(0);
//			response.addCookie(cookie);
//
//			HttpSession session = request.getSession(false);
//			if (session != null) {
//				session.invalidate();
//			}
//		} catch (Exception e) {
//			log.error("", e);
//		}		
//	}
//}
