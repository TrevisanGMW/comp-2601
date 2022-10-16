package ca.bcit.comp2601.lab04.guilhermetrevisan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since   2022-09-16
 */
public class Driver {
    public static void main(String[] args) {
        List<MusicMedia> musicMedias;
        MusicMedia cd1;
        MusicMedia cd2;
        MusicMedia af1;
        MusicMedia af2;
        MusicMedia vr1;
        MusicMedia vr2;

        musicMedias = new ArrayList();
        cd1 = new CompactDisc("TitleCdOne", "ArtistCdOne", 5);
        cd2 = new CompactDisc("TitleCdTwo", "ArtistCdTwo", 10);
        af1 = new AudioFile("TitleFileOne", "ArtistFileOne", "FileNameOne.mp3", 320);
        af2 = new AudioFile("TitleFileTwo", "ArtistFileTwo", "FileNameTwo.wav", 256);
        vr1 = new VinylRecord("TitleVinylOne", "ArtistVinylOne", 3, 10, 100);
        vr2 = new VinylRecord("TitleVinylTwo", "ArtistVinylTwo");

        musicMedias.add(cd1);
        musicMedias.add(cd2);
        musicMedias.add(af1);
        musicMedias.add(af2);
        musicMedias.add(vr1);
        musicMedias.add(vr2);

        for (MusicMedia musicMediaObject : musicMedias) {
            System.out.println("Current Object: "  +musicMediaObject.toString()); // toString
            System.out.println("Reading Method: " + musicMediaObject.getReadingMethod()); // reading method
            musicMediaObject.play(); // Play
            if (musicMediaObject instanceof FileManager) {
                AudioFile audioFile;
                audioFile = (AudioFile) musicMediaObject;
                audioFile.save(audioFile.getFileName());
                audioFile.delete(audioFile.getFileName());
            }
            System.out.println("_____________________");
        }
    }
}