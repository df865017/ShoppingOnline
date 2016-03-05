package com.wy.webtier;

import javax.servlet.http.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wy.domain.LinkForm;

import com.wy.dao.LinkDao;

import java.sql.SQLException;
import java.util.*;
import java.io.UnsupportedEncodingException;


//网站连接的Action
public class LinkAction
    extends Action {
  private LinkDao dao = null;
  private int action;


  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) throws
      UnsupportedEncodingException {
    this.action = Integer.parseInt(request.getParameter("action"));
    dao = new LinkDao();
    switch (action) {
      case 0: {
        try {
			return linkSelect(mapping, form, request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //对连接网站地址信息的全部查询
      }   
      case 2: {
       try {
		return linkInsert(mapping, form, request, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //添加网站信息
     }
       case 4: {
           try {
			return linkDelete(mapping, form, request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //删除网站信息
     }
    }
    //  LinkForm linkForm = (LinkForm) form;
    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

  //删除网站信息
  public ActionForward linkDelete(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response) throws NumberFormatException, SQLException {
    dao.deleteLink(Integer.valueOf(request.getParameter("id")));
    return linkSelect(mapping, form, request, response);
}

    //添加网站信息
    public ActionForward linkInsert(ActionMapping mapping,
                                              ActionForm form,
                                              HttpServletRequest request,
                                              HttpServletResponse response) throws SQLException {
      LinkForm linkForm = (LinkForm) form;
      dao.insertLink(linkForm);
      return linkSelect(mapping, form, request, response);
  }



  //对连接网站地址信息的全部查询
  public ActionForward linkSelect(ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request,
                                  HttpServletResponse response) throws SQLException {
    List list = dao.selectLink();
    int pageNumber = list.size(); //计算出有多少条记录
    int maxPage = pageNumber; //计算有多少页数
    String number = request.getParameter("i");
    if (maxPage % 7 == 0) {
      maxPage = maxPage / 7;
    }
    else {
      maxPage = maxPage / 7 + 1;
    }
    if (number == null) {
      number = "0";
    }
    request.setAttribute("number", String.valueOf(number));
    request.setAttribute("maxPage", String.valueOf(maxPage));
    request.setAttribute("pageNumber", String.valueOf(pageNumber));
    request.setAttribute("list", list);
    return mapping.findForward("linkSelect");
  }


}
