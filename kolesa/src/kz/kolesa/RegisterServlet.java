package kz.kolesa;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserDao userDao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
  	public void init(ServletConfig config) throws ServletException {
  		super.init(config);
  		DBConnection db = new DBConnection();

  		userDao = new UserDao(db.getCon());
  	}

  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String name = req.getParameter("username");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");
		String password1 = req.getParameter("password1");
		if(name == null || name.equals("")){error+="Name is empty \n";}
		if(email.equals("") || email == null){error+="Email is empty \n";}
		if(phone.equals("") || phone == null){error+="Phone is empty \n";}
		if(password.equals("") || password == null){error+="Password is empty \n";}
		if(!password.equals(password1)){error+="Passwords are not same \n";}
		if(error.equals(""))
		{
			userDao.newUser(new User(name,email,password,phone));
			req.setAttribute("username",name);
			req.setAttribute("phone",phone);
			req.setAttribute("email",email);
			//req.setAttribute("posts", userDao.userPosts(userDao.getId(name)));
			req.getRequestDispatcher("/ok.jsp").forward(req,response);
		}else
		{
			req.setAttribute("error",error);
			req.getRequestDispatcher("/index.jsp").forward(req,response);
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
