package application;

import exceptions.AlbumDejaExistantException;
import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;
import exceptions.SaisieInvalideException;

import static application.Controller.scan;

public class Main {
    static void main(String[] args) throws AlbumDejaExistantException, SaisieInvalideException {
        int choix = 0;
        do {
            try {
                Controller c = new Controller();

                choix = c.afficherMenu();
                scan.nextLine();

                switch (choix) {
                    case 1:
                        System.out.println("Sur quel support est l'album ?");
                        System.out.println("1: Disque Compact");
                        System.out.println("2: Disque Vinyle");
                        System.out.println("3: Fichier numérique");
                        int type = scan.nextInt();
                        scan.nextLine();
                        switch (type) {
                            case 1:
                                c.saisieAlbum(1);
                                break;
                            case 2:
                                c.saisieAlbum(2);
                                break;
                            case 3:
                                c.saisieAlbum(3);
                                break;
                            default:
                                System.out.println("Choix invalide, veuillez réessayer.");
                        }
                        break;
                    case 2:
                        // TODO Fonction supprimer disque
                        // c.supprimerDisque();
                        break;
                    case 3:
                        // TODO Fonction affichage
                        c.afficherDiscotheque();
                        break;
                    case 4:
                        // TODO Fonction suppression de tous les albums
                        // c.viderDiscotheque();
                        break;
                    case 0:
                        System.out.println("Fin du programme. Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }

            } catch (SaisieInvalideException e) {
                System.err.println(e.getMessage());
            }

        } while (choix != 0);

        scan.close();
    }
}
