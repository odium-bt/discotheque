package application;

import java.util.Scanner;

public class Controller {
    static Scanner scan = new Scanner(System.in);
    static int choix = 0;

    /**
     * Affiche le menu principal
     */
    public void afficherMenu() {
        System.out.println("===== GESTION DE LA DISCOTHEQUE =====");
        System.out.println("1. Albums");
        System.out.println("2. Disques vinyles");
        System.out.println("");
        System.out.println("3. Fichiers numériques");
        System.out.println("6. Disques compacts");
        System.out.println("3. Afficher le contenu de la discotheque");
        System.out.println("4. Vider la discotheque");
        System.out.println("0. Quitter");

        System.out.print("Choix:");
        choix = Controller.scan.nextInt();
        switch (choix){
            case 4
        }
    }
}
