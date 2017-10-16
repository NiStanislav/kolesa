package kz.kolesa;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserDao userDao;  
 
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		DBConnection db = new DBConnection();
		userDao = new UserDao(db.getCon());
	}

	
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		User user = userDao.isUser(name,password);
		if(user!=null)
		{
			HttpSession session = req.getSession();
			session.setAttribute("name", name);
			session.setAttribute("id", userDao.getId(name));
			req.setAttribute("username", user.getName());
			req.setAttribute("phone", user.getPhone());
			req.setAttribute("email", user.getEmail());
			//req.setAttribute("posts", userDao.userPosts(userDao.getId(name)));
			req.getRequestDispatcher("/").forward(req,response);
		}
		else
		{
			error="Name or password are incorrect";
			req.setAttribute("error",error);
			req.getRequestDispatcher("/login.jsp").forward(req,response);
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
