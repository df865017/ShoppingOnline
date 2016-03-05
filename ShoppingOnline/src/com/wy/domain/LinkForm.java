package com.wy.domain;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

//友情连接网站的Bean
public class LinkForm extends ActionForm {
	private Integer id = -1; // 数据库流水号

	private String linkAddress = ""; // 连接地址

	private String linkName = ""; // 连接名称

	public LinkForm() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}

	public String getLinkAddress() {
		return linkAddress;
	}

	public String getLinkName() {
		return linkName;
	}

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		
		return super.validate(arg0, arg1);
	}

}
