package priv.dengjl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import priv.dengjl.controller.MyController;

public class MyInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(MyController.class);

	// 前置方法  若返回false，则直接结束
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("=>{}", "preHandle");
		return true;
	}

	// 后置方法
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("=>{}", "postHandle");
	}

	// 视图结束后方法
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("=>{}", "afterCompletion");
	}

}
