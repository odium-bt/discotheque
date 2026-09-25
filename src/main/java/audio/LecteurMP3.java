package audio;

import exceptions.FichierAudioException;
import modele.FichierNumerique;

import java.io.File;

public class LecteurMP3 implements Runnable {

        private final FichierNumerique album;
        private volatile Player player;   // partagé entre deux threads
        private Thread thread;

        /** Vérifie le format (MP3) et l'existence du fichier,
         sinon lève FichierAudioException. */
        public boolean LecteurMp3(FichierNumerique album) throws FichierAudioException {
            File file = album.getFichier();

            if (!file.exists()) {
                throw new FichierAudioException("Le fichier n'existe pas");
            }

            
        }

        /** Crée le thread (daemon) et le démarre.
         Ne fait rien si une lecture est déjà en cours. */
        public void demarrer() { /* TODO */ }

        /** Exécuté DANS le thread : ouvre le flux, crée le Player, appelle play(). */
        @Override
        public void run() { /* TODO */ }

        /** Arrête la lecture depuis un autre thread : player.close(). */
        public void arreter() { /* TODO */ }

        public boolean estEnCours() { /* TODO : thread.isAlive() */ }

        /** Bloque le thread appelant jusqu'à la fin de la lecture : join(). */
        public void attendreFin() throws InterruptedException { /* TODO */ }

        /** Position de lecture en millisecondes. */
        public int getPosition() { /* TODO */ }
    }