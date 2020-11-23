package com.cisco.app.oauth.controller;

import java.util.Collections;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/user")
public class AuthenticationController  {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@GetMapping("/user")
	@ResponseBody
	public Object getUser(HttpServletRequest request, @AuthenticationPrincipal OAuth2User principal) {
		logger.info("getUser:::::::::::::::::");
		long tstart = System.currentTimeMillis();
		try {
			logger.info("principal {}:", principal.getAuthorities());
			if (principal != null) {
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				if (auth != null) {
//					logger.info("auth {}:", auth);
					logger.info("auth.isAuthenticated:" + auth.isAuthenticated());
					return "{\"response\":\"" + auth.isAuthenticated() + "\"}";
//					return principal;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			logExecutionTime(request, tstart, "/user/getUser");
		}
		return "{\"response\":\"false\"}";
	}

	public OAuth2User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return ((OAuth2AuthenticationToken) auth).getPrincipal();
	}

	private void logExecutionTime(HttpServletRequest request, long tstart, String method) {
		try {
			logger.info( "Done in " + (System.currentTimeMillis() - tstart) + " milli seconds"  + request.getSession().getId() + " - " + method + "");
		} catch (Exception e) {
			logger.error("", e);
		}
	}

//	@RequestMapping(value = "/custom-logout", method = RequestMethod.GET)
//	public String customLogout(HttpServletRequest request, HttpServletResponse response) {
//		// Get the Spring Authentication object of the current request.
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//		// In case you are not filtering the users of this request url.
//		if (authentication != null) {
//			new SecurityContextLogoutHandler().logout(request, response, authentication); // <= This is the call you are looking for.
//		}
//		return "redirect:/login-page";
//	}
	
	
//	private void forwardRequest(String method, HttpServletRequest req, HttpServletResponse resp) {
//		final boolean hasoutbody = (method.equals("POST"));
//
//		try {
//			final URL url = new URL("https://idbroker.webex.com/idb/oauth2/v1/logout" + req.getRequestURI() + (req.getQueryString() != null ? "?" + req.getQueryString() : ""));
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			conn.setRequestMethod(method);
//
//			final Enumeration<String> headers = req.getHeaderNames();
//			while (headers.hasMoreElements()) {
//				final String header = headers.nextElement();
//				final Enumeration<String> values = req.getHeaders(header);
//				while (values.hasMoreElements()) {
//					final String value = values.nextElement();
//					conn.addRequestProperty(header, value);
//				}
//			}
//
//			// conn.setFollowRedirects(false); // throws AccessDenied exception
//			conn.setUseCaches(false);
//			conn.setDoInput(true);
//			conn.setDoOutput(hasoutbody);
//			conn.connect();
//
//			final byte[] buffer = new byte[16384];
//			while (hasoutbody) {
//				final int read = req.getInputStream().read(buffer);
//				if (read <= 0)
//					break;
//				conn.getOutputStream().write(buffer, 0, read);
//			}
//
//			resp.setStatus(conn.getResponseCode());
//			for (int i = 0;; ++i) {
//				final String header = conn.getHeaderFieldKey(i);
//				if (header == null)
//					break;
//				final String value = conn.getHeaderField(i);
//				resp.setHeader(header, value);
//			}
//
////			while (true) {
////				final int read = conn.getInputStream().read(buffer);
////				if (read <= 0)
////					break;
////				resp.getOutputStream().write(buffer, 0, read);
////			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			// pass
//		}
//	}	



}
