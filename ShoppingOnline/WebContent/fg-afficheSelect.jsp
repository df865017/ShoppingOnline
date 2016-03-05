<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.wy.domain.AfficheForm"%>
<jsp:useBean id="dao" scope="page" class="com.wy.dao.AfficheDao"/>
<%AfficheForm form=dao.selectOneAffiche(Integer.valueOf(request.getParameter("id")));%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="css/css1.css">
<title></title>
</head>

<body bgcolor="#FFC7C6">
<table width="500" height="200" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="39" colspan="2">
      <p align="center"><font size="7" face="隶书">公告信息</font></td>
  </tr>

  <tr>
    <td width="31%" height="37"><div align="center"><font size="5">标题： </font></div></td>
    <td width="69%"><font size="5"><%=form.getName()%> </font></td>
  </tr>
  <tr>
    <td width="31%" height="32"><div align="center">公告内容：</div></td>
    <td width="69%" height="32"><%=form.getContent()%> </td>
  </tr>

<tr>
<td width="31%" height="27"><div align="center">发布时间： </div></td>
<td width="69%" height="27"><%=form.getIssueTime()%></td>
</tr>


<tr><td height="27" colspan="2" align="center">
<input type="button" name="wclose" value="关闭窗口" onClick="window.close()">
</td>
</tr>
</table>

</body>
</html>
