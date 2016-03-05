<%@ page contentType="text/html; charset=gb2312"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>电子商城</title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css">
<%@page import="com.wy.domain.MemberForm"%>
<jsp:useBean id="dao" scope="page" class="com.wy.dao.MemberDao" />
<%
	request.setCharacterEncoding("gb2312");
	String password = request.getParameter("password").trim();
	Integer id = Integer.valueOf(request.getParameter("id"));
	boolean change = dao.updatePassword(password, id);
%>
<body>
	<jsp:include page="fg-top.jsp" flush="true" />
	<table width="766" border="0" align="center" cellpadding="0"
		cellspacing="0" bordercolor="#000000">
		<tr>
			<td bgcolor="#FFFFFF" align="center"><img src="image/fg2.jpg"
				width="752" height="45">






				<p>
					<strong> <%
 	if (change) {
 %> 密码修改成功！！！ <%
 	} else {
 %> 密码修改失败！！！ <%
 	}
 %> </strong>
				</p>
				<meta http-equiv="refresh" content="3;URL=index.jsp"></td>
		</tr>
	</table>
	<jsp:include page="fg-down.jsp" flush="true" />
</body>
</html>
