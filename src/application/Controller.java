package application;

import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;
import modele.Album;

import java.time.DateTimeException;
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

    public String saisie(String msg) {
        String s;
        do {
            System.out.print(msg);
            s = scan.nextLine();
        } while (s.isEmpty());
        return s;
    }

    public String saisieAuteur() {
        String a = saisieNom();
        return a;
    }

    public String saisieNom() {
        return (saisie("Saisissez le nom de l'auteur :"));
    }


    public String saisieNomD() {
        return (saisie("Saisissez le nom du disque :"));
    }

    public LocalDate saisieDate() {
        String dateD = saisie("Saisissez la date du disque (jj/mm/aaaa) :");
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


    public void supprimerAlbum() throws AlbumIntrouvableException, DiscothequeVideException {
        System.out.println("Quel album voulez-vous supprimer ?");
        String nomSupprime = saisieNomD();
        GestionAlbum.supprimerAlbum(nomSupprime);
    }
}
