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
String username=(String)session.getAttribute("username");
if(username!=null&&!username.isEmpty()) { %>
你已经登录，欢迎<%=session.getAttribute("username") %>
<% }
else{
out.print("你还没有登录，3秒后自动跳往登录页面");
response.setHeader("refresh", "3;url=login.jsp");
} %>

</body>
</html>