package kz.kolesa;
import java.util.ArrayList;
import java.sql.*;
public class UserDao implements IUserDao
{

    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }


    public void newUser(User user) {
        try
        {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("INSERT INTO users (username,password,phone,email)VALUES(?,?,?,?)");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getPhone());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error:"+ex);
        }
    }

    public String getId(String username)
    {
    	try {
    		
    	Statement st = connection.createStatement();
        String query = "Select id from users WHERE username = '"+username+"'";
        ResultSet rs = st.executeQuery(query);
        rs.next();
    	return (rs.getString("id"));
    	}
    	catch(Exception ex)
    	{
    		
    	}
    	return null;
    }
    
    
    
    public ArrayList<Post> userPosts(String id) {
    	ArrayList<Post> posts = new ArrayList<Post>();
        try
        {
            Statement st = connection.createStatement();
            String query = "Select * from posts WHERE authorId = '"+id+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
            	posts.add(new Post(rs.getString("title"),rs.getString("city"),rs.getString("year"),rs.getString("capacity"),rs.getString("mileage"),rs.getString("color"),rs.getString("drive"),rs.getString("state"),rs.getString("image"),rs.getString("author"),rs.getString("price"),rs.getString("description"),rs.getString("authorId")));
            }
            
            return posts;
        }
        catch(Exception ex)
        {
            System.out.println("Error:"+ex);
        }
        return null;

    }
    
    public User isUser(String name,String password) {
        try
        {
            Statement st = connection.createStatement();
            String query = "Select * from users WHERE username='"+name+"' AND password='"+password+"'";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            User user = new User(rs.getString("username"),rs.getString("email"),rs.getString("password"),rs.getString("phone"));
            if(rs.getString("username").equals(name) && rs.getString("password").equals(password))
            {
                return user;
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error:"+ex);
        }
        return null;

    }
    
    public User getUser(String id) {
        try
        {
            Statement st = connection.createStatement();
            String query = "Select * from users WHERE id = '"+id+"'";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            User user = new User(rs.getString("username"),rs.getString("email"),rs.getString("password"),rs.getString("phone"));
            return user;
        }
        catch(Exception ex)
        {
            System.out.println("Error:"+ex);
        }
        return null;

    }

}