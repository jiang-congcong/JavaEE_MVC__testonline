<%@ page language="java" import="beans.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
  //String username = (String)session.getAttribute("username");
User user = (User)session.getAttribute("user");
if(user==null){
	response.sendRedirect("login1.jsp");
}
else{
String username = user.getUsername();
if(username==null){
	out.print("未登录，3秒之后重新登录");
	response.setHeader("refresh", "3;url='index.jsp'");
}

else{ %>
	
考生：<%=username %>

<h3>在线测试题</h3>
<form action="Submit" onsubmit="return confirm('确定提交吗？')">
		第1题：湖北省会是
		<input type="text" name="q1" />
		<br><br>
		第2题：宋朝开国皇帝是
		<br>
		<input type="radio" value="赵匡胤" name="q2">
		赵匡胤
		<input type="radio" value="朱元璋" name="q2">
		朱元璋
		<input type="radio" value="李渊" name="q2">
		李渊
		<br><br>
		第3题：四大名著有
		<br>
		<input type="checkbox" value="红楼梦" name="q3">
		红楼梦
		<input type="checkbox" value="水浒传" name="q3">
		水浒传
		<input type="checkbox" value="J2EE编程技术" name="q3">
		J2EE编程技术
		<br><br>
		<button type="submit">提交</button>
</form>
<%}%>
<%}%>

</body>
</html>