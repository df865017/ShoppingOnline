<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>

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
 

  
    <td width="559" valign="top" bgcolor="#FFFFFF" align="center">
   
   
   
   <p>&nbsp;</p>

  <p><strong><%=request.getAttribute("success")%></strong></p>
<meta http-equiv="refresh" content="3;URL=index.jsp">
      <p>&nbsp;</p>
   
	
	</td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
