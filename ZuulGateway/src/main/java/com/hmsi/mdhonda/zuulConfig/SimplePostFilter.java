package com.hmsi.mdhonda.zuulConfig;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class SimplePostFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(SimplePostFilter.class);

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletResponse resp = ctx.getResponse();
		resp.addHeader("X-Sample", UUID.randomUUID().toString());
		log.info(String.format("%s resp code with header to %s", ctx.getResponse().getStatus(), "X-Sample"));

		return null;
	}
}