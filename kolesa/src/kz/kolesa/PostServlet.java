package kz.kolesa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/post")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       IPostDao postDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
  		super.init(config);
  		DBConnection db = new DBConnection();
  		postDao = new PostDao(db.getCon());
  	}
	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=0;
		try {
			id = Integer.parseInt(request.getAttribute("id").toString());
		}
		catch(Exception ex)
		{
			PrintWriter out = response.getWriter();
			out.print("This post is not exist!");
			return;
		}
		Post post = postDao.post(id);
		postDao.increaseViews(id);
		request.setAttribute("title", post.getTitle());
		request.setAttribute("city", post.getCity());
		request.setAttribute("year", post.getYear());
		request.setAttribute("capacity", post.getCapacity());
		request.setAttribute("mileage", post.getMileage());
		request.setAttribute("color", post.getColor());
		request.setAttribute("drive", post.getDrive());
		request.setAttribute("state", post.getState());
		request.setAttribute("image", post.getImage());
		request.setAttribute("date", post.getDate());
		request.setAttribute("views", post.getViews());
		request.setAttribute("author", post.getAuthor());
		request.getRequestDispatcher("/post.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
