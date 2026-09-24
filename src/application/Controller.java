package application;

import exceptions.AlbumDejaExistantException;
import exceptions.SaisieInvalideException;
import modele.Album;
import modele.CompactDisque;
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
        String dateD = saisieStr("Saisissez la date de parution (jj/mm/aaaa) :");
        LocalDate date = null;
        do {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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

    public CompactDisque saisieDisque() throws SaisieInvalideException {
        String nomAlbum = saisieNomA();
        String a = saisieAuteur();
        LocalDate date = saisieDate();
        int quantite = saisieQuantite();
        String numero = saisieNum();
        String type = saisieType();

        return new CompactDisque(nomAlbum, a, date, quantite, numero,    type);
    }


    public void ajouterDisque() throws AlbumDejaExistantException, SaisieInvalideException {


        Album d = saisieDisque();

        GestionAlbum.creerDisque(d);
    }
}
