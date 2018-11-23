package com.ey.piit.core.web.bind.method;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.ey.piit.core.common.Constants;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.exception.ValidateException;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.utils.BeanValidators;
import com.ey.piit.core.utils.ExceptionUtils;
import com.ey.piit.core.utils.StringUtils;

public class HandlerMethodExceptionResolver extends ExceptionHandlerExceptionResolver {

	@SuppressWarnings("unchecked")
	protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response,
			HandlerMethod handlerMethod, Exception ex) {

		if (handlerMethod != null) {
			Method method = handlerMethod.getMethod();
			if (method != null) {
				Token annotation = method.getAnnotation(Token.class);
				if (annotation != null) {
					boolean needSaveToken = annotation.verify();
					if (needSaveToken) {//出现异常token要再加回来
						String clinetToken = request.getParameter(Constants.CURRENT_TOKEN);
						Map<String, String> serverToken = (Map<String, String>) request.getSession()
								.getAttribute(Constants.CURRENT_TOKEN);
						serverToken.put(clinetToken, "");
					}
				}
			}
		}

		String errorMsg = null;
		if (ex instanceof ValidateException) {
			errorMsg = ex.getMessage();
		} else if (ex instanceof ConstraintViolationException) {
			List<String> extractMessage = BeanValidators.extractMessage((ConstraintViolationException) ex);
			errorMsg = StringUtils.join(extractMessage, System.lineSeparator());
		} else if (ex instanceof ServiceException) {
			errorMsg = ex.getMessage();

			// 记录日志
			logger.error(ex.getMessage(), ex);
		} else {
			errorMsg = ExceptionUtils.getRootCauseMessage(ex);

			// 记录日志
			logger.error(ex.getMessage(), ex);
		}

		if ((request.getHeader("accept").indexOf("application/json") > -1
				|| (request.getHeader("X-Requested-With") != null
						&& request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
			try {
				String msg = "{success:false,message:\"" + errorMsg + "\"}";
				PrintWriter writer = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				writer.write(msg);
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new ModelAndView();
		}

		String resultViewName = null;

		request.setAttribute("exTrace", ExceptionUtils.getStackTrace(ex));

		// 根据不同错误转向不同页面
		if (ex instanceof UnauthorizedException) {
			resultViewName = "errors/403";
		} else if (ex instanceof NoHandlerFoundException) {
			resultViewName = "errors/404";
		} else {
			resultViewName = "errors/500";
		}

		return new ModelAndView(resultViewName);
	}

}
