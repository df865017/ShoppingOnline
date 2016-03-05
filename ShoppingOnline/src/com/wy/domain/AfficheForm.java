package com.wy.domain;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

//公告信息bean
public class AfficheForm
    extends ActionForm {
  private String content = "";
  private Integer id = new Integer( -1);
  private String issueTime = "";
  private String name = "";
  public AfficheForm() {}
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setIssueTime(String issueTime) {
    this.issueTime = issueTime;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public String getIssueTime() {
    return issueTime;
  }

  public String getName() {
    return name;
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
