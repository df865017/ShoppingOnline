<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="com.wy.domain.MemberForm"%>
<jsp:useBean id="dao" scope="page" class="com.wy.dao.MemberDao"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>会员登录结果</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">

<body>
<p>&nbsp;</p>
<div align="center">
  <p><strong>
    <%if(request.getAttribute("result")==null){%>
    <%
       MemberForm form=(MemberForm)request.getAttribute("memberForm");
       session.setAttribute("form",form);
    %>
<meta http-equiv="refresh" content="0;URL=member/index.jsp">
  <%}else{%>
      <%
	  String result=(String)request.getAttribute("result");
	  %>
	  <script language='javascript'>alert('<%=result%>');window.location.href='index.jsp';</script>

  <%}%> 
  </strong></p>
	
</div>
</body>
</html>
