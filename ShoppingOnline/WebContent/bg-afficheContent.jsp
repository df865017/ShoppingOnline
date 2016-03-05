<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.wy.domain.AfficheForm"%>
<%AfficheForm affiche=(AfficheForm)request.getAttribute("affiche");%>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
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
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF"> <br>
	
        <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
          <tr>
            <td><div align="center"><strong>查看公告信息</strong></div></td>
          </tr>
        </table>
        <br>

	 
        <table width="90%" height="243"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
          <tr>
            <td width="23%" height="30"><div align="center">公告标题</div></td>
            <td width="77%" bgcolor="#FFFFFF">&nbsp;<%=affiche.getName()%></td>
          </tr>
            <tr>
            <td width="23%" height="208"><div align="center">公告内容</div></td>
            <td width="77%" bgcolor="#FFFFFF">&nbsp;<%=affiche.getContent()%></td>
          </tr>
      </table>
    
	    <table width="82%" height="30"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td>&nbsp;</td>
            <td><div align="right"><a href="javascript:history.go(-1)">返回</a></div></td>
          </tr>
        </table>

    </td>
  </tr>
</table>

<jsp:include page="bg-down.jsp" flush="true" />












</body>
</html>
