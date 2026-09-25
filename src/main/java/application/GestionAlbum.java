package application;

import audio.LecteurMP3;
import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;
import exceptions.FichierAudioException;
import modele.Album;
import modele.FichierNumerique;

import java.util.ArrayList;

public class GestionAlbum {
    private static ArrayList<Album> discotheque = new ArrayList<>();

    public static void creerAlbum(Album d) {
        getDiscotheque().add(d);
        System.out.println("Album(s) ajouté(s) avec succès");
    }


    public static void supprimerAlbum(String n) throws DiscothequeVideException, AlbumIntrouvableException {
        Album a = trouveAlbum(n);
        getDiscotheque().remove(a); // Supprime la première occurrence
        System.out.println("Album " + n + " supprimé de la discothèque.");

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

    public static Album trouveAlbum(String n) throws AlbumIntrouvableException {
        Album trouve = null;
        for (Album a : discotheque) {
            if (a.getNomAlbum().equals(n)) { // equals ->sensible à la case!
                trouve = a;
                break;
            }
        }
        if (trouve == null) {
            throw new AlbumIntrouvableException("Il n'existe pas d'album nommé " + n + " dans la discothèque.");
        }
        return trouve;
    }

    public static void rechercherAlbumParNom(String n) throws AlbumIntrouvableException {
        Album a = trouveAlbum(n);
        System.out.println("L'album " + a.getNomAlbum() + " est enregistré dans la discothèque.");
        a.getSupport();
        a.afficherDetails();
    }


    public static void EstVideDiscotheque() throws DiscothequeVideException {
        if (discotheque.isEmpty()) { //ou discotheque.size() < 1
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

    public static void lireAlbum(String n) throws AlbumIntrouvableException, FichierAudioException {

    }
}


