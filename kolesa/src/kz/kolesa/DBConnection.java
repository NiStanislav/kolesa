package kz.kolesa;
import java.sql.*;
public class DBConnection
{
  private Connection con;
  private Statement st;
  private ResultSet rs;
  public DBConnection()
  {
     try
     {
    	 
         Class.forName("org.postgresql.Driver");
         con = DriverManager.getConnection("jdbc:postgresql://kolesa-db1.cd8jkv82t8hq.us-east-2.rds.amazonaws.com:5432/kolesadb", "adminkolesa", "adminkolesa");
         st = con.createStatement();

     }
     catch(Exception ex)
     {
         System.out.println("Error:"+ex);
     }
  }

    public Connection getCon() {
        return con;
    }



  public User isUser(String name,String password)
  {
      try
      {
          String query = "Select * from users WHERE name='"+name+"' AND password='"+password+"'";
          rs = st.executeQuery(query);
          rs.next();
          if(rs.getString("name").equals(name) && rs.getString("password").equals(password))
          {
              User user = new User(rs.getString("name"),rs.getString("email"),rs.getString("password"),rs.getString("phone"));
              return user;
          }
      }
      catch(Exception ex)
      {
          System.out.println("Error:"+ex);
      }
      return null;
  }

  public void newUser(User user) {
      try
      {
        PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement("INSERT INTO persons (name,email,password)VALUES(?,?,?)");
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getEmail());
        preparedStatement.setString(3,user.getPassword());
        preparedStatement.executeUpdate();
        preparedStatement.close();
      }

      catch(Exception ex)
      {
          System.out.println("Error:"+ex);
      }
  }
}