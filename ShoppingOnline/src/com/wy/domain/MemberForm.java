package com.wy.domain;

import org.apache.struts.action.ActionForm;

//会员表的bean
public class MemberForm extends ActionForm {
	private Integer age = 1; // 年龄

	private String email = ""; // 电子邮件

	private Integer id ; // 数据库流水号

	private String name = ""; // 会员名称

	private String password = ""; // 会员密码

	private String profession = ""; // 会员职业

	private String question = ""; // 找回密码的问题

	private String reallyName = ""; // 真实姓名

	private String result = ""; // 找回密码的答案

	public MemberForm() {
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setReallyName(String reallyName) {
		this.reallyName = reallyName;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getProfession() {
		return profession;
	}

	public String getQuestion() {
		return question;
	}

	public String getReallyName() {
		return reallyName;
	}

	public String getResult() {
		return result;
	}
}
