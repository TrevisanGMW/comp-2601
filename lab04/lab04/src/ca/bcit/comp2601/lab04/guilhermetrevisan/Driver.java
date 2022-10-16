package ca.bcit.comp2601.lab04.guilhermetrevisan;


/**
 * See docs
 */
public class Driver {
    public static void main(String[] args) {
        // create a CompactDisc object and assign the address to a MusicMedia reference
        CompactDisc cd1;
        MusicMedia mm1;
        cd1 = new CompactDisc("TitleOne", "ArtistOne", 7);
        mm1 = cd1;

        // display the objects' field values
        System.out.println(cd1.toString());
        System.out.println(mm1.toString());

        // call the play() method.
        cd1.play();
        mm1.play();
    }
}