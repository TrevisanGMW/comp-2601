package ca.bcit.comp2601.assignment02;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CountryList {
    private static final String INPUT_FILE;
    private static final String APP_TITLE;
    private static final int FRAME_WIDTH;
    private static final int FRAME_HEIGHT;
    private static final int INDEX_MAKE;
    private static final int INDEX_MODEL;
    private static final int INDEX_YEAR;
    private static final int INDEX_ELECTRIC;
    private static final boolean FRAME_VISIBILITY;

    static {
        INPUT_FILE = "files\\countries.txt";
        APP_TITLE = "Countries";
        FRAME_WIDTH = 700;
        FRAME_HEIGHT = 400;
        INDEX_MAKE = 0;
        INDEX_MODEL = 1;
        INDEX_YEAR = 2;
        INDEX_ELECTRIC = 3;
        FRAME_VISIBILITY = true;
    }

    private static final ArrayList<String> contries = new ArrayList<>(); // Array list of cars (data read from a csv file)
    private final DefaultListModel<String> jListModel = new DefaultListModel<>(); //JList list model
//    private JList<String> jListCars = new JList<>(jListModel); // JList of countries

    public CountryList() {

    }
}
