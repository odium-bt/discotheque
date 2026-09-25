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
import java.util.InputMismatchException;
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
        try {
            return Controller.scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Veuillez entrer le numéro d'une des options données.");
            scan.nextLine();
            return afficherMenu();
        }
    }

    /**
     * Affiche le sous-menu pour les supports d'albums
     */
    public int afficherSupports() {
        System.out.println("Sur quel support est l'album ?");
        System.out.println("1: Disque Compact");
        System.out.println("2: Disque Vinyle");
        System.out.println("3: Fichier numérique");
        System.out.print("Choix:");
        try {
            return scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Veuillez entrer le numéro d'une des options données.");
            scan.nextLine();
            return afficherSupports();
        }
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
        try {
            s = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Merci d'entrer un chiffre");
            scan.nextLine();
            return saisieInt(msg);
        }
        if (s < 0) {
            throw new SaisieInvalideException("La donnée entrée est invalide");
        }
        return s;
    }

    private double saisieTailleD() throws SaisieInvalideException {
        double s = 0;
        System.out.print("Saisissez la taille du fichier : ");
        try {
            s = scan.nextDouble();
            scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Merci d'entrer une taille valide (exemple : 34.5)");
            scan.nextLine();
            return saisieTailleD();
        }
        if (s <= 0) {
            throw new SaisieInvalideException("La taille du fichier doit être supérieure à 0.");
        }
        return s;
    }

    public String saisieAuteur() throws SaisieInvalideException {
        return (saisieStr("Saisissez le nom de l'auteur : "));
    }


    public String saisieNomA() throws SaisieInvalideException {
        return (saisieStr("Saisissez le nom de l'album : "));
    }

    public LocalDate saisieDate() throws SaisieInvalideException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = null;
        String dateD = saisieStr("Saisissez la date de parution (jj/mm/aaaa) : ");
        try {
            date = LocalDate.parse(dateD, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Format invalide. Exemple : 22/09/2026");
            return saisieDate();
        }
        return date;
    }

    public int saisieQuantite() throws SaisieInvalideException {
        return saisieInt("Saisissez le nombre d'exemplaires : ");

    }

    public String saisieNum() throws SaisieInvalideException {
        return saisieStr("Saisissez le numéro de l'album : ");
    }

    public String saisieType() throws SaisieInvalideException {
        return saisieStr("Saisissez le type de disque : ");
    }

    public String saisieFormat() throws SaisieInvalideException {
        return saisieStr("Saisissez le format du fichier : ");
    }

    public int saisieDuree() throws SaisieInvalideException {
        return saisieInt("Saisissez la durée de l'album : ");
    }

    public int saisieTaille() throws SaisieInvalideException {
        return saisieInt("Saisissez la taille du vinyle : ");
    }

    public void saisieAlbum(int support) throws SaisieInvalideException {
        String name = switch (support) {
            case 1 -> "Disque Compact";
            case 2 -> "Disque Vinyle";
            case 3 -> "Fichier numérique";
            default -> throw new SaisieInvalideException("Choix de support invalide : " + support);
        };
        System.out.println("Vous avez choisi : " + name);
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

    }

    public void viderDiscotheque() {
        GestionAlbum.viderDiscotheque();
    }


}
