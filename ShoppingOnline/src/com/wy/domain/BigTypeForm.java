package com.wy.domain;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
//商品大类别bean
public class BigTypeForm
    extends ActionForm {
  private String bigName="";
  private String creaTime="";
  private Integer id=Integer.valueOf("-1");
  public BigTypeForm(){}
  public String getBigName() {
    return bigName;
  }

  public void setBigName(String bigName) {
    this.bigName = bigName;
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

  public ActionErrors validate(ActionMapping actionMapping,
                               HttpServletRequest httpServletRequest) {
      /** @todo: finish this method, this is just the skeleton.*/
    return null;
  }

  public void reset(ActionMapping actionMapping,
                    HttpServletRequest servletRequest) {
  }
}
