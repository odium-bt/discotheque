package modele;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FichierNumerique extends Album {
    private String format;
    private double taille;
    private int duree;

    public FichierNumerique(String nomAlbum, String auteur, LocalDate dateAlbum, int quantite, String format, double taille, int duree) {
        super(nomAlbum, auteur, dateAlbum, quantite);
        this.format = format;
        this.taille = taille;
        this.duree = duree;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "FichierNumerique{" +
                "format='" + format + '\'' +
                ", taille=" + taille +
                ", duree=" + duree +
                ", nomAlbum='" + nomAlbum + '\'' +
                ", auteur='" + auteur + '\'' +
                ", dateAlbum=" + dateAlbum +
                ", quantite=" + quantite +
                '}';
    }

    @Override
    public void getSupport() {
        System.out.println("Cet album existe sur un support Fichier numérique");
    }

    @Override
    public void afficherDetails() {
        System.out.println("Fichier numérique. " + nomAlbum +
                " de l'auteur/groupe " + auteur +
                " ; Date de parution : " + dateAlbum.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " ; Nombre d'exemplaires en stock : " + quantite +
                " ; format : " + format +
                " ; taille : " + taille +
                " ; durée (minutes) : " + duree);
    }
}
