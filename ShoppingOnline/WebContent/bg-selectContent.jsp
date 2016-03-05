<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.wy.domain.MemberForm"%>


<%
MemberForm form=(MemberForm)request.getAttribute("form");

%>



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
            <td><div align="center"><strong>查看会员的详细情况</strong></div></td>
          </tr>
        </table>
        <br>

 <table width="71%" height="130"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
          <tr>
            <td width="20%" height="26"><div align="center">数据编号</div></td>
            <td width="31%" bgcolor="#FFFFFF"><div align="center"><%=form.getId()%></div></td>
            <td width="20%"><div align="center">会员账号</div></td>
            <td width="31%" bgcolor="#FFFFFF"><div align="center"><%=form.getName()%></div></td>
          </tr>
          <tr>
            <td height="25"><div align="center">会员姓名</div></td>
            <td bgcolor="#FFFFFF"><div align="center"><%=form.getReallyName()%></div></td>
            <td><div align="center">会员年龄</div></td>
            <td bgcolor="#FFFFFF"><div align="center"><%=form.getAge()%>岁</div></td>
          </tr>
          <tr>
            <td height="27"><div align="center">会员职业</div></td>
            <td bgcolor="#FFFFFF"><div align="center"><%=form.getProfession()%></div></td>
            <td><div align="center">电子邮件</div></td>
            <td bgcolor="#FFFFFF"><div align="center"><%=form.getEmail()%></div></td>
          </tr>

          <tr>
           <td height="27"><div align="center">问&nbsp;&nbsp;&nbsp;&nbsp;题</div></td>
            <td bgcolor="#FFFFFF"><div align="center"><%=form.getQuestion()%></div></td>
            <td><div align="center">答&nbsp;&nbsp;&nbsp;&nbsp;案</div></td>
            <td bgcolor="#FFFFFF"><div align="center"><%=form.getResult()%></div></td>
          </tr>
      </table>
        <table width="71%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="87%" height="29">&nbsp;</td>
            <td width="13%"> <a href="javascript:history.back();">返回</a></td>
          </tr>
        </table>





		
</table>	
<jsp:include page="bg-down.jsp" flush="true" />

























</body>
</html>
