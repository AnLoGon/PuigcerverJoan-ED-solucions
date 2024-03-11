package ud6.practices;

import java.util.List;
import java.util.ArrayList;

public class Comment implements Commentable {
    private final String content;
    private final List<Comment> comments;

    public Comment(String content) {
        this.content = content;
        this.comments = new ArrayList<>();
    }

    public String getContent() {
        return content;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }
}
