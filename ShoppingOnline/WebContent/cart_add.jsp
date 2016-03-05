<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*"%>
<%@ page import="com.wy.domain.SellGoodsForm"%>
<%
int goodsID=Integer.parseInt(request.getParameter("goodsId"));
float goodsPrice=Float.parseFloat(request.getParameter("price"));
SellGoodsForm sellGoodsForm=new SellGoodsForm();
sellGoodsForm.ID=goodsID;
sellGoodsForm.price=goodsPrice;
sellGoodsForm.number=1;
boolean flag=true;
Vector cart=(Vector)session.getAttribute("cart");
if(cart==null){
cart=new Vector();
}else{
for(int i=0;i<cart.size();i++){
   SellGoodsForm form=(SellGoodsForm)cart.elementAt(i);
   if(form.ID==sellGoodsForm.ID){
     form.number++;
     cart.setElementAt(form,i);
     flag=false;

   }
}
}
if(flag)
cart.add(sellGoodsForm);
session.setAttribute("cart",cart);

out.println("<script language='javascript'>alert('成功加入购物车!');window.close();</script>");
%>
