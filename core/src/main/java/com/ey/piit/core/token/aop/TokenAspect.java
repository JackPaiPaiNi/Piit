package com.ey.piit.core.token.aop;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;

import com.ey.piit.core.common.Constants;
import com.ey.piit.core.entity.BaseEntity;
import com.ey.piit.core.token.annotation.Token;
import com.google.common.collect.Maps;

/**
 * Token拦截器
 * 
 * @author Kevin-Y.Xu
 *
 */
@Aspect
@Order(1)
public class TokenAspect {

	@AfterReturning(pointcut = "@annotation(com.ey.piit.core.token.annotation.Token)", returning = "returnValue")
	public void afterReturning(JoinPoint point, Object returnValue) {
		if (returnValue != null) {
			if (returnValue instanceof BaseEntity) {
				Signature signature = point.getSignature();
				MethodSignature methodSignature = (MethodSignature) signature;
				Method method = methodSignature.getMethod();

				if (method != null) {
					Token annotation = method.getAnnotation(Token.class);
					if (annotation != null) {
						BaseEntity baseEntity = (BaseEntity) returnValue;
						String token = saveToken();
						baseEntity.setToken(token);
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private String saveToken() {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		Map<String, String> tokenMap = (Map<String, String>) session.getAttribute(Constants.CURRENT_TOKEN);
		if (tokenMap == null) {
			tokenMap = Maps.newHashMap();
			session.setAttribute(Constants.CURRENT_TOKEN, tokenMap);
		}
		String token = UUID.randomUUID().toString();
		tokenMap.put(token, "");
		session.setAttribute(Constants.CURRENT_TOKEN, tokenMap);
		return token;
	}

}
