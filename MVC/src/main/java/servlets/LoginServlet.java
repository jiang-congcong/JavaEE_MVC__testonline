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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String identity=request.getParameter("rad");
			UserDAO userdao=new UserDAO();
			boolean flag=false;
			if(identity.equals("stu")) {
			flag=userdao.findUser(username, password);
			}
			else {
				flag=userdao.findUser_tec(username, password);
			}
			if( flag ) {
			//request.getSession().setAttribute("username", username);
			//response.sendRedirect("welcome.jsp");
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				HttpSession session=request.getSession();
				User u = userdao.getUserBynameandpass(username, password);
				//session.setAttribute("user", u);
				
				if(identity.equals("stu")) {
					session.setAttribute("user", u);
				out.print("欢迎"+username);
				out.print("<br/><br/>");
				out.print("<a href='test.jsp'>开始测试</a>");
				}
				
				else {
					session.setAttribute("user", u);
					session.setAttribute("flag", "true");
					out.print("欢迎"+username+"老师");
					out.print("<br/><br/>");
					out.print("<a href='Admin'>学生管理</a>"+"&nbsp;&nbsp;&nbsp;&nbsp;"+"<a href='select.jsp'>成绩查询</a>");
					out.print("<br/>");
					out.print("<a href='Logout'>退出</a>");
				}
			}
			else{				
			    request.getSession().setAttribute("err", "用户名或密码或身份不正确！");				
			    response.sendRedirect("login1.jsp");
				//PrintWriter out = response.getWriter();
				//out.print(username+"   "+password+""+identity);
			}
			
    }
	





	
	
	
	
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
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
