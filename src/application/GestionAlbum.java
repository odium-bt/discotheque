package application;

import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;
import modele.Album;

import java.util.ArrayList;

public class GestionAlbum {
    private static ArrayList<Album> discotheque = new ArrayList<>();

    public static void creerAlbum(Album d) {
        getDiscotheque().add(d);
        System.out.println("Album(s) ajouté(s) avec succès");
    }


    public static void supprimerAlbum(String n) throws DiscothequeVideException {
        Album trouve = null;
        for (Album d : discotheque) {
            if (d.getNomAlbum().equals(n)) {
                trouve = d; //supprime la première occurrence (ne gère pas les doublons)
                break;
            }
        }
        if (trouve != null) {
            getDiscotheque().remove(trouve);
            System.out.println("Album supprimé de la discothèque.");
        } else {
            System.out.println("Album non trouvé.");
        }
    }

    public static void rechercherAlbum() {

    }

    public static ArrayList<Album> getDiscotheque() {
        return discotheque;
    }

    public static void setDiscotheque(ArrayList<Album> discotheque) {
        GestionAlbum.discotheque = discotheque;
    }

    public void afficherDiscotheque() {
        System.out.println(getDiscotheque());
    }

    public static void viderDiscotheque() {
        discotheque.clear();
        System.out.println("Discothèque vidée !");
    }

    public static void rechercherAlbumParNom(String n) throws DiscothequeVideException, AlbumIntrouvableException {
        Album trouve = null;
        for (Album d : discotheque) {
            if (d.getNomAlbum().equals(n)) { // equals ->sensible à la case!
                trouve = d;
                break;
            }
        }
        if (trouve != null) {
            System.out.println("l'album " + trouve.getNomAlbum() + " est enregistré dans la discothèque.");
            trouve.getSupport();
            trouve.afficherDetails();
        } else {
            throw new AlbumIntrouvableException("Il n'existe pas d'album nommé " + n + " dans la discothèque.");
        }
    }


    public static void EstVideDiscotheque() throws DiscothequeVideException {
        if (discotheque.isEmpty()) {
            throw new DiscothequeVideException("La discothèque est vide.");
        }
    }

    public static void listerDiscotheque() {
        int compt = 1;
        for (Album d : discotheque) {
            System.out.println("Album n° " + compt);
            d.getSupport();
            d.afficherDetails();
            System.out.println(("***"));
            compt += 1;
        }
    }

}


