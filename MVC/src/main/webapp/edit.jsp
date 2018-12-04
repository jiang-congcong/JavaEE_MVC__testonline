<%@ page language="java" import="beans.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% User user=(User)session.getAttribute("user"); %>
<form action="SaveUser">
序号<input type="text" name="id" value="<%=user.getId() %>" readonly="readonly" style="background-color:lightgrey;"> <br/>
用户名<input type="text" name="username" value="<%=user.getUsername() %>" > <br/>
密码<input type="text" name="password" value="<%=user.getPassword() %>" ><br/>
<button type="submit">提交</button>
</form>
<%
String err=(String)session.getAttribute("err"); 
if(err!=null){
	out.print("<div style='color:red'>"+err+"</div>");
	session.removeAttribute("err");
}	
%>