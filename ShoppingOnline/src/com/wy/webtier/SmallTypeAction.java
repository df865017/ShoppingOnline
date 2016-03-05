package com.wy.webtier;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.wy.domain.SmallTypeForm;
import org.apache.struts.action.Action;
import com.wy.dao.SmallTypeDao;

import java.sql.SQLException;
import java.util.List;

//��ƷС�����Ϣ
public class SmallTypeAction
    extends Action {
  private int action;
  private SmallTypeDao dao = null;
  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) {
    action = Integer.parseInt(request.getParameter("action"));
    dao = new SmallTypeDao();
    switch (action) {
      case 0: {
        try {
			return smallTypeSelect(mapping, form, request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //ȫ����ѯС�����Ϣ
      }
      case 2: {
        try {
			return smallTypeInsert(mapping, form, request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //���С�����Ϣ
      }
      case 3: {
        try {
			return smallTypeDelete(mapping, form, request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //ɾ��С�����Ϣ
      }
      case 4: {
        try {
			return smallTypeSelectOne(mapping, form, request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //�����ݿ���ˮ��Ϊ������ѯС�����Ϣ
      }
      case 5: {
        try {
			return smallTypeUpdate(mapping, form, request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //�����ݿ���ˮ��Ϊ�����޸�С�����Ϣ
      }
      case 6: {
        try {
			return smallTypeSelectBigId(mapping, form, request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //��������Ϊ�����޸�С�����Ϣ
      }
    }


    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

  //��������Ϊ�����޸�С�����Ϣ
  public ActionForward smallTypeSelectBigId(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response) throws NumberFormatException, SQLException {
    List list = dao.selectOneBigId(Integer.valueOf(request.getParameter("bigId")));
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
    return mapping.findForward("smallTypeSelect");
  }

  //�����ݿ���ˮ��Ϊ�����޸�С�����Ϣ
  public ActionForward smallTypeUpdate(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) throws SQLException {
    SmallTypeForm smallTypeForm = (SmallTypeForm) form;
    smallTypeForm.setBigId(Integer.valueOf(request.getParameter("bigId")));
    smallTypeForm.setId(Integer.valueOf(request.getParameter("id")));
    smallTypeForm.setSmallName(request.getParameter("name"));
    dao.updateSmall(smallTypeForm);
    request.setAttribute("success", "�޸�С�����Ϣ�ɹ�");
    return mapping.findForward("smallTypeOperation");
  }

  //�����ݿ���ˮ��Ϊ������ѯС�����Ϣ
  public ActionForward smallTypeSelectOne(ActionMapping mapping,
                                          ActionForm form,
                                          HttpServletRequest request,
                                          HttpServletResponse response) throws NumberFormatException, SQLException {
    request.setAttribute("small",
                         dao.selectOneBig(Integer.valueOf(request.
        getParameter("id"))));
    return mapping.findForward("smallTypeSelectOne");
  }

  //ɾ��С�����Ϣ
  public ActionForward smallTypeDelete(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) throws NumberFormatException, SQLException {

    if (dao.deleteSmall(Integer.valueOf(request.getParameter("id")))) {
      request.setAttribute("result", "ɾ��С�����Ϣ�ɹ���");
    }else {
      request.setAttribute("result", "��Ʒ��Ϣ�����ڴ��������ɾ����Ʒ��Ϣ������");
    }
    return mapping.findForward("smallTypeOperation");
  }

  //���С�����Ϣ
  public ActionForward smallTypeInsert(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) throws SQLException {
    SmallTypeForm smallTypeForm = (SmallTypeForm) form;
    smallTypeForm.setBigId(Integer.valueOf(request.getParameter("bigId")));
    smallTypeForm.setSmallName(request.getParameter("name"));
    dao.insertSmall(smallTypeForm);
    request.setAttribute("result", "���С�����Ϣ�ɹ�");
    return mapping.findForward("smallTypeOperation");
  }


  //ȫ����ѯС�����Ϣ
  public ActionForward smallTypeSelect(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) throws SQLException {
    List list = dao.selectSmall();
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
    return mapping.findForward("smallTypeSelect");
  }
}
