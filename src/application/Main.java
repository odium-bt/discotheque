package application;

public class Main {
    static void main(String[] args) {

        Controller c = new Controller();
        int choix = 0;

        c.afficherMenu();
        System.out.print("Choix:");
        choix = Controller.scan.nextInt();

        switch (choix) {
            case 1:
                // TODO Fonction ajout d'album
                c.ajouterDisque();
                break;
            case 2:
                // TODO
                c.supprimerDisque();
                break;
            case 3:
                c.afficherDiscotheque();
                break;
            case 4:
                c.viderDiscotheque();
                break;
            case 0:
                System.out.println("Fin du programme. Au revoir !");
                break;
            default:
                System.out.println("Choix invalide, veuillez réessayer.");
        }
    }

}
