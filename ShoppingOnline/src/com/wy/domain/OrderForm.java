package com.wy.domain;

import javax.servlet.http.*;

import org.apache.struts.action.*;
//¶©»õ±íµÄbean
public class OrderForm
    extends ActionForm {
  private String address;
  private String bz;
  private Integer id;
  private String name;
  private String number;
  private String post;
  private String reallyName;
  private String setMoney;
  private String sign;
  private String tel;
  private String creaTime;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public void setSetMoney(String setMoney) {
    this.setMoney = setMoney;
  }

  public void setReallyName(String reallyName) {
    this.reallyName = reallyName;
  }

  public void setPost(String post) {
    this.post = post;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public void setCreaTime(String creaTime) {
    this.creaTime = creaTime;
  }

  public String getBz() {
    return bz;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getNumber() {
    return number;
  }

  public String getPost() {
    return post;
  }

  public String getReallyName() {
    return reallyName;
  }

  public String getSetMoney() {
    return setMoney;
  }

  public String getSign() {
    return sign;
  }

  public String getTel() {
    return tel;
  }

  public String getCreaTime() {
    return creaTime;
  }

  public ActionErrors validate(ActionMapping actionMapping,
                               HttpServletRequest httpServletRequest) {
      /** @todo: finish this method, this is just the skeleton.*/
    return null;
  }

  public void reset(ActionMapping actionMapping,
                    HttpServletRequest servletRequest) {
  }
}
