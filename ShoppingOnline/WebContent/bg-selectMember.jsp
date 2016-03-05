<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.wy.domain.MemberForm"%>
<%
List list=(List)request.getAttribute("list");
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxPage=Integer.parseInt((String)request.getAttribute("maxPage"));
int pageNumber=Integer.parseInt((String)request.getAttribute("pageNumber"));
int start=number*6;//开始条数
int over=(number+1)*6;//结束条数
int count=pageNumber-over;//还剩多少条记录
if(count<=0){
  over=pageNumber;
  }
%>
 <script Language="JavaScript">
 function deleteMember(date) {
  if(confirm("确定要删除吗？")){
    window.location="memberAction.do?action=4&id="+date;
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
            <td><div align="center"><strong>会员信息的查询</strong></div></td>
          </tr>
        </table>
        <br>
				 
	    <table width="71%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">

	    <tr>
          <td width="14%" height="25"><div align="center">编号</div></td>
          <td width="14%"><div align="center">会员账号</div></td>
          <td width="14%"><div align="center">会员姓名</div></td>
           <td width="14%"><div align="center">会员年龄</div></td>

    <td width="38%"><div align="center">操作</div></td>
        </tr>
        <%for(int i=start;i<over;i++){
      MemberForm form=(MemberForm)list.get(i);
          %>
        <tr bgcolor="#FFFFFF">
          <td height="30"><div align="center"><%=form.getId()%></div></td>
          <td><div align="center"><%=form.getName()%></div></td>
          <td><div align="center"><%=form.getReallyName()%></div></td>
          <td><div align="center"><%=form.getAge()%>岁</div></td>
        <td><div align="center">

		 <a href="memberAction.do?action=3&id=<%=form.getId()%>">详细信息</a>&nbsp;&nbsp;&nbsp;&nbsp;

		 <a href="javascript:deleteMember('<%=form.getId()%>')">删除</a>

		  </div></td>
        </tr>
        <%}%>
      </table><br>
	   <table width="71%"  border="0" align="center" cellpadding="0" cellspacing="0">
   <tr align="center">
    <td width="17%">共为<%=maxPage%>页</td>
			<td width="22%">共有<%=pageNumber%>条记录</td>
            <td width="26%">当前为第<%=number+1%>页</td>
    <td width="19%"><%if((number+1)==1){%> 上一页<%}else{%><a href="memberAction.do?action=2&i=<%=number-1%>">上一页</a></td><%}%>
            <td width="16%"><%if(maxPage<=(number+1)){%>下一页<%}else{%><a href="memberAction.do?action=2&i=<%=number+1%>">下一页</a></td><%}%>



   </tr>
 </table>
		
	</table>	
<jsp:include page="bg-down.jsp" flush="true" />




</body>
</html>
