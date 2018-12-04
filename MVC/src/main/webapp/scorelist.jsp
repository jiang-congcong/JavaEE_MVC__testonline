<%@ page language="java" import="java.util.*,beans.*" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%	List<Userscore> score_list = (List<Userscore>) session.getAttribute("score_list"); %>

<table border="1">
	<tr>
		<th>学号</th>	<th>用户名</th>  <th colspan="2"> 成绩 </th>
	</tr>
	<%
		if (score_list != null) {
			for (Userscore u : score_list) {
	%>
	<tr>
		<td>  <%=u.getId()%>  </td>
		<td>  <%=u.getUsername()%>  </td>
		<td>  <%=u.getScore()%>  </td>
	</tr>
	<%
		} //end for		
			session.removeAttribute("score_list");
		} //end if
	%>
</table>
<br/>

<div style="float: left;width: 70px;"><a href="#">升序</a></div>
<div style="float: left;width: 70px;"><a href="#">降序</a></div>