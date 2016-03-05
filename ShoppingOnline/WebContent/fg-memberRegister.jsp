<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%><head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>电子商城</title>
</head>

<html:html>
<link href="css/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
function checkEmpty(memberForm){
for(i=0;i<memberForm.length;i++){
if(memberForm.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}
//新加入的验证E-mail地址是否正确209-05-25
var vemail=memberForm.email.value;
var regExp=/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
if(!regExp.test(vemail)){
	window.alert("您输入的邮箱地址不正确！");return false;
}
if(document.memberForm.password.value!=document.memberForm.passwordOne.value){
window.alert("您两次输入的密码不一致，请重新输入");
return false;
}
if(isNaN(document.memberForm.age.value)){
window.alert("年龄只能为数字");
return false;
}
}
</script>
<body>
	<jsp:include page="fg-top.jsp" flush="true" />
	<table width="766" border="0" align="center" cellpadding="0"
		cellspacing="0" bordercolor="#000000">
		<tr>
			<td bgcolor="#F5F5F5" align="center"><img src="image/fg1.jpg"
				width="752" height="39"> <html:form
					action="memberAction.do?action=0"
					onsubmit="return checkEmpty(memberForm)">

					<table width="270" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="107" height="35">
								<div align="right">会员名称：</div>
							</td>
							<td width="163">
								<div align="left">
									<input type="text" id="name" name="name">
								</div>
							</td>
						</tr>
						<tr>
							<td height="35">
								<div align="right">会员密码：</div>
							</td>
							<td>
								<div align="left">
									<input type="password"  name="password">
								</div>
							</td>
						</tr>
						<tr>
							<td height="35">
								<div align="right">密码确认：</div>
							</td>
							<td>
								<div align="left">
									<input type="password" name="passwordOne">
								</div>
							</td>
						</tr>
						<tr>
							<td height="35">
								<div align="right">真实姓名：</div>
							</td>
							<td>
								<div align="left">
									<input type="text" id="reallyName" name="reallyName">
								</div>
							</td>
						</tr>
						<tr>
							<td height="35">
								<div align="right">年龄：</div>
							</td>
							<td>
								<div align="left">
									<input type="text" id="age" name="age">
								</div>
							</td>
						</tr>
						<tr>
							<td height="35">
								<div align="right">职业：</div>
							</td>
							<td>
								<div align="left">
									<input type="text" id="profession" name="profession">
								</div>
							</td>
						</tr>
						<tr>
							<td height="35">
								<div align="right">Email地址：</div>
							</td>
							<td>
								<div align="left">
									<input type="text" id="email" name="email">
								</div>
							</td>
						</tr>
						<tr>
							<td height="35">
								<div align="right">找回密码问题：</div>
							</td>
							<td>
								<div align="left">
									<input type="text" id="question" name="question">
								</div>
							</td>
						</tr>
						<tr>
							<td height="35">
								<div align="right">答案：</div>
							</td>
							<td>
								<div align="left">
									<input type="text" id="result" name="result">
								</div>
							</td>
						</tr>
					</table>
					<br>
					<input type="image" class="input1" src="image/save.jpg" width="51"
						height="20">
&nbsp;&nbsp;
<a href="#" onClick="javascript:memberForm.reset()"><img
						src="image/clear.gif">
					</a>
&nbsp;&nbsp;
<a href="#" onClick="javasrcipt:history.go(-1)"><img
						src="image/back.gif">
					</a>
				</html:form>




				<p>&nbsp;</p></td>
		</tr>
	</table>
	<jsp:include page="fg-down.jsp" flush="true" />
</body>
</html:html>
