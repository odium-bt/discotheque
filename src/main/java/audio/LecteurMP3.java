package audio;

import exceptions.FichierAudioException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import modele.Album;
import modele.FichierNumerique;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LecteurMP3 implements Runnable {

        private FichierNumerique album;
        private Player player;
        private Thread thread;

        public LecteurMP3(FichierNumerique album) throws FichierAudioException {

            if (album.getChemin() == null) {                       // ajouté ici
                throw new FichierAudioException("Aucun chemin défini pour cet album");
            }

            File file = album.getFichier();

            if (!file.exists()) {
                throw new FichierAudioException("Le fichier n'existe pas");
            }
            if (!file.getName().endsWith(".mp3")) {
                throw new FichierAudioException("Le fichier n'est pas au format MP3");
            }
            this.album = album;
        }

        public void demarrer() {
            if (!estEnCours()) {
                thread = new Thread(this, "Album : " + album.getNomAlbum());
                thread.setDaemon(true);
                thread.start();
            }
        }

        @Override
        public void run() {
            System.out.println("Début de lecture : " + Thread.currentThread().getName());

            try (FileInputStream flux = new FileInputStream(album.getFichier())) {
                player = new Player(flux);
                player.play();
            } catch (IOException e) {
                System.out.println("Erreur : " + e.getMessage());
            } catch (JavaLayerException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
            System.out.println("Fin de lecture : " + Thread.currentThread().getName());
        }

        public void arreter() {
            player.close();
        }

        public boolean estEnCours() {
            return thread != null && thread.isAlive();
        }

        public void attendreFin() throws InterruptedException {
            thread.join();
        }

        public int getPosition() {
            return player.getPosition();
        }
    }