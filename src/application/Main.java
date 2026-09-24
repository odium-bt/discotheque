package application;

import exceptions.AlbumDejaExistantException;

public class Main {
    static void main(String[] args) throws AlbumDejaExistantException {
        int choix;
        do {
            Controller c = new Controller();

            choix = c.afficherMenu();

            switch (choix) {
                case 1:
                    System.out.println("Sur quel support est l'album ?");
                    System.out.println("1: Disque Compact");
                    System.out.println("2: Disque Vinyle");
                    System.out.println("3: Fichier numérique");
                    int type = Controller.scan.nextInt();
                    switch (type) {
                        case 1:
                            c.ajouterDisque();
                            break;
                        case 2:
                            c.ajouterVinyle();
                            break;
                        case 3:
                            c.ajouterFile();
                            break;
                        default:
                            System.out.println("Choix invalide, veuillez réessayer.");
                    }
                    c.ajouterAlbum();
                    break;
                case 2:
                    // TODO Fonction supprimer disque
                    // c.supprimerDisque();
                    break;
                case 3:
                    // TODO Fonction affichage
                    // c.afficherDiscotheque();
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
        } while (choix < 0 || choix > 4);

        Controller.scan.close();
    }
}
