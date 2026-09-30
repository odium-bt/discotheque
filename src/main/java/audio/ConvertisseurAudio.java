package audio;

import exceptions.FichierAudioException;
import modele.FichierNumerique;
import outils.Ffmpeg;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConvertisseurAudio {
    public static void mp3VersAac(FichierNumerique album) throws FichierAudioException, IOException, InterruptedException {
        File entree = album.getFichier();

        if (!entree.getName().endsWith(".mp3")) {
            throw new FichierAudioException("Le fichier n'est pas au format MP3");
        }

        String nouveauChemin = entree.getName().substring(0, entree.getName().lastIndexOf(".")) + ".aac";
        File sortie = new File(entree.getParentFile(), nouveauChemin);

        System.out.println("Conversion en cours...");

        if (Ffmpeg.convertir(entree, sortie, List.of("-vn", "-c:a", "aac", "-b:a", "192k")) != 0) {
            throw new IOException("FFmpeg a échoué");
        }

        album.setFormat(".aac");

        System.out.println("Conversion terminée : " + album.getChemin());
    }
}
