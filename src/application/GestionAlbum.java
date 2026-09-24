package application;

import modele.Album;

import java.util.ArrayList;

public class GestionAlbum {
    private static ArrayList<Album> discotheque = new ArrayList<>();

    public static void creerDisque(Album d) {
        getDiscotheque().add(d);
    }

    public static void supprimerDisque(String n, String a) {
        //TODO
        Album trouve = null;
        for (Album d : discotheque) {
            if (d.getNomAlbum().equals(n) && d.getAuteur().equals(a.getAuteur())) {
                trouve = d;
                break;
            }
        }
        if (trouve != null) {
            System.out.println("Disque trouvé");
            trouve = null;
        } else {
            System.out.println("Disque non trouvé");
        }
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

}
