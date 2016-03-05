package com.wy.domain;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
//商品小类别bean
public class SmallTypeForm
    extends ActionForm {
  private Integer bigId=Integer.valueOf("-1");//商品大类别表的外键
  private String creaTime="";//创建时间
  private Integer id=Integer.valueOf("-1");//数据库流水号
  private String smallName="";//商品小类别信息
  public Integer getBigId() {
    return bigId;
  }

  public void setBigId(Integer bigId) {
    this.bigId = bigId;
  }

  public void setSmallName(String smallName) {
    this.smallName = smallName;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setCreaTime(String creaTime) {
    this.creaTime = creaTime;
  }

  public String getCreaTime() {
    return creaTime;
  }

  public Integer getId() {
    return id;
  }

  public String getSmallName() {
    return smallName;
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
