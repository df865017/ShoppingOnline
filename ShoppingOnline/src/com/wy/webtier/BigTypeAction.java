package com.wy.webtier;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.Action;

import java.sql.SQLException;
import java.util.List;
import com.wy.dao.BigTypeDao;


//商品大类别信息
public class BigTypeAction
    extends Action {
	

	
  private int action;
  private BigTypeDao dao = null;
  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) {
    dao = new BigTypeDao();
    this.action = Integer.parseInt(request.getParameter("action"));
    switch (action) {
      case 0: {
        try {
			return bigTypeSelect(mapping, form, request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //全部查询商品信息
      }
      case 2: {
        try {
			return bigTypeInsert(mapping, form, request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //添加大类别的信息
      }
      case 3: {
        try {
			return bigTypeDelete(mapping, form, request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //删除大类别的信息
      }
    }

    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }


//删除大类别的信息
  public ActionForward bigTypeDelete(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws NumberFormatException, SQLException {
    if (dao.deleteBig(Integer.valueOf(request.getParameter("id")))) {
      request.setAttribute("result", "删除大类别信息成功");
    }
    else {
      request.setAttribute("result", "小类别还存在此信息，请先删除小类别信息");
    }

    return mapping.findForward("resultBigType");
  }

  
  
  
//添加大类别的信息
  public ActionForward bigTypeInsert(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws SQLException {
    dao.insertBig(request.getParameter("name"));
    request.setAttribute("result", "添加大类别信息成功");
    return mapping.findForward("resultBigType");
  }



//全部查询商品信息
  public ActionForward bigTypeSelect(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws SQLException {
    List list = dao.selectBig();
    int pageNumber = list.size(); //计算出有多少条记录
    int maxPage = pageNumber; //计算有多少页数
    String number = request.getParameter("i");
    if (maxPage % 6 == 0) {
      maxPage = maxPage / 6;
    }
    else {
      maxPage = maxPage / 6 + 1;
    }
    if (number == null) {
      number = "0";
    }
    request.setAttribute("number", String.valueOf(number));
    request.setAttribute("maxPage", String.valueOf(maxPage));
    request.setAttribute("pageNumber", String.valueOf(pageNumber));
    request.setAttribute("list", list);
    return mapping.findForward("bigTypeSelect");
  }

}
