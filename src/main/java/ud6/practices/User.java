package ud6.practices;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String username;
    private final List<Post> posts;

    public User(String username) {
        this.username = username;
        this.posts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }
}
