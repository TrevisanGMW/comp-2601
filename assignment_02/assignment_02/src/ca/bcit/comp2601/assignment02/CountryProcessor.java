package ca.bcit.comp2601.assignment02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * CountryProcessor class
 *
 * Create a HashMap instance variable with country name as key, and its capital city name as value
 * (e.g. "Canada": "Ottawa"). Use streams and filters to create the following functions which do exactly what they say.
 * In all cases, before printing, collect the result into a java collection local variable:
 *
 * 1. printLongestCapitalCity()
 * 2. printShortestCountryName()
 * 3. printAllCountriesStartingWith(String substring)
 * 4. printLongestCombination() // longest combination of country name plus capital city name
 * 5. printHowManyLettersInCountries() // the total number of letters in all the country names put together
 * 6. printCapitalsWithThisManyLetters(int min, int max) // e.g. all capitals between 5 and 8 letters inclusive
 * 7. printAllCountriesThatDoNotEndWith(char letter)
 * 8. printAllCapitalsThatContainLetterIntoASingleStringNoSpaces(char letter)
 *                  // e.g. containing 'a': "CanadaChadArgentinaNewZealandAustralia…"
 *
 * ProcessCountries() that calls all eight of the following functions.
 * Use the data from the countries-and-capitals.txt file.
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-11-28
 */
public class CountryProcessor {
    private static final String              INPUT_FILE;
    private static final String              DELIMITER;
    private static final int                 OFFSET_COUNTRY;
    private static final int                 OFFSET_LAST_ELEMENT;
    private final Map<String, String>        countriesCapitals;

    static {
        INPUT_FILE          = "files\\countries-and-capitals.txt";
        DELIMITER           = ",";
        OFFSET_COUNTRY      = -1;
        OFFSET_LAST_ELEMENT = -1;
    }

    /**
     * CountryProcessor Constructor - Populates countriesCapitals hashMap
     * @throws FileNotFoundException if necessary input file is missing
     */
    public CountryProcessor() throws FileNotFoundException {

        countriesCapitals = new HashMap<String, String>();

        // Populate countriesCapitals with clean data
        Scanner file = new Scanner(new File(INPUT_FILE));
        while(file.hasNextLine()) {
            String line = file.nextLine();
            String countryCapitalArray[] = parseCountryCapitalLineAsArray(line);
            if (countryCapitalArray != null){
                countriesCapitals.put(countryCapitalArray[0], countryCapitalArray[1]);
            }
        }
        file.close();


        for (Object entry : countriesCapitals.entrySet()) {
            System.out.println(entry);
        }
    }

    /**
     * Parses Line data coming from a TXT file using the default comma as delimiter
     * Assumes that the pattern is country, capital
     * Since some countries can have commas, the parsing method works its way from the last element (capital -> country)
     * @param commaSeparatedLine a line containing country, capital
     *                           e.g. Congo, Republic of the,Brazzaville
     * @return a string array where the first element (0) is the country and the second (1) is the capital
     */
    private static String[] parseCountryCapitalLineAsArray(final String commaSeparatedLine){
        try{
            String country;
            String capital;
            int yearPublished;
            List<String> countryCapitalData;
            countryCapitalData = new ArrayList<>(List.of(commaSeparatedLine.split(DELIMITER)));
            capital = countryCapitalData.get(countryCapitalData.size()+OFFSET_COUNTRY);
            countryCapitalData.remove(countryCapitalData.size()+OFFSET_LAST_ELEMENT);
            country = String.join(DELIMITER, countryCapitalData);
            return new String[]{country, capital};
        } catch(Exception e) {
            return null;
        } finally {
            // Do nothing
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
