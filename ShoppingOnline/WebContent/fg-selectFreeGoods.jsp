<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.util.*"%>
<%@page import="com.wy.domain.GoodsForm"%>
<jsp:useBean id="goods" scope="page" class="com.wy.dao.GoodsDao"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>电子商城</title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css"> 
<%List freeList =(List)request.getAttribute("list");%>
<%
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxPage=Integer.parseInt((String)request.getAttribute("maxPage"));
int pageNumber=Integer.parseInt((String)request.getAttribute("pageNumber"));
int start=number*4;//开始条数
int over=(number+1)*4;//结束条数
int count=pageNumber-over;//还剩多少条记录
if(count<=0){
  over=pageNumber;
  }
%> 
<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="207" valign="top" bgcolor="#F5F5F5">
    <!--左侧01-->
    <jsp:include page="fg-left.jsp" flush="true"/></td>
    <td width="559" valign="top" bgcolor="#FFFFFF" align="center">
    	<jsp:include page="fg-goodSorts.jsp" flush="true"/>	
    <table width="546" height="42" border="0" align="center" cellpadding="0" cellspacing="0" background="image/fg_right02.jpg">
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
	

	      <%
          
             
              for(int i=start;i<over;i++)
              {
                GoodsForm freeGoods=(GoodsForm)freeList.get(i);
                %>
		
			 
			 <br> 
			 <table width="99%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">

              <tr>
                <td width="36%" rowspan="5" height="120"><div align="center">
                  <input name="pricture<%=i%>" type="image" src="<%=freeGoods.getPriture()%>" width="140" height="126">
                </div></td>
                <td width="64%" height="30"><div align="center"><%=freeGoods.getName()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center" style="text-decoration:line-through;color:#FF0000">原价：<%=freeGoods.getNowPrice()%>元</div></td>
              </tr>
			     <tr>
                <td height="30"><div align="center">特价：<%=freeGoods.getFreePrice()%>元</div></td>
              </tr>
              <tr>
                <td height="30"><div align="center"><%=freeGoods.getIntroduce()%></div></td>
              </tr>
              <tr>
               <td height="30" align="center">  <%if(session.getAttribute("form")!=null||session.getAttribute("id")!=null){%>
               <a href="#" onClick="window.open('goodsAction.do?action=16&id=<%=freeGoods.getId()%>','','width=500,height=200');">查看详细内容</a>				
			  <%}else{%>登录后才能购买<%}%></td>
              </tr>
            </table>
			<%}%><br>
        
		    <div align="center">
		      <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
                <tr align="center">
                  <td width="13%">共为<%=maxPage%>页</td>
                  <td width="18%">共有<%=pageNumber%>条记录</td>
                  <td width="26%">当前为第<%=number+1%>页</td>
                  <td width="15%"><%if((number+1)==1){%>
      上一页
        <%}else{%>
        <a href="goodsAction.do?action=15&mark=1&i=<%=number-1%>">上一页</a></td>
                  <%}%>
                  <td width="14%"><%if(maxPage<=(number+1)){%>
      下一页
        <%}else{%>
        <a href="goodsAction.do?action=15&mark=1&i=<%=number+1%>">下一页</a></td>
                  <%}%><td width="14%"><div align="center"><a href="#" onClick="javasrcipt:history.go(-1);">返回</a></div></td>
                </tr>
				
              </table>
              	</td>
  			</tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
