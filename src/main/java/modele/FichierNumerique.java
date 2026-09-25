package modele;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FichierNumerique extends Album {
    private String format;
    private double taille;
    private int duree;
    private String chemin;

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

    public String getChemin() { return chemin; }

    public void setChemin(String chemin) { this.chemin = chemin; }

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
                ", chemin=" + chemin +
                '}';
    }

    @Override
    public void getSupport() {
        System.out.println("Cet album existe sur un support Fichier numérique");
    }

    public File getFichier() {

        File file = new File(chemin);
        return file;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Détails : Titre : " + nomAlbum +
                " ; Auteur/groupe : " + auteur +
                " ; Date de parution : " + dateAlbum.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " ; Nombre d'exemplaires en stock : " + quantite +
                " ; format : " + format +
                " ; taille : " + taille +
                " ; durée (minutes) : " + duree +
                " ; Chemin : " + chemin + ".");
    }
}
