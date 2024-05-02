package ud6.practices;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un usuari de la xarxa social.
 *
 * @version 1.0, 2021-04-01
 * @author Joan Puigcerver
 */
public class User {
    /**
     * Nom d'usuari.
     */
    private final String username;
    /**
     * Llista de publicacions de l'usuari.
     */
    private final List<Post> posts;

    /**
     * Crea un usuari amb el nom d'usuari especificat.
     *
     * @param username Nom d'usuari.
     */
    public User(String username) {
        this.username = username;
        this.posts = new ArrayList<>();
    }

    /**
     * Obté el nom d'usuari.
     *
     * @return Nom d'usuari.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Obté les publicacions de l'usuari.
     *
     * @return Llista de publicacions de l'usuari.
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * Afegeix una publicació a l'usuari.
     *
     * @param post Publicació a afegir.
     */
    public void addPost(Post post) {
        posts.add(post);
    }
}
