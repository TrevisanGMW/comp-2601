package ca.bcit.comp2601.assignment02;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * CountryList class
 * In a class called CountryList, displays all countries and their capitals in a JList (e.g. Canada: Ottawa),
 * in alphabetical order by country name. Use the data from the countries.txt file. When the user closes the window,
 * show the Main.main() menu.
 *
 * Clarification 1:
 *      As clarified in an email, "countries-and-capitals.txt" should be used instead of "countries.txt"
 *      This class was created with that data set pattern in mind (Country, Capital)
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-11-28
 */
public class CountryList extends JFrame {
    private static final String              INPUT_FILE;
    private static final String              APP_TITLE;
    private static final String              DELIMITER;
    private static final String              SEPARATOR_CAPITAL;
    private static final int                 FRAME_WIDTH;
    private static final int                 FRAME_HEIGHT;
    private static final int                 OFFSET_COUNTRY;
    private static final int                 OFFSET_LAST_ELEMENT;
    private static final boolean             FRAME_VISIBILITY;
    private static final List<String>        countriesCapitals;

    static {
        INPUT_FILE          = "files\\countries-and-capitals.txt";
        APP_TITLE           = "Countries And Capitals";
        DELIMITER           = ",";
        SEPARATOR_CAPITAL   = ": ";
        FRAME_WIDTH         = 700;
        FRAME_HEIGHT        = 400;
        OFFSET_COUNTRY      = -1;
        OFFSET_LAST_ELEMENT = -1;
        FRAME_VISIBILITY    = true;
        countriesCapitals   = new ArrayList<>();
    }

    private final DefaultListModel<String> jListModel = new DefaultListModel<>();
    private JList<String> jListCountryCapitals = new JList<>(jListModel);

    /**
     * CountryList Constructor - Builds GUI and populates it with provided data
     * @throws FileNotFoundException if necessary input file is missing
     */
    public CountryList() throws FileNotFoundException {
        super(APP_TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setJMenuBar(getAppMenuBar());
        setVisible(FRAME_VISIBILITY);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(jListCountryCapitals);
        jListCountryCapitals.setLayoutOrientation(JList.VERTICAL);
        add(scrollPane);

        // Populate countriesCapitals with clean data
        Scanner file = new Scanner(new File(INPUT_FILE));
        while(file.hasNextLine()) {
            String line = file.nextLine();
            String countryCapitalFormatter = parseCountryCapitalLine(line);
            if (countryCapitalFormatter != null){
                countriesCapitals.add(countryCapitalFormatter);
            }
        }
        file.close();

        // Populates JList during first run (with sorted data)
        Collections.sort(countriesCapitals);
        for(String c : countriesCapitals) {
            jListModel.addElement(c);
        }
    }

    /**
     * Parses Line data coming from a TXT file using the default comma as delimiter
     * Assumes that the pattern is country, capital
     * Since some countries can have commas, the parsing method works its way from the last element (capital -> country)
     * @param commaSeparatedLine a line containing country, capital
     *                           e.g. Congo, Republic of the,Brazzaville
     * @return a formatted string following this pattern: Country: Capital (e.g. Brazil: Brasilia)
     */
    private static String parseCountryCapitalLine(final String commaSeparatedLine){
        try{
            String country;
            String capital;
            int yearPublished;
            List<String> countryCapitalData;
            countryCapitalData = new ArrayList<>(List.of(commaSeparatedLine.split(DELIMITER)));
            capital = countryCapitalData.get(countryCapitalData.size()+OFFSET_COUNTRY);
            countryCapitalData.remove(countryCapitalData.size()+OFFSET_LAST_ELEMENT);
            country = String.join(DELIMITER, countryCapitalData);
            return country + SEPARATOR_CAPITAL + capital;
        } catch(Exception e) {
            return null;
        } finally {
            // Do nothing
        }
    }

    /**
     * Returns JMenuBar to display to attach to the frame.
     *
     * @return an object of JMenuBar
     */
    public JMenuBar getAppMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Create three menus
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F); // alt+F works too
        menuBar.add(fileMenu);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        exitMenuItem.addActionListener((event) -> System.exit(0)); // 0 means no errors
        fileMenu.add(exitMenuItem);

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        menuBar.add(helpMenu);

        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener((event) -> JOptionPane.showMessageDialog(CountryList.this,
                "This is the Country:Capitals App created for COMP2601 - Assignment 02",
                "About",
                JOptionPane.INFORMATION_MESSAGE));

        aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.SHIFT_DOWN_MASK));
        aboutMenuItem.setMnemonic(KeyEvent.VK_C);
        helpMenu.add(aboutMenuItem);
        return menuBar;
    }
}


