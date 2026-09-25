package audio;

import exceptions.FichierAudioException;
import javazoom.jl.player.Player;
import modele.FichierNumerique;

import java.io.File;

public class LecteurMP3 implements Runnable {

        private FichierNumerique album;
        private volatile Player player;   // partagé entre deux threads
        private Thread thread;

        /** Vérifie le format (MP3) et l'existence du fichier,
         sinon lève FichierAudioException. */
        public boolean LecteurMp3(FichierNumerique album) throws FichierAudioException {
            File file = album.getFichier();

            if (!file.exists()) {
                throw new FichierAudioException("Le fichier n'existe pas");
            }
            if (!file.getName().endsWith(".mp3")) {
                throw new FichierAudioException("Le fichier n'est pas au format MP3");
            }
            return true;
        }

        /** Crée le thread (daemon) et le démarre.
         Ne fais rien si une lecture est déjà en cours. */
        public void demarrer() { /* TODO */ }

        /** Exécuté DANS le thread : ouvre le flux, crée le Player, appelle play(). */
        @Override
        public void run() { /* TODO */ }

        /** Arrête la lecture depuis un autre thread : player.close(). */
        public void arreter() { /* TODO */ }

        public boolean estEnCours() { /* TODO : thread.isAlive() */
            return false;
        }

        /** Bloque le thread appelant jusqu'à la fin de la lecture : join(). */
        public void attendreFin() throws InterruptedException { /* TODO */ }

        /** Position de lecture en millisecondes. */
        public int getPosition() { /* TODO */
            return 0;
        }
    }