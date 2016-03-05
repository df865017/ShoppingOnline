<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.wy.domain.OrderForm"%>
<%
List list=(List)request.getAttribute("list");
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxPage=Integer.parseInt((String)request.getAttribute("maxPage"));
int pageNumber=Integer.parseInt((String)request.getAttribute("pageNumber"));
int start=number*6;//开始条数
int over=(number+1)*6;//结束条数
int count=pageNumber-over;//还剩多少条记录
if(count<=0){
  over=pageNumber;
  }
%>
 <script Language="JavaScript">
 function deleteOrder(date) {
  if(confirm("确定要删除吗？")){
    window.location="orderAction.do?action=2&number="+date;
	}
  }
 </script>
 

 
 
 
 
 
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
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF">
	
	
	
<br>
	

	<table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
      <tr>
        <td><div align="center"><strong>订单的查询</strong></div></td>
      </tr>
    </table>	<br>
	    <table width="96%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="CCCCCC">

	    <tr bgcolor="#DCDCDC">
          <td width="15%" height="25"><div align="center">编号</div></td>
          <td width="14%"><div align="center">真实姓名</div></td>

         <td width="16%"><div align="center">是否出货</div></td>
        <td width="26%"><div align="center">订货时间</div></td>
   <td width="29%"><div align="center">操作</div></td>
        </tr>
        <%for(int i=start;i<over;i++){
      OrderForm form=(OrderForm)list.get(i);
          %>
        <tr align="center" bgcolor="#FFFFFF">
          <td height="25"><%=form.getNumber()%></td>
          <td><%=form.getReallyName()%></td>

		  <td><%if(form.getSign().equals("0")){%>
                    <a href="orderAction.do?action=0&sign=<%=form.getSign()%>">否</a>
                    <%}else{%>
                    <a href="orderAction.do?action=0&sign=<%=form.getSign()%>">是</a>
          <%}%></td>
		  <td><%=form.getCreaTime()%></td>
        <td><a href="orderAction.do?action=3&number=<%=form.getNumber()%>">详细信息</a>
                             &nbsp;&nbsp;
	     <%if(form.getSign().equals("1")){%>
		 已出
		 <%}else if(request.getParameter("sign")==null){%>
		  <a href="orderAction.do?action=1&number=<%=form.getNumber()%>">出货</a>
		 <%}else{%>
		  <a href="orderAction.do?action=1&sign=<%=request.getParameter("sign")%>&number=<%=form.getNumber()%>">出货</a>
		 <%}%>
		 &nbsp;&nbsp;

		 <a href="javascript:deleteOrder('<%=form.getNumber()%>')">删除</a></td>
        </tr>
        <%}%>
      </table><br>
<%if(request.getParameter("sign")==null){%>
  <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr align="center">
    <td width="17%">共为<%=maxPage%>页</td>
    <td width="22%">共有<%=pageNumber%>条记录</td>
    <td width="26%">当前为第<%=number+1%>页</td>
    <td width="19%"><%if((number+1)==1){%> 上一页<%}else{%><a href="orderAction.do?action=0&i=<%=number-1%>">上一页</a></td><%}%>
    <td width="16%"><%if(maxPage<=(number+1)){%>下一页<%}else{%><a href="orderAction.do?action=0&i=<%=number+1%>">下一页</a></td><%}%>
   </tr>
 </table>
<%}else{%>
 <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr align="center">
    <td width="14%">共为<%=maxPage%>页</td>
    <td width="18%">共有<%=pageNumber%>条记录</td>
    <td width="22%">当前为第<%=number+1%>页</td>
    <td width="16%"><%if((number+1)==1){%> 上一页<%}else{%><a href="orderAction.do?action=0&i=<%=number-1%>&sign=<%=request.getParameter("sign")%>">上一页</a></td><%}%>
    <td width="12%"><%if(maxPage<=(number+1)){%>下一页<%}else{%><a href="orderAction.do?action=0&i=<%=number+1%>&sign=<%=request.getParameter("sign")%>">下一页</a></td><%}%>
    <td width="18%"><a href="orderAction.do?action=0">返回</a></td>
   </tr>
 </table>


<%}%>	</td>
  </tr>
</table><jsp:include page="bg-down.jsp" flush="true" />

</body>
</html>
