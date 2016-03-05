<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.wy.domain.GoodsForm"%>
<%
GoodsForm form=(GoodsForm)request.getAttribute("form");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="managerGoods/css/css.css">
<title></title>
<style type="text/css">
<!--
body {
	background-color: #fafafa;
}

td {
	font-size: 9pt;	color: #000000;
}
.style1 {
	color: #FF9900;
	font-weight: bold;
}


-->
</style></head>

<body>
<form name="form" method="post" action="cart_add.jsp">


<div align="center">
  <p class="style1">查看商品清单</p>
</div>
<table width="400"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
  <tr>
    <td width="36%" rowspan="4" height="120"><div align="center">
        <input name="pricture" type="image" src="<%=form.getPriture()%>" width="110" height="100">
    </div></td>
    <td width="64%" height="30"><div align="center">
      <table width="71%" height="20"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td>货品名称：<%=form.getName()%> <input type="hidden" name="goodsId" value="<%=form.getId()%>" /></td>
        </tr>
      </table>
    </div></td>
  </tr>
  <tr>
    <td height="30"><div align="center">
        <table width="71%"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><%if(form.getMark().toString().equals("1")){%>
特&nbsp;&nbsp;&nbsp;&nbsp;价：<%=form.getFreePrice()%>元<input  type="hidden" name="price" value="<%=form.getFreePrice()%>"/>
<%}else{%>
现&nbsp;&nbsp;&nbsp;&nbsp;价：<%=form.getNowPrice()%>元<input type="hidden" name="price" value="<%=form.getNowPrice()%>"/>
<%}%></td>
      </tr>
    </table>
</div></td>
  </tr>
  <tr>
    <td height="30"><div align="center">
      <table width="71%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td>简&nbsp;&nbsp;&nbsp;&nbsp;介：<%=form.getIntroduce()%> </td>
        </tr>
      </table>
    </div></td>
  </tr>
  <tr align="center">
    <td height="30">
	
	<img src="image/1.jpg" onClick="window.close()">
	
	&nbsp;&nbsp;<input type="image" src="image/2.jpg" name="Submit" value="放入购物车"></td>

  </tr>
</table>
</form>
</body>
</html>
