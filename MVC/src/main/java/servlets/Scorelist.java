package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import beans.Userscore;

/**
 * Servlet implementation class Scorelist
 */
public class Scorelist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	protected int upsort(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int id=0;
		String username1 = null;
		int score1=0;
		//ServletContext application = getServletContext();
		HttpSession session=request.getSession();
		List<Userscore> score_list = (List<Userscore>) session.getAttribute("score_list");
		
		Comparator_score comparator=new Comparator_score();
		Collections.sort(score_list, comparator);
		
		out.print("<h2>成绩榜</h2>");

		if(score_list==null){
			out.print("<h3>没有成绩</h3>");
		}
		else{
			out.print("\n");
			out.print("<table border=\"1\">\r\n" + 
					"	<tr>\r\n" + 
					"		<th>学号</th>	<th>用户名</th>  <th colspan=\"2\"> 成绩 </th>\r\n" + 
					"	</tr>");
			
			if (score_list != null) {
				for (Userscore u : score_list) {
			      out.print("<tr>");
			      out.print("<td>"+u.getId()+"</td>");			      
			      out.print("<td>"+u.getUsername()+"</td>");		      
			      out.print("<td>"+u.getScore()+"</td>");
			      out.print("</tr>");
				}
			
			}
			
			
		}
		
		return 0;
		
		
	}
	
		
    public Scorelist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		int id=0;
		String username1 = null;
		int score1=0;
		//ServletContext application = getServletContext();
		HttpSession session=request.getSession();
		
		User u2 = (User)session.getAttribute("user");
		String flag =(String) session.getAttribute("flag");
		
		
		if(u2!=null||flag!=null) {
		
		List<Userscore> score_list = (List<Userscore>) session.getAttribute("score_list");
		
		out.print("<h2>成绩榜</h2>");

		if(score_list==null){
			out.print("<h3>没有成绩</h3>");
		}
		else{
			out.print("\n");
			out.print("<table border=\"1\">\r\n" + 
					"	<tr>\r\n" + 
					"		<th>学号</th>	<th>用户名</th>  <th colspan=\"2\"> 成绩 </th>\r\n" + 
					"	</tr>");
			
			if (score_list != null) {
				for (Userscore u : score_list) {
			      out.print("<tr>");
			      out.print("<td>"+u.getId()+"</td>");			      
			      out.print("<td>"+u.getUsername()+"</td>");		      
			      out.print("<td>"+u.getScore()+"</td>");
			      out.print("</tr>");
				}
			
			}
			
			
		}
		
	out.print("<button type='button'"+ "onclick="+"window.location.href='scorelist_up'"+">"+"升序"+"</button>"+"&nbsp;&nbsp;&nbsp;&nbsp;");	
	out.print("<button type='button'"+ "onclick="+"window.location.href='scorelist_down'"+">"+"降序"+"</button>");
	out.print("&nbsp;&nbsp;&nbsp;&nbsp;"+"<button type='button'"+ "onclick="+"window.location.href='Logout'"+">"+"退出"+"</button>");
	out.print("\n");
	
		}
		
		
		else {
			//out.print("Scorelist");
			response.sendRedirect("login1.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
