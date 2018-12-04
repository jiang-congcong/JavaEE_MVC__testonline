<%@ page language="java" import="java.util.*,beans.*" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%	List<User> user_list = (List<User>) session.getAttribute("user_list"); %>
<table border="1">
	<tr>
		<th>序号</th>	<th>用户名</th>	<th>密码</th>	<th colspan="2">操作</th>
	</tr>
	<%
		if (user_list != null) {
			for (User u : user_list) {
	%>
	<tr>
		<td>  <%=u.getId()%>  </td>
		<td>  <%=u.getUsername()%>  </td>
		<td>  <%=u.getPassword()%>  </td>
		<td>	  <a href="EditUser?id=<%=u.getId()%>">编辑</a>  </td>
		<td>	  <a href="DeleteUser?id=<%=u.getId()%>" onclick="return confirm('舍得删除吗？')">删除</a>  </td>
	</tr>
	<%
		} //end for
			session.removeAttribute("user_list");
		} //end if
		out.print("<br/>");
		out.print("<a href='Logout'>退出</a>");
	%>
</table>