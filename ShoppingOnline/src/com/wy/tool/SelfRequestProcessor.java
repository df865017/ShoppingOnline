package com.wy.tool;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.RequestProcessor;

public class SelfRequestProcessor extends RequestProcessor {
	public SelfRequestProcessor() {
	}

	protected boolean processPreprocess(HttpServletRequest request,
			HttpServletResponse response) {
		super.processPreprocess(request, response);
		try {
			request.setCharacterEncoding("gb2312");
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
		return true;
	}
}
