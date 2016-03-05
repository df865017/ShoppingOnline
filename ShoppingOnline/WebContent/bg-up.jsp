<%@ page contentType="text/html; charset=gb2312"%>
<jsp:useBean id="countTime" class="com.wy.tool.CountTime" scope="request"/>
<%@ page import="com.wy.domain.ManagerForm"%>
<%
if(session.getAttribute("manager")==null){
out.print("<script language=javascript>alert('您已经与服务器断开连接，请重新登录！');window.location.href='bg-land.jsp';</script>");
}else{
ManagerForm manager=(ManagerForm)session.getAttribute("manager");
%>
<table width="788" height="66" border="0" align="center" cellpadding="0" cellspacing="0" background="image/bg_01.jpg">
  <tr>
    <td valign="top"><table width="770" border="0" align="center">
      <tr >
        <td width="413" height="53" valign="bottom"><div align="right"></div></td>
        <td width="347" valign="bottom" align="right"><font color="#FFFFFF"><a href="goodsAction.do?action=0" class="a2">商品查询</a> | <a href="bigTypeAction.do?action=0" class="a2">大类别查询</a> | <a href="smallTypeAction.do?action=0" class="a2">小类别查询</a> | <a href="orderAction.do?action=0" class="a2">返回首页</a></font></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="788" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#000000">
  <tr>
    <td width="15" height="25">&nbsp;</td>
    <td width="579"><font color="#FFFFFF">当前登录：<%=manager.getAccount()%></font></td>
    <td width="194"><font color="#FFFFFF">今天是<%=countTime.currentlyTime()%></font></td>
  </tr>
</table>
<%}%>