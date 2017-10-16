package kz.kolesa;

import java.util.ArrayList;

public interface IUserDao
{
    public User isUser(String name,String password);
    public void newUser(User user);
    public ArrayList<Post> userPosts(String id);
    public String getId(String username);
    public User getUser(String id);
}