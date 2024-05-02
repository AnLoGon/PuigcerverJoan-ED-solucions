package ud6.practices;

import java.util.List;

/**
 * Representa un element que pot ser comentat.
 *
 * @version 1.0, 2021-04-01
 * @author Joan Puigcerver
 */
public interface Commentable {
    /**
     * Afegeix un comentari a l'element.
     *
     * @param comment Comentari a afegir.
     */
    void addComment(Comment comment);
    /**
     * Obté els comentaris de l'element.
     *
     * @return Llista de comentaris de l'element.
     */
    List<Comment> getComments();
}
