package ca.bcit.comp2601.assignment02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CountryList extends JFrame {
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
        INPUT_FILE = "files\\countries-and-capitals.txt";
        APP_TITLE = "Countries And Capitals";
        FRAME_WIDTH = 700;
        FRAME_HEIGHT = 400;
        INDEX_MAKE = 0;
        INDEX_MODEL = 1;
        INDEX_YEAR = 2;
        INDEX_ELECTRIC = 3;
        FRAME_VISIBILITY = true;
    }

    private static final ArrayList<String> countries = new ArrayList<>(); // Array list of cars (data read from a csv file)
    private final DefaultListModel<String> jListModel = new DefaultListModel<>(); //JList list model
    private JList<String> jListCars = new JList<>(jListModel); // JList of countries

    public CountryList() {
        super(APP_TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(getAppMenuBar());
        setVisible(FRAME_VISIBILITY);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(jListCars);
        jListCars.setLayoutOrientation(JList.VERTICAL);
        add(scrollPane);
    }
//
//        Scanner file = new Scanner(new File("files\\countries.txt"));
//
//        // Read the file
//        while(file.hasNextLine()) {
//            // Read a line
//            String line = file.nextLine();
//            System.out.println(line);
//        }
//
//        // Close the file
//        file.close();
//
//
//        // Populates JList during first run
//        for(String c : cars) {
//            jListModel.addElement(c);
//        }
//    }

//    private Map ingestCountryCapitalData(){
//
//    }

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

        JMenu searchMenu = new JMenu("Search");
        searchMenu.setMnemonic(KeyEvent.VK_S);
        menuBar.add(searchMenu);

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        menuBar.add(helpMenu);

        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener((event) -> JOptionPane.showMessageDialog(CountryList.this,
                "This is the Country Capitals app created as an assignment for COMP2601 - BCIT!",
                "About",
                JOptionPane.INFORMATION_MESSAGE));

        aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.SHIFT_DOWN_MASK));
        aboutMenuItem.setMnemonic(KeyEvent.VK_C);
        helpMenu.add(aboutMenuItem);
        return menuBar;
    }


//        JMenuItem fileItem1 = new JMenuItem("All Cars");
//
//        // Create menu item for the Search menu
//        JMenuItem searchItem1 = new JMenuItem("By Make");
//        searchItem1.setMnemonic(KeyEvent.VK_J);
//        searchMenu.add(searchItem1);
//
//        JMenuItem searchItem2 = new JMenuItem("By Model");
//        searchItem2.setMnemonic(KeyEvent.VK_F);
//        searchMenu.add(searchItem2);
//
//        JMenuItem searchItem3 = new JMenuItem("By Year");
//        searchItem3.setMnemonic(KeyEvent.VK_L);
//        searchMenu.add(searchItem3);
//
//        JMenuItem searchItem4 = new JMenuItem("Electric Cars");
//        searchItem4.setMnemonic(KeyEvent.VK_A);
//        searchMenu.add(searchItem4);
//
//        JMenuItem searchItem5 = new JMenuItem("Combustion Cars");
//        searchItem5.setMnemonic(KeyEvent.VK_D);
//        searchMenu.add(searchItem5);
//
//        fileMenu.add(fileItem1);
//        fileMenu.add(exitMenuItem);
//
//        // Add menu items to the Search menu
//        searchMenu.add(searchItem1);
//        searchMenu.add(searchItem2);
//        searchMenu.add(searchItem3);
//        searchMenu.add(searchItem4);
//        searchMenu.add(searchItem5);
//
//        // Add the menus to the menu bar
//        menuBar.add(fileMenu);
//        menuBar.add(searchMenu);
//        menuBar.add(helpMenu);
//
//        // Populate JListModel with all cars
//        fileItem1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Clear data from JList
//                jListModel.clear();
//
//                // Ask user to enter course name to search
//                for(Car c : cars) {
//                    jListModel.addElement(c);
//                }
//            }
//        });
//
//        // Add event listener to the first menu item of the Search menu
//        searchItem1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Ask user to enter course name to search
//                String searchQuery = JOptionPane.showInputDialog(null,
//                        "What Make are you looking for?",
//                        "Search by Make",
//                        JOptionPane.QUESTION_MESSAGE);
//
//                // Clear data from JList
//                jListModel.clear();
//
//                // Iterate through each course
//                for(Car c : cars) {
//                    if(c.getMake().toLowerCase().contains(searchQuery.toLowerCase())) {
//                        // Display the course details
//                        jListModel.addElement(c);
//                    }
//                }
//            }
//        });
//
//        // Add event listener to the second menu item of the Search menu
//        searchItem2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Ask user to enter instructor to search
//                String searchQuery = JOptionPane.showInputDialog(null,
//                        "Which Model are you looking for?",
//                        "Search by Model",
//                        JOptionPane.QUESTION_MESSAGE);
//
//                // Clear data from JList
//                jListModel.clear();
//
//                // Iterate through each course
//                for(Car c : cars) {
//                    // If instructor search for found
//                    if (c.getModel().toLowerCase().contains(searchQuery.toLowerCase())) {
//                        // Display the course details
//                        jListModel.addElement(c);
//                    }
//                }
//            }
//        });
//
//        // Add event listener to the third menu item of the Search menu
//        searchItem3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Ask user to enter course name to search
//                String searchQuery = JOptionPane.showInputDialog(null,
//                        "Which Year are you looking for?",
//                        "Search by Year",
//                        JOptionPane.QUESTION_MESSAGE);
//
//                // Clear data from JList
//                jListModel.clear();
//
//                // Iterate through each course
//                for(Car c : cars) {
//                    // If instructor search for found
//                    if (String.valueOf(c.getYear()).equalsIgnoreCase(searchQuery)) {
//                        // Display the course details
//                        jListModel.addElement(c);
//                    }
//                }
//            }
//        });
//
//        // Add event listener to the fourth menu item of the Search menu
//        searchItem4.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Clear data from JList
//                jListModel.clear();
//
//                for(Car c : cars) {
//                    // If year for found
//                    if(c.isElectric()) {
//                        // Display the course details
//                        jListModel.addElement(c);
//                    }
//                }
//            }
//        });
//
//        searchItem5.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Clear data from JList
//                jListModel.clear();
//
//                for(Car c : cars) {
//                    // If year for found
//                    if(!c.isElectric()) {
//                        // Display the course details
//                        jListModel.addElement(c);
//                    }
//                }
//            }
//        });
//        //Return the created menu bar
//        return menuBar;
//    }

//    /**
//     * Main method to run/build this program
//     * @param args - the command line arguments
//     */
//    public static void main(String[] args) throws FileNotFoundException {
//        // Open the courses.csv file
//        Scanner file = new Scanner(new File(INPUT_FILE));
//
//        // Read the file
//        while(file.hasNextLine()) {
//            // Read a line
//            String line = file.nextLine();
//            // Split the line string into tokens
//            String[] car = line.split(",");
//
//            String make = car[INDEX_MAKE];
//            String model = car[INDEX_MODEL];
//            int year = Integer.parseInt(car[INDEX_YEAR]);
//            boolean isElectric = Boolean.parseBoolean(car[INDEX_ELECTRIC]);
//
//            // Create an instance of Course and add to the array list
//            cars.add(new Car(make, model, year, isElectric));
//        }
//
//        // Close the file
//        file.close();
//
//        // Create an object of CourseSearchGUI
//        CarSearchGUI app = new CarSearchGUI();
//    }
}


