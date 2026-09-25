package application;

import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;
import exceptions.SaisieInvalideException;
import modele.Album;
import modele.CompactDisque;
import modele.DisqueVinyle;
import modele.FichierNumerique;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Controller {
    static Scanner scan = new Scanner(System.in);

    /**
     * Affiche le menu principal
     */
    public int afficherMenu() {
        System.out.println("===== GESTION DE LA DISCOTHEQUE =====");
        System.out.println("1. Ajouter un album");
        System.out.println("2. Supprimer un album");
        System.out.println("3. Afficher le contenu de la discotheque");
        System.out.println("4. Vider la discotheque");
        System.out.println("5. Rechercher un album");
        System.out.println("0. Quitter");
        System.out.print("Choix:");
        return Controller.scan.nextInt();
    }


    public String saisieStr(String msg) throws SaisieInvalideException {
        String s;
        System.out.print(msg);
        s = scan.nextLine();
        if (s.isEmpty()) {
            throw new SaisieInvalideException("La donnée entrée est invalide");
        }
        return s;
    }

    private int saisieInt(String msg) throws SaisieInvalideException {
        int s;
        System.out.print(msg);
        s = scan.nextInt();
        scan.nextLine();
        if (s < 0) {
            throw new SaisieInvalideException("La donnée entrée est invalide");
        }
        return s;
    }

    private double saisieTailleD() throws SaisieInvalideException {
        double s;
        System.out.print("Saisissez la taille du fichier : ");
        s = scan.nextDouble();
        scan.nextLine();
        if (s < 0) {
            throw new SaisieInvalideException("La donnée entrée est invalide");
        }
        return s;
    }

    public String saisieAuteur() throws SaisieInvalideException {
        return (saisieStr("Saisissez le nom de l'auteur :"));
    }


    public String saisieNomA() throws SaisieInvalideException {
        return (saisieStr("Saisissez le nom de l'album :"));
    }

    public LocalDate saisieDate() throws SaisieInvalideException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = null;
        do {
            String dateD = saisieStr("Saisissez la date de parution (jj/mm/aaaa) :");
            try {
                date = LocalDate.parse(dateD, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Format invalide. Exemple : 22/09/2026");
            }
        } while (date == null);
        return date;
    }

    public int saisieQuantite() throws SaisieInvalideException {
        return saisieInt("Saisissez le nombre d'exemplaires :");

    }

    public String saisieNum() throws SaisieInvalideException {
        return saisieStr("Saisissez le numéro de l'album :");
    }

    public String saisieType() throws SaisieInvalideException {
        return saisieStr("Saisissez le type de disque :");
    }

    public String saisieFormat() throws SaisieInvalideException {
        return saisieStr("Saisissez le format du fichier :");
    }

    public int saisieDuree() throws SaisieInvalideException {
        return saisieInt("Saisissez la durée de l'album :");
    }

    public int saisieTaille() throws SaisieInvalideException {
        return saisieInt("Saisissez la taille du vinyle :");
    }

    public void saisieAlbum(int support) throws SaisieInvalideException {
        String nomAlbum = saisieNomA();
        String auteur = saisieAuteur();
        LocalDate date = saisieDate();
        int quantite = saisieQuantite();

        String num;

        Album a = null;
        switch (support) {
            case 1:  // Disque
                num = saisieNum();
                String type = saisieType();
                a = new CompactDisque(nomAlbum, auteur, date, quantite, num, type);
                break;
            case 2: // Vinyle
                num = saisieNum();
                int taille = saisieTaille();
                a = new DisqueVinyle(nomAlbum, auteur, date, quantite, num, taille);
                break;
            case 3:
                String format = saisieFormat();
                double tailleFichier = saisieTailleD();
                int duree = saisieDuree();
                a = new FichierNumerique(nomAlbum, auteur, date, quantite, format, tailleFichier, duree);
                break;
        }

        GestionAlbum.creerAlbum(a);
    }

    public void supprimerAlbum() throws AlbumIntrouvableException, DiscothequeVideException, SaisieInvalideException {
        GestionAlbum.EstVideDiscotheque();
        String nomSupprime = saisieNomA();
        GestionAlbum.supprimerAlbum(nomSupprime);
    }


    public void rechercherAlbum() throws AlbumIntrouvableException, DiscothequeVideException, SaisieInvalideException {
        GestionAlbum.EstVideDiscotheque();
        String nomRecherche = saisieNomA();
        GestionAlbum.rechercherAlbumParNom(nomRecherche);
    }


    public void listerAlbum() throws DiscothequeVideException {
        GestionAlbum.EstVideDiscotheque();
        GestionAlbum.listerDiscotheque();
    }

    public void viderDiscotheque() {
        GestionAlbum.viderDiscotheque();
    }


}
