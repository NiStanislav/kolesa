package kz.kolesa;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/new")
@MultipartConfig
public class NewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPostDao postDao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
  		super.init(config);
  		DBConnection db = new DBConnection();
  		postDao = new PostDao(db.getCon());
  	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id"); 
		
		request.setAttribute("id", id);
		request.getRequestDispatcher("/post").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	
			String error = "";
		 	String title = req.getParameter("title"); 
		 	String city = req.getParameter("city");
		 	String year = req.getParameter("year");
		 	String capacity = req.getParameter("capacity");
		 	String mileage = req.getParameter("mileage");
		 	String color = req.getParameter("color");
		 	String drive = req.getParameter("drive");
		 	String state = req.getParameter("state"); 	
		 	String price = req.getParameter("price");
		 	String description = req.getParameter("description");
		    Part filePart = req.getPart("file");
//		    File uploads = new File("C://upload/");
//		    File file = new File(uploads, title+".jpeg");
//		    try (InputStream input = filePart.getInputStream()) {
//		        Files.copy(input, file.toPath());
//		    }
//		    catch(Exception ex)
//		    {
//		    	error+="File uploading error \n";
//		    }
		    
		    boolean withImage = false;
			String imageUrl = "";
			String imgName = filePart.getName()+ Math.random();
	        if (filePart != null) {
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	            System.out.println(filePart.getContentType().split("/")[1]);
	            
	            InputStream inputStream = filePart.getInputStream();
	            
	            if(filePart.getContentType().split("/")[0].equals("application")) {
	            		System.out.print("image input is empty");
	            } else {
	       
	            		imageUrl = imgName +"."+filePart.getContentType().split("/")[1];
	                System.out.print("imageUrl: " + imageUrl);
	                
	                withImage = true;
//	                newPost.setImage_url(imageUrl);
	                S3Uploader s3Manager = new S3Uploader();
	                s3Manager.uploadFile(imageUrl, inputStream);
	            }
	        }
		    String filePath = "https://s3.amazonaws.com/sis-cloud/" + imgName +"."+filePart.getContentType().split("/")[1];
		    if(title == null || title.equals("")){error+="Title is empty \n";}
		    if(city == null || city.equals("")){error+="City is empty \n";}
		    if(year == null || year.equals("")){error+="Yeear is empty \n";}
		    if(capacity == null || capacity.equals("")){error+="Capacity is empty \n";}
		    if(mileage == null || mileage.equals("")){error+="Mileage is empty \n";}
		    if(color == null || color.equals("")){error+="Color is empty \n";}
		    if(drive == null || drive.equals("")){error+="Drive is not selected \n";}
		    if(state == null || state.equals("")){error+="State is not selected \n";}
		    if(error.equals(""))
			{
		    	String author = "guest";
			    HttpSession session = req.getSession();
		    	if(session.getAttribute("name")!=null)
		    	{
		    		author = session.getAttribute("name").toString();
		    	}
				int id = postDao.newPost(new Post(title,city,year,capacity,mileage,color,drive,state,filePath,author, price, description));
				if(id==0)
				{
 					error+="Post exist!";
 					req.setAttribute("error",error);
 					req.getRequestDispatcher("/new.jsp").forward(req,response);
 					return;
 				}
				postDao.usersPost(author,id);
				req.setAttribute("id", id);
				req.getRequestDispatcher("/post").forward(req,response);
			}else
			{
				req.setAttribute("error",error);
				req.getRequestDispatcher("/new.jsp").forward(req,response);
			}
	}

}
