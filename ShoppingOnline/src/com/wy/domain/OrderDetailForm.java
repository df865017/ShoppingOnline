package com.wy.domain;

import javax.servlet.http.*;

import org.apache.struts.action.*;
//订货明细表的bean
public class OrderDetailForm
    extends ActionForm {
  private Integer goodsId;
  private Integer id;
  private String orderNumber;
  private float price;

  private int number;

  public Integer getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Integer goodsId) {
    this.goodsId = goodsId;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public Integer getId() {
    return id;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public int getNumber() {
    return number;
  }

  public float getPrice() {
    return price;
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
