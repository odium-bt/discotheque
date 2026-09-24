package application;

import modele.Album;

import java.util.ArrayList;

public class GestionAlbum {
    private static ArrayList<Album> discotheque = new ArrayList<>();

    public static void creerAlbum(Album d) {
        getDiscotheque().add(d);
        System.out.println("Album(s) ajouté(s) avec succès");
    }

    public static void supprimerDisque(String n, String a) {

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
}
