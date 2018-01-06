package com.globaltade.talent.configuration;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.InternalResourceView;

public class JstlView extends InternalResourceView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		exposeModelAsRequestAttributes(model, request);
		String dispatcherPath = prepareForRendering(request, response);
		request.setAttribute("partial", dispatcherPath);
		if ("login.jsp".equals(dispatcherPath.substring(dispatcherPath.lastIndexOf("/") + 1))) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			requestDispatcher.include(request, response);
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/principal.jsp");
			requestDispatcher.include(request, response);
		}
	}

}
