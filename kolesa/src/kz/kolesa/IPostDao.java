package kz.kolesa;

import java.util.ArrayList;

public interface IPostDao
{
    public int newPost(Post post);
    public Post post(int id);
    public void usersPost(String username,int postId);
    public void increaseViews(int postId);
    public ArrayList<Post> getTop(int count);
    public ArrayList<Post> getResults(String order);
}