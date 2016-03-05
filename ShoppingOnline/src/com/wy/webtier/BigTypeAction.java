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


//��Ʒ�������Ϣ
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
		} //ȫ����ѯ��Ʒ��Ϣ
      }
      case 2: {
        try {
			return bigTypeInsert(mapping, form, request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //��Ӵ�������Ϣ
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
		} //ɾ����������Ϣ
      }
    }

    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }


//ɾ����������Ϣ
  public ActionForward bigTypeDelete(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws NumberFormatException, SQLException {
    if (dao.deleteBig(Integer.valueOf(request.getParameter("id")))) {
      request.setAttribute("result", "ɾ���������Ϣ�ɹ�");
    }
    else {
      request.setAttribute("result", "С��𻹴��ڴ���Ϣ������ɾ��С�����Ϣ");
    }

    return mapping.findForward("resultBigType");
  }

  
  
  
//��Ӵ�������Ϣ
  public ActionForward bigTypeInsert(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws SQLException {
    dao.insertBig(request.getParameter("name"));
    request.setAttribute("result", "��Ӵ������Ϣ�ɹ�");
    return mapping.findForward("resultBigType");
  }



//ȫ����ѯ��Ʒ��Ϣ
  public ActionForward bigTypeSelect(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws SQLException {
    List list = dao.selectBig();
    int pageNumber = list.size(); //������ж�������¼
    int maxPage = pageNumber; //�����ж���ҳ��
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
