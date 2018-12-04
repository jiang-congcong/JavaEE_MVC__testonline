package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.UserDAO;

/**
 * Servlet implementation class Find
 */
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		User u1 = (User)session.getAttribute("user");
		PrintWriter out = response.getWriter();
		String flag =(String) session.getAttribute("flag"); 
		
		//boolean 
		//session.setAttribute("user_list", new UserDAO().getAllUsers());
		//response.sendRedirect("admin.jsp");
		
		if(u1!=null||flag!=null)  {
		String s1 = request.getParameter("sco1");
		String s2 = request.getParameter("sco2");		
		String name = request.getParameter("name");
		if(name.length()>0) {
			session.setAttribute("score_list", new UserDAO().getUserByUsername(name));
			//response.sendRedirect("http://localhost:8080/MVC/scorelist.jsp");
			response.sendRedirect("Scorelist");	
		}
		
		else if(s1.length()>0&&s2.length()>0) {
			int sc1 = Integer.parseInt(request.getParameter("sco1"));
			int sc2 = Integer.parseInt(request.getParameter("sco2"));
			
			session.setAttribute("score_list", new UserDAO().getUserByScore(sc1, sc2));
			//response.sendRedirect("http://localhost:8080/MVC/scorelist.jsp");	
			response.sendRedirect("Scorelist");	
			}
		else {
			session.setAttribute("score_list", new UserDAO().getAllUsers());
			//response.sendRedirect("http://localhost:8080/MVC/scorelist.jsp");
			response.sendRedirect("Scorelist");	
		}
		
		}
		
		else {
			//out.print("Find.java");
			response.sendRedirect("login1.jsp");
		}
		
		
		
}
    
    
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
