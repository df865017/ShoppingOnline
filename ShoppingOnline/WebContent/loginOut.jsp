<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%
         session.invalidate();
 out.println("<script>parent.location.href='index.jsp';</script>");
%>

