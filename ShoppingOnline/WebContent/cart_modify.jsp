<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*"%>
<%@ page import="com.wy.domain.SellGoodsForm"%>
<%
Vector cart=(Vector)session.getAttribute("cart");
Vector newcart=new Vector();
for(int i=0;i<cart.size();i++){
	String number=request.getParameter("num"+i);
	SellGoodsForm mygoodselement=(SellGoodsForm)cart.elementAt(i);
	String num=request.getParameter("num"+i);
	try{
	int newnum=Integer.parseInt(num);
	mygoodselement.number=newnum;
	if(newnum!=0){
		newcart.addElement(mygoodselement);}
	}catch(Exception e){
		out.println("<script language='javascript'>alert('您输入的数量不是有效的整数!');history.back();</script>");
		return;
	}
}
session.setAttribute("cart",newcart);
response.sendRedirect("cart_see.jsp");
%>
