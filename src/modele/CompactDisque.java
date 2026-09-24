package modele;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CompactDisque extends Album {
    private String numero;
    private String type;

    public CompactDisque(String nomAlbum, String auteur, LocalDate dateAlbum, int quantite, String numero, String type) {
        super(nomAlbum, auteur, dateAlbum, quantite);
        this.numero = numero;
        this.type = type;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CompactDisque{" +
                "numero='" + numero + '\'' +
                ", type='" + type + '\'' +
                ", nomAlbum='" + nomAlbum + '\'' +
                ", auteur='" + auteur + '\'' +
                ", dateAlbum=" + dateAlbum +
                ", quantite=" + quantite +
                '}';
    }

    @Override
    public void getSupport() {
        System.out.println("Cet album existe sur un support CD");
    }

    @Override
    public void afficherDetails() {
        System.out.println("CD. " + nomAlbum +
                " de l'auteur/groupe " + auteur +
                " ; Date de parution : " + dateAlbum.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " ; Nombre d'exemplaires en stock : " + quantite +
                " ; numéro : " + numero +
                " ; type : " + type);
    }


}
