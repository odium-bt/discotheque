package modele;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DisqueVinyle extends Album {
    private String numero;
    private int taille;

    public DisqueVinyle(String nomAlbum, String auteur, LocalDate dateAlbum, int quantite, String numero, int taille) {
        super(nomAlbum, auteur, dateAlbum, quantite);
        this.numero = numero;
        this.taille = taille;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    @Override
    public String toString() {
        return "DisqueVinyle{" +
                "numero='" + numero + '\'' +
                ", taille=" + taille +
                ", nomAlbum='" + nomAlbum + '\'' +
                ", auteur='" + auteur + '\'' +
                ", dateAlbum=" + dateAlbum +
                ", quantite=" + quantite +
                '}';
    }

    @Override
    public void getSupport() {
        System.out.println("Cet album existe sur un support Disque vinyle");
    }

    @Override
    public void afficherDetails() {
        System.out.println("Disque vinyle. " + nomAlbum +
                " de l'auteur/groupe " + auteur +
                " ; Date de parution : " + dateAlbum.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " ; Nombre d'exemplaires en stock : " + quantite +
                " ; numéro : " + numero +
                " ; taille : " + taille);
    }


}
