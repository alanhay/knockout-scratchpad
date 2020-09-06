package com.certait.knockout.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.certait.knockout.model.DataModel;
import com.certait.knockout.model.UIConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UIConfigFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		DataModel model = new DataModel(request.getParameter("gender").toCharArray()[0],
				Integer.parseInt(request.getParameter("age")));
		UIConfig config = new UIConfig(model);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(config);

		response.addHeader("uiConfig", json);

		filterChain.doFilter(request, response);
	}
}
