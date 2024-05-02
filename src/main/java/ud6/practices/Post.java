package ud6.practices;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una publicació.
 *
 * @version 1.0, 2021-04-01
 * @author Joan Puigcerver
 * @see Commentable
 */
public class Post implements Commentable {
    /**
     * Títol de la publicació.
     */
    private final String title;
    /**
     * Contingut de la publicació.
     */
    private final String content;
    /**
     * Llista de comentaris de la publicació.
     */
    private final List<Comment> comments;

    /**
     * Crea una publicació amb el títol i el contingut especificats.
     * @param title el títol de la publicació
     * @param content el contingut de la publicació
     */
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.comments = new ArrayList<>();
    }

    /**
     * Obté el títol de la publicació.
     * @return el títol de la publicació
     */
    public String getTitle() {
        return title;
    }

    /**
     * Obté el contingut de la publicació.
     * @return el contingut de la publicació
     */
    public String getContent() {
        return content;
    }

    /**
     * Obté els comentaris de la publicació.
     * @return la llista de comentaris de la publicació
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * Afegeix un comentari a la publicació.
     * @param comment el comentari a afegir
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
