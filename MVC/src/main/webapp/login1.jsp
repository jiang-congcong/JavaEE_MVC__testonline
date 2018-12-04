<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String errMsg=(String)session.getAttribute("err");
if( errMsg!=null ) { %>
<div style="color:red;"><%=errMsg %></div>
<% session.removeAttribute("err");
} %>
<form action="LoginServlet">
用户名：<input type="text" name="username"><br/>
密    码：&nbsp;&nbsp;&nbsp;<input type="password" name="password"><br/>
身    份：<input  type="radio" name="rad" value="stu" checked="checked"> 学生
<input type="radio" name="rad" value="tec" >老师<br/>

<input type="submit" value="登录">
<input type="button" value="注册" onclick="window.location='register.jsp'">
</form>
</body>
</html>