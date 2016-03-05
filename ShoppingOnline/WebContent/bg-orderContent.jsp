<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.wy.domain.OrderForm"%>
<%@page import="com.wy.domain.OrderDetailForm"%>
<%@page import="com.wy.domain.GoodsForm"%>
<jsp:useBean id="order" scope="page" class="com.wy.dao.OrderDao"/>
<jsp:useBean id="goods" scope="page" class="com.wy.dao.GoodsDao"/>
<jsp:useBean id="orderDetail" scope="page" class="com.wy.dao.OrderDetailDao"/>
<%OrderForm orderForm=(OrderForm)request.getAttribute("orderForm");%>
<%List list=(List)request.getAttribute("orderDetailList");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>电子商城的后台</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>

<jsp:include page="bg-up.jsp" flush="true"/>


<table width="788" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="170"  valign="top"><jsp:include page="bg-left.jsp" flush="true" /></td>
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF"> <br>
        <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
          <tr>
            <td align="center"><strong>订单号为：<%=orderForm.getNumber()%>的详细信息</strong></td>
          </tr>
        </table>
        <br>

<table width="76%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#DCDCDC">
      <tr align="center" >
        <td width="26%" height="25">会员账号</td>
        <td width="22%" bgcolor="#FFFFFF"><%=orderForm.getName()%></td>
        <td width="26%">会员姓名</td>
        <td width="22%" bgcolor="#FFFFFF"><%=orderForm.getReallyName()%></td>
      </tr>
      <tr  align="center">
        <td height="25">送货电话</td>
        <td bgcolor="#FFFFFF"><%=orderForm.getTel()%></td>
        <td>送货地址</td>
        <td bgcolor="#FFFFFF"><%=orderForm.getAddress()%></td>
      </tr>
      <tr  align="center">
        <td height="25">付款方式</td>
        <td bgcolor="#FFFFFF"><%=orderForm.getSetMoney()%></td>
        <td>运送方式</td>
        <td bgcolor="#FFFFFF"><%=orderForm.getPost()%></td>
      </tr>
      <tr align="center">
        <td height="25" >备注信息</td>
        <td bgcolor="#FFFFFF"><%=orderForm.getBz()%></td>
        <td>订货时间</td>
        <td bgcolor="#FFFFFF"><%=orderForm.getCreaTime()%></td>
      </tr>
    </table>
	<br>
	    <strong>商品详细信息</strong>	  <br><br>
	    <table width="74%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#DCDCDC">
          <tr>
            <td><div align="center">商品名称</div></td>
            <td><div align="center">商品数量</div></td>
            <td><div align="center">商品价格</div></td>
          </tr>
          <%
          float sum=0;
          for(int i=0;i<list.size();i++){
            OrderDetailForm form=(OrderDetailForm)list.get(i);
            sum=sum+form.getPrice()*form.getNumber();
       
            %>
          <tr bgcolor="#FFFFFF">
            <td><div align="center"><%=goods.selectOneGoods(form.getGoodsId()).getName()%></div></td>
            <td><div align="center"><%=form.getNumber()%></div></td>
            <td><div align="center"><%=form.getPrice()%>元</div></td>
          </tr><%}%>
      </table>
	    <br>
    总金额:<%=sum%><br>
    <table width="76%" height="19"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="72%">
              <div align="left">
                <%if(orderForm.getSign().equals("1")){%>
                已经出货
                <%}else{%>
                没有出货
                <%}%>
              </div></td><td width="28%"><div align="right"><a href="javascript:history.go(-1)">返回</a></div></td>
      </tr>
    </table>



    </td>
  </tr>
</table>

<jsp:include page="bg-down.jsp" flush="true" />

</body>
</html>
