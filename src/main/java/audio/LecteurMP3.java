package audio;

import exceptions.FichierAudioException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import modele.FichierNumerique;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LecteurMP3 implements Runnable {

    private final FichierNumerique album;
    private volatile Player player; // partagé entre deux threads
    private Thread thread;

    /**
     * Vérifie le format (MP3) et l'existence du fichier,
     * sinon lève FichierAudioException.
     */
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

    /**
     * Crée le thread (daemon) et le démarre.
     * Ne fais rien si une lecture est déjà en cours.
     */
    public void demarrer() {
        if (!estEnCours()) {
            thread = new Thread(this, "Lecteur-" + album.getNomAlbum());
            thread.setDaemon(true);
            thread.start();
        }
    }

    /**
     * Exécuté DANS le thread : ouvre le flux, crée le Player, appelle play().
     */
    @Override
    public void run() {
        System.out.println("Début de lecture : " + Thread.currentThread().getName());

        try (FileInputStream flux = new FileInputStream(album.getFichier())) {
            this.player = new Player(flux);
            player.play();
        } catch (IOException | JavaLayerException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        System.out.println("Fin de lecture : " + Thread.currentThread().getName());
    }

    /**
     * Arrête la lecture depuis un autre thread : player.close().
     */
    public void arreter() {
        player.close();
    }

    public boolean estEnCours() {
        return thread != null && thread.isAlive();
    }

    /**
     * Bloque le thread appelant jusqu'à la fin de la lecture : join().
     */
    public void attendreFin() throws InterruptedException {
        thread.join();
    }

    /**
     * Position de lecture en millisecondes.
     */
    public int getPosition() {
        return player.getPosition();
    }
}