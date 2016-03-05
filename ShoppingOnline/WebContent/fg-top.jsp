<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<%@page import="com.wy.domain.MemberForm"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
</head>
<%
  String memberlink="connection.jsp";
  String orderlink="connection.jsp";
  String shoppinglink="connection.jsp";
  MemberForm form=null;
  if(session.getAttribute("form")!=null){
  form=(MemberForm)session.getAttribute("form");
  memberlink="memberAction.do?action=5&id="+form.getId();
  orderlink="cart_detail.jsp";
  shoppinglink="cart_see.jsp";
  }
%>

<body>
	<table width="766" height="56" border="0" align="center"
		cellpadding="0" cellspacing="0" background="image/fg_top02.jpg">
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<table width="766" border="0" align="center" cellpadding="0"
		cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF"
		bordercolordark="#819BBC" background="image/fg_top03.jpg">
		<tr align="center">
			<td width="117" height="31"
				onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a href="index.jsp"
				class="a4">首页</a></td>
			<td width="117"
				onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a
				href="bg-resultTen.jsp" class="a4">销售排行</a></td>
			<td width="117"
				onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a
				href="goodsAction.do?action=14&mark=0" class="a4">新品上架</a></td>
			<td width="117"
				onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a
				href="goodsAction.do?action=15&mark=1" class="a4">特价商品</a></td>
			<td width="117"
				onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a href="<%=orderlink%>"
				class="a4">查看订单</a></td>
			<td width="117"
				onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a href="<%=shoppinglink%>"
				class="a4">购物车</a></td>
			<td width="117"
				onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a href="<%=memberlink%>"
				class="a4">会员修改</a></td>
			<td width="117"
				onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a
				href="bg-land.jsp" class="a4">进入后台</a>
			</td>
		</tr>
	</table>
	<table width="766" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><img src="image/fg_top05.jpg" width="766" height="117">
			</td>
		</tr>
	</table>

</body>
</html>
