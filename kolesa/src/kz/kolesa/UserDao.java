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
            String query = "Select postId from usersposts WHERE userId = '"+id+"'";
            ResultSet rs = st.executeQuery(query);
            ResultSet rs1;
            while(rs.next())
            {
            	System.out.print(rs.getString("postId"));
            	String query1 = "Select * from posts WHERE id = '"+rs.getString("postId")+"'";
            	rs1 = st.executeQuery(query1);
            	rs1.next();
            	posts.add(new Post(rs1.getString("title"),rs1.getString("city"),rs1.getString("year"),rs1.getString("capacity"),rs1.getString("mileage"),rs1.getString("color"),rs1.getString("drive"),rs1.getString("state"),rs1.getString("image"),rs1.getString("author"),rs.getString("price"),rs.getString("description")));
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