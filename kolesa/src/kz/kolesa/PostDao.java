package kz.kolesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class PostDao implements IPostDao{
	private Connection connection;

    public PostDao(Connection connection) {
        this.connection = connection;
    }
    
    public Post post(int id)
    {
    	try {
    	Statement st = connection.createStatement();
        String query = "Select * from posts WHERE id='"+id+"'";
        ResultSet rs = st.executeQuery(query);
        rs.next();
        Post post = new Post(rs.getString("title"),rs.getString("city"),rs.getString("year"),rs.getString("capacity"),rs.getString("mileage"),rs.getString("color"),rs.getString("drive"),rs.getString("state"),rs.getString("image"),rs.getString("author"),rs.getString("price"),rs.getString("description"));
        post.setDate(rs.getString("date"));
        post.setViews(rs.getString("views"));
        return post;
    	}
    	catch(Exception ex)
    	{
    		System.out.print(ex);
    	}
        return null;
    }
    
    public void increaseViews(int postId)
    {
    	try {
    	Statement st = connection.createStatement();
    	String query = "Select views from posts WHERE id='"+postId+"'";
        ResultSet rs = st.executeQuery(query);
        rs.next();
        int views = Integer.parseInt(rs.getString("views")) + 1;
        rs.close();
        st.close();
        Statement st1 = connection.createStatement();
        query = "UPDATE posts SET views = '"+ views +"' WHERE id = '"+ postId +"'";
        st1.executeUpdate(query);
    	}
    	catch(Exception ex)
    	{
    		System.out.println(ex);
    	}
    }
    
    public ArrayList<Post> getTop(int count)
    {
    	ArrayList<Post> result = new ArrayList<Post>();
    	try {
    	Statement st = connection.createStatement();
        String query = "SELECT * FROM posts ORDER BY views desc limit "+ count +"";
        ResultSet rs = st.executeQuery(query);
        while(rs.next())
        {
        	result.add(new Post(rs.getString("title"),rs.getString("image"),rs.getString("id")));
        }
        return result;
    	}
    	catch(Exception ex)
    	{
    		System.out.print(ex);
    	}
    	return null;
    }
    
    public ArrayList<Post> getResults(String order)
    {
    	ArrayList<Post> result = new ArrayList<Post>();
    	try {
    	Statement st = connection.createStatement();
        String query = "SELECT * FROM posts ORDER BY "+ order + " desc";
        ResultSet rs = st.executeQuery(query);
        while(rs.next())
        {
        	result.add(new Post(rs.getString("title"),rs.getString("image"),rs.getString("id")));
        }
        return result;
    	}
    	catch(Exception ex)
    	{
    		System.out.print(ex);
    	}
    	return null;
    }
    
    public void usersPost(String username,int postId)
    {
    	try {
    	Statement st = connection.createStatement();
        String query = "Select id from users WHERE username='"+username+"'";
        ResultSet rs = st.executeQuery(query);
        rs.next();
        int id = Integer.parseInt(rs.getString("id"));
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("Insert INTO usersposts (userId,postId)VALUES(?,?)");
        preparedStatement.setString(1,String.valueOf(id));
        preparedStatement.setString(2,String.valueOf(postId));        
        preparedStatement.executeUpdate();
        preparedStatement.close();
        
    	}
    	catch(Exception ex)
    	{
    		System.out.print(ex);
    	}
    }
    
    public int newPost(Post post)
    {
    	try
        {
    		 Statement st1 = connection.createStatement();
             String query1 = "Select * from posts WHERE title='"+post.getTitle()+"' OR description='"+post.getDescription()+ "'";
             ResultSet rs1 = st1.executeQuery(query1);
             if(rs1.next()) { return 0;}
             st1.close();
             rs1.close();
 		
	
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("INSERT INTO posts (title,city,year,capacity,mileage,color,drive,state,image,author,price,description)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,post.getTitle());
            preparedStatement.setString(2,post.getCity());
            preparedStatement.setString(3,post.getYear());
            preparedStatement.setString(4,post.getCapacity());
            preparedStatement.setString(5,post.getMileage());
            preparedStatement.setString(6,post.getColor());
            preparedStatement.setString(7,post.getDrive());
            preparedStatement.setString(8,post.getState());
            preparedStatement.setString(9,post.getImage());
            preparedStatement.setString(10,post.getAuthor());
            preparedStatement.setString(11,post.getPrice());
            preparedStatement.setString(12,post.getDescription());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            Statement st = connection.createStatement();
            String query = "Select id from posts WHERE title='"+post.getTitle()+"'";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            return Integer.parseInt(rs.getString("id"));
        }
        catch(Exception ex)
        {
            System.out.println("Error:"+ex);
        }
    	return 0;
    }
}
