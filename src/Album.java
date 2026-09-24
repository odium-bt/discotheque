import java.time.LocalDate;

public abstract class Album {
    protected String nomAlbum;
    protected String auteur;
    protected LocalDate dateAlbum;
    protected int quantite;

    public Album(String nomAlbum, String auteur, LocalDate dateAlbum, int quantite) {
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

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
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
                ", auteur='" + auteur + '\'' +
                ", dateAlbum=" + dateAlbum +
                ", quantite=" + quantite +
                '}';
    }

    public abstract void getSupport();
}
