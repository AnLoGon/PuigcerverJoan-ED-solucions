package ud6.practices;

import java.util.List;
import java.util.ArrayList;

/**
 * Representa un comentari.
 *
 * @version 1.0, 2021-04-01
 * @author Joan Puigcerver
 * @see Commentable
 */
public class Comment implements Commentable {
    /**
     * Contingut del comentari.
     */
    private final String content;
    /**
     * Llista de respostes al comentari.
     */
    private final List<Comment> comments;

    /**
     * Crea un comentari amb el contingut especificat.
     * @param content el contingut del comentari
     */
    public Comment(String content) {
        this.content = content;
        this.comments = new ArrayList<>();
    }

    /**
     * Obté el contingut del comentari.
     * @return el contingut del comentari
     */
    public String getContent() {
        return content;
    }

    /**
     * Afegeix un comentari com a resposta a aquest comentari.
     * @param comment el comentari a afegir
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    /**
     * Obté la llista de respostes al comentari.
     * @return la llista de respostes al comentari
     */
    public List<Comment> getComments() {
        return comments;
    }
}
