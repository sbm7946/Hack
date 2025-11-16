package DataBase;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.io.Serializable;
import java.util.ArrayList;


public class PostsContainer implements Serializable{


    private static final String SAVED_POSTS_FILE_NAME = "posts.dat";

    private ArrayList<Post> postsList;
    private static PostsContainer postsContainer;


    private PostsContainer(){
        postsList = loadPosts();

        System.out.println(postsList.size());
    }

    public static PostsContainer getInstance(){
        if (postsContainer == null){
            postsContainer = new PostsContainer();
        }

        return postsContainer;
    }


    public void savePost(){
        try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(SAVED_POSTS_FILE_NAME))){
            o.writeObject(postsList);
        }
        catch(Exception e){
            System.out.println("Could not save posts.");
        }
    }

    public void addPost(Post post) {
        postsList.add(post);
        savePost();
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Post> loadPosts(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(SAVED_POSTS_FILE_NAME))){
            return (ArrayList<Post>) in.readObject();
        }
        catch(Exception e){
            return new ArrayList<>();
        }
    }

    public ArrayList<Post> getPosts(){
        return postsList;
    }
}
