package com.wy.webtier;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.wy.domain.MemberForm;
import org.apache.struts.action.Action;
import com.wy.dao.MemberDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;



//会员管理Action
public class MemberAction extends Action {
	private int action;
	private MemberDao dao = null;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		dao = new MemberDao();
		this.action = Integer.parseInt(request.getParameter("action"));
		switch (action) {
		case 0: {
			try {
				return insertMember(mapping, form, request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 添加员工信息
		}
		case 1: {
			try {
				return checkMember(mapping, form, request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 会员登录
		}
		case 2: {
			try {
				return selectMember(mapping, form, request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 查看会员信息
		}
        case 3: {
			try {
				return selectOneMember(mapping, form, request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 查看会员的详细信息
		}
		case 4: {
			try {
				return deleteMember(mapping, form, request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 删除会员信息
		}
		case 5: {
			try {
				return selectOneMemberHead(mapping, form, request, response);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 前台查询会员的属性
		}
		case 6: {
			try {
				return updateMemberHead(mapping, form, request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 修改会员属性
		}

		}
		// MemberForm memberForm = (MemberForm) form;
		throw new java.lang.UnsupportedOperationException(
				"Method $execute() not yet implemented.");
	}

	// 修改会员属性
	public ActionForward updateMemberHead(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		MemberForm memberForm = (MemberForm) form;		
		dao.updateMember(memberForm);
		request.setAttribute("success", "修改成功");
		return mapping.findForward("operationMember");
	}

	// 前台查询会员的属性
	public ActionForward selectOneMemberHead(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws NumberFormatException, SQLException {
		request.setAttribute("form", dao.selectOneMember(Integer
				.valueOf(request.getParameter("id"))));
		return mapping.findForward("selectOneMemberHead");
	}

	// 删除操作
	public ActionForward deleteMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
	   if (!dao.deleteMember(Integer.valueOf(request.getParameter("id")))) {
		   return mapping.findForward("deleteMember");
		}
		return selectMember(mapping,form,request,response);
	}

	// 查看会员详细信息
	public ActionForward selectOneMember(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		Integer id=Integer.valueOf(request.getParameter("id"));
		request.setAttribute("form", dao.selectOneMember(id));
		return mapping.findForward("selectOneMember");
	}

	// 查看会员信息
	public ActionForward selectMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List list = dao.selectMember();
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
		String number = request.getParameter("i");
		if (maxPage % 6 == 0) {
			maxPage = maxPage / 6;
		} else {
			maxPage = maxPage / 6 + 1;
		}
		if (number == null) {
			number = "0";
		}
		request.setAttribute("number", String.valueOf(number));
		request.setAttribute("maxPage", String.valueOf(maxPage));
		request.setAttribute("pageNumber", String.valueOf(pageNumber));
		request.setAttribute("list", list);
		return mapping.findForward("selectMember");
	}

	// 会员登录
	public ActionForward checkMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String name = request.getParameter("name");
		MemberForm memberForm = dao.selectMemberForm(name);
		if (memberForm==null||memberForm.equals("")) {
			request.setAttribute("result", "不存在此会员，请重新登录！！！");
		} else if (!memberForm.getPassword().equals(request.getParameter("password").trim())) {
			request.setAttribute("result", "密码错误，请重新登录！！！");
		} else {	
			request.setAttribute("memberForm", memberForm);
		}
		return mapping.findForward("checkMember");
	}

	// 添加员工信息
	public ActionForward insertMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException {	
		MemberForm memberForm=(MemberForm)form;
		MemberForm formSelect=dao.selectMemberForm(memberForm.getName());
		if (formSelect == null || formSelect.equals("")) {
			dao.insertMember(memberForm);
			request.setAttribute("success", "注册成功");
		} else {
			request.setAttribute("success", "该会员名称已经存在！！！");
		}
		return mapping.findForward("operationMember");
	}
}
