package com.xiaoysec.hrm.sys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoysec.hrm.business.user.entity.User;

/**
 * 登陆拦截器
 * 
 * @author xiaoysec
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	private static Logger logger =  LoggerFactory.getLogger(LoginInterceptor.class); 
	/**
	 * 视图返回后调用
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 从控制器返回视图中拦截，修改内容
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mv)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 返回false 请求将终止不会执行postHandle和afterCompletion
	 * 返回true 请求将继续进行
	 * Obj表示请求的目标控制器
	 * 
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		logger.info("LoginInterceptor preHandle方法被调用...");
		User user = (User) request.getSession().getAttribute("sessionUser");
		if(user == null){
			String path = request.getContextPath();
			response.sendRedirect(path+"/a/login");
			return false;
		}
		return true;
	}

}
