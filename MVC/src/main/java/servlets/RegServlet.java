package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.UserDAO;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			UserDAO userdao=new UserDAO();
			if( userdao.isUsernameExists(username) ){
				request.getSession().setAttribute("err", "用户名已存在");
				response.sendRedirect("register.jsp");
				}
				else{
				boolean flag=userdao.addUser(user);
				if(flag){
					HttpSession session=request.getSession();
					User u = userdao.getUserBynameandpass(username, password);
					session.setAttribute("user", u);
				//request.getSession().setAttribute("username", username);
				//response.sendRedirect("welcome.jsp");
				response.sendRedirect("test.jsp");
				}
				else{
				request.getSession().setAttribute("err", "注册失败");
				response.sendRedirect("register.jsp");
				}
				}
		} // end service
	
	
	
	
	
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
