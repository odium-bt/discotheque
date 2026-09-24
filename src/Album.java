import java.time.LocalDate;

public class Album {
    protected String nomAlbum;
    protected Auteur auteur;
    protected LocalDate dateAlbum;
    protected int quantite;

    public Album(String nomAlbum, Auteur auteur, LocalDate dateAlbum, int quantite) {
        this.nomAlbum = nomAlbum;
        this.auteur = auteur;
        this.dateAlbum = dateAlbum;
        this.quantite = quantite;
    }

    public String getNomAlbum() {
        return nomAlbum;
    }

    public void setNomAlbum(String nomAlbum) {
        this.nomAlbum = nomAlbum;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public LocalDate getDateAlbum() {
        return dateAlbum;
    }

    public void setDateAlbum(LocalDate dateAlbum) {
        this.dateAlbum = dateAlbum;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Album{" +
                "nomAlbum='" + nomAlbum + '\'' +
                ", auteur=" + auteur +
                ", dateAlbum=" + dateAlbum +
                ", Quantite=" + quantite +
                '}';
    }
}
