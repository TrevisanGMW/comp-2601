package ca.bcit.comp2601.assignment02;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountryProcessor {

    private Map countriesCapitals;
    private static final String INPUT_FILE;
    private static final String DELIMITER;
    private static final String BLANK_STRING;
    private static final String SPACE_STRING;
    private static final int    OFFSET_YEAR_PUBLISHED;
    private static final int    OFFSET_AUTHOR_NAME;
    private static final int    OFFSET_LAST_ELEMENTS;
    private static final int    OFFSET_DECADE;
    private static final int    INDEX_FIRST_LETTER;
    private static final int    OFFSET_DELIMITER_REMOVAL;
    private static final int    MAX_PERCENTAGE;
    private static final double DOUBLE_NORMALIZATION;

    static {
        INPUT_FILE               = "files\\countries-and-capitals.txt";
        DELIMITER                = ",";
        BLANK_STRING             = "";
        SPACE_STRING             = " ";
        OFFSET_YEAR_PUBLISHED    = -1;
        OFFSET_AUTHOR_NAME       = -2;
        OFFSET_LAST_ELEMENTS     = -1;
        OFFSET_DECADE            = 9;
        INDEX_FIRST_LETTER       = 0;
        OFFSET_DELIMITER_REMOVAL = 2;
        MAX_PERCENTAGE           = 100;
        DOUBLE_NORMALIZATION     = 1.0;
    }

    public CountryProcessor() throws FileNotFoundException {

        countriesCapitals = new HashMap<String, String>();

        // Charset changed to include French accents
        Scanner scanner = new Scanner(new File(INPUT_FILE), StandardCharsets.ISO_8859_1.toString());

        // Populate Novels List
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] countryCapital = line.split(",");
            countriesCapitals.put(countryCapital[0], countryCapital[1]);
        }
        scanner.close();

        for (Object entry : countriesCapitals.entrySet()) {
            System.out.println(entry);
        }
    }

    public void printLongestCapitalCity(){
//        List<String> authorsFiltered = novels.stream()
//                .filter(n->n.getYearPublished() >= firstYear && n.getYearPublished() <= lastYear)
//                .sorted(Comparator.comparing(Novel::getYearPublished))
//                .map(n -> n.getAuthorName())
//                .collect(Collectors.toList());
//        return authorsFiltered;
    }

}
