<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.wy.domain.GoodsForm" %>
<jsp:useBean id="newGood" scope="page" class="com.wy.dao.GoodsDao"/>
<%List nowList =newGood.selectMark(Integer.valueOf("0"));%>
<%List freeList =newGood.selectMark(Integer.valueOf("1"));%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>电子商城</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css"> 
<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="207" valign="top" bgcolor="#F5F5F5">
    <!--左侧01-->
    <jsp:include page="fg-left.jsp" flush="true"/></td>
    <td width="559" valign="top" bgcolor="#FFFFFF">
    <!--右侧01-->	
    <jsp:include page="fg-goodSorts.jsp" flush="true"/>	
     <div align="center">
        <%if(session.getAttribute("form")!=null){%>
        <br>
        <img src="image/fg_right02.jpg">
    </div>
     <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
        <tr> 
		  <%
              int free=2;
              if(freeList.size()<2){
              free=freeList.size();
              }

              for(int i=0;i<free;i++)
              {
                GoodsForm newGoods=(GoodsForm)freeList.get(i);
           %>
            <td valign="top">			<table width="257" height="136" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#999999">
              <tr>
                <td width="33%" height="80" rowspan="5" bgcolor="#FFFFFF"><input name="pricture<%=i%>" type="image" src="<%=newGoods.getPriture()%>" width="140" height="126"></td>
                <td width="67%" height="20" bgcolor="#FFFFFF"><div align="center"><%=newGoods.getName()%></div></td>
              </tr>
              <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center" style="text-decoration:line-through;color:#910402">原价：<%=newGoods.getNowPrice()%>元</div></td>
              </tr>
              <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center"><font color="#F14D83">现价：<%=newGoods.getFreePrice()%>元</font></div></td>
              </tr>
              <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center"><%=newGoods.getIntroduce()%></div></td>
              </tr>
              <tr>
                <td height="13" bgcolor="#FFFFFF"><div align="center" class="linkBlack"><a href="#" onClick="window.open('goodsAction.do?action=16&id=<%=newGoods.getId()%>','','width=500,height=200');">查看详细内容</a></div></td>
              </tr>
            </table></td>
            <%}%>
        </tr>
</table>
    
    <div align="center">
    <%}%>
    <img src="image/fg_right01.jpg">
</div>
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
    
          <tr>
            <td height="215" valign="top">
			<%
              int now=5;
              if(nowList.size()<5){
              now=nowList.size();
              }
             if(session.getAttribute("form")!=null){
			 now=3;
             }
              for(int i=0;i<now;i++)
              {
                GoodsForm newGoods=(GoodsForm)nowList.get(i);
                %><table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td>				<table width="99%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"   >
                  <tr>
                    <td height="150" bordercolor="#666666" >
                      <table width="96%"  border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC" >
                        <tr>
                          <td width="36%" rowspan="4" bgcolor="#FFFFFF"><div align="center">
                              <input name="pricture<%=i%>" type="image" src="<%=newGoods.getPriture()%>" width="110" height="100">
                          </div></td>
                          <td width="64%" bgcolor="#FFFFFF"><div align="center"><%=newGoods.getName()%></div></td>
                        </tr>
                        <tr>
                          <td bgcolor="#FFFFFF"><div align="center"><font color="#F14D83">单价：<%=newGoods.getNowPrice()%>元</font></div></td>
                        </tr>
                        <tr>
                          <td bgcolor="#FFFFFF"><div align="center"><%=newGoods.getIntroduce()%></div></td>
                        </tr>
                        <tr>
                          <td  bgcolor="#FFFFFF" class="linkBlack"  align="center">
                              <%if(session.getAttribute("form")!=null||session.getAttribute("id")!=null){%>
                              <a href="#" onClick="window.open('goodsAction.do?action=16&id=<%=newGoods.getId()%>','','width=500,height=200');">查看详细内容</a>
                              <%}else{%>
                           登录后才能购买</td>
                          <%}%>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table>
			<%}%>
			
			
			
			</td>
			 
		       
          </tr>
</table>

	</td>
  </tr>
</table>

	

</body>
</html>
<jsp:include page="fg-down.jsp" flush="true"/>