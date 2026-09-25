package application;

import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;
import exceptions.SaisieInvalideException;

import static application.Controller.scan;

public class Mainb {
    static void main() {
        int choix = 0;
        do {
            try {
                Controller c = new Controller();

                choix = c.afficherMenu();
                scan.nextLine();

                switch (choix) {
                    case 1:
                        int support;
                        do {
                            support = c.afficherSupports();
                            scan.nextLine();
                            switch (support) {
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
                        } while (support < 1 || support > 3);
                        break;
                    case 2:
                        c.supprimerAlbum();
                        break;
                    case 3:
                        c.listerAlbum();
                        break;
                    case 4:
                        c.viderDiscotheque();
                        break;
                    case 5:
                        c.rechercherAlbum();
                        break;
                    case 6:
                        // TODO Ecouter un album
                        //c.ecouterAlbum();
                        break;
                    // case ?:
                    //TODO Modifier la quantité d'un album
                    //case 7:
                    //TODO Lister les albums par support
                    //break;
                    //case 8:
                    //TODO Trier les albums (par auteurs ou par date)
                    //break;
                    //case 9:
                    //TODO Sauvegarder et recharger la discothèque dans un fichier texte
                    //break;
                    case 0:
                        System.out.println("Fin du programme. Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }

            } catch (SaisieInvalideException | DiscothequeVideException | AlbumIntrouvableException e) {
                System.err.println(e.getMessage());
            }

        } while (choix != 0);

        scan.close();
    }
}
