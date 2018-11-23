package com.ey.piit.test.core;

import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.ey.piit.core.common.Constants;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.utils.Exceptions;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-config.xml", "classpath:spring-mvc.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class BaseTest {

	@Autowired
	protected WebApplicationContext wac;

	protected MockMvc mockMvc;

	@Before
	public void init() throws Exception {
		mockMvc = webAppContextSetup(wac).build();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("admin", "1");
		subject.login(token);

		User user = new User();
		user.setId("1");
		user.setUserName("admin");
		user.setEmpCode("admin");
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		session.setAttribute(Constants.CURRENT_USER, user);
	}

	@SuppressWarnings("unchecked")
	public MockHttpServletRequestBuilder postParam(String url, String json) {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(url);
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> maps = objectMapper.readValue(json, Map.class);
			Set<String> key = maps.keySet();
			Iterator<String> iter = key.iterator();
			while (iter.hasNext()) {
				String field = iter.next();
				builder.param(field, maps.get(field) + "");
			}
		} catch (Exception e) {
			throw new RuntimeException("Json格式转换异常", e);
		}
		return builder;
	}
	
	public void toDoPost (String url, String sampleJson) {
		try {
			MockHttpServletRequestBuilder builder = post(url);
			builder.header("Accept","application/json, text/javascript");
			builder.header("X-Requested-With", "XMLHttpRequest");
			if (sampleJson != null) {
				String[] strArr = sampleJson.split(",");
				for (int i = 0; i < strArr.length; i++) {
					String keyVal = strArr[i];
					String[] keyValArr = keyVal.split(":");
					builder.param(keyValArr[0], keyValArr[1]);
				}
			}
			mockMvc.perform(builder).andExpect(status().isOk()).andExpect(new ResultMatcher() {
				@Override
				public void match(MvcResult result) throws Exception {
					String string = result.getResponse().getContentAsString();
//					string = new String(string.getBytes("utf-8"), "GB2312");
					assertTrue(string, string.indexOf("success:false") == -1);
				}
			}).andDo(print());
		} catch (Exception e) {
			Exceptions.unchecked(e);
		}
	}
	
	public void toDoGet (String url, String sampleJson) {
		try {
			MockHttpServletRequestBuilder builder = get(url);
			if (sampleJson != null) {
				String[] strArr = sampleJson.split(",");
				for (int i = 0; i < strArr.length; i++) {
					String keyVal = strArr[i];
					String[] keyValArr = keyVal.split(":");
					builder.param(keyValArr[0], keyValArr[1]);
				}
			}
			mockMvc.perform(builder).andExpect(status().isOk()).andExpect(model().attributeDoesNotExist("success")).andDo(print());
		} catch (Exception e) {
			Exceptions.unchecked(e);
		}
	}
	
}
