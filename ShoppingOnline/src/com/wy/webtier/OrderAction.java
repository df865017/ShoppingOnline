package com.wy.webtier;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.wy.domain.OrderForm;
import com.wy.domain.OrderDetailForm;
import org.apache.struts.action.Action;
import com.wy.dao.OrderDao;
import com.wy.dao.OrderDetailDao;

import java.sql.SQLException;
import java.util.List;

//后台订单管理的Action
public class OrderAction
    extends Action {
  private int action;
  private OrderDao order = null;
  private OrderDetailDao orderDetail = null;
  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) {
    action = Integer.parseInt(request.getParameter("action"));
    order = new OrderDao();
    orderDetail = new OrderDetailDao();
    switch (action) {
      case 0: {
        try {
			return selectOrder(mapping, form, request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //查询所有的订单
      }
      case 1: {
        try {
			return selectOrderSend(mapping, form, request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //出货
      }
      case 2: {
      try {
		return deleteOrder(mapping, form, request, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //删除操作
    }
    case 3: {
        try {
			return selectOneOrder(mapping, form, request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //查询订单的详细信息
      }

    }
    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }
//查询订单的详细信息
  public ActionForward selectOneOrder(ActionMapping mapping,
                                   ActionForm form,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws SQLException {
 String number=request.getParameter("number");
   request.setAttribute("orderForm",order.selectOrderNumber(number));
   request.setAttribute("orderDetailList",orderDetail.selectOrderDetailNumber(number));
   return mapping.findForward("selectOneOrder");
  }
//删除出货信息
  public ActionForward deleteOrder(ActionMapping mapping,
                                   ActionForm form,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws SQLException {
    String number = (String) request.getParameter("number");
    orderDetail.deleteOrderDetail(number);
    order.deleteOrder(number);
    return selectOrder(mapping, form, request, response);
   }

//出货
  public ActionForward selectOrderSend(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) throws SQLException {
    order.updateSignOrder(request.getParameter("number"));
    return selectOrder(mapping, form, request, response);
  }

  //查询所有的订单
  public ActionForward selectOrder(ActionMapping mapping,
                                   ActionForm form,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws SQLException {
    Integer sign = null;
    if (request.getParameter("sign") != null) {
      sign = Integer.valueOf(request.getParameter("sign"));
    }
    List list = order.selectOrderSign(sign);
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
    return mapping.findForward("selectOrder");
  }
}
