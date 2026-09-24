package application;

public class Main {
    static void main(String[] args) {
        int choix;
        do {
            Controller c = new Controller();

            choix = c.afficherMenu();

            switch (choix) {
                case 1:
                    // TODO Fonction ajout d'album
                    // c.ajouterDisque();
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
