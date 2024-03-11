package ud6.practices;

import java.util.ArrayList;
import java.util.List;

public class Post implements Commentable {
    private final String title;
    private final String content;
    private final List<Comment> comments;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.comments = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
