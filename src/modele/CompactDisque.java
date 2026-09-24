package modele;

import java.time.LocalDate;

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
        System.out.println("CD");
    }
}
