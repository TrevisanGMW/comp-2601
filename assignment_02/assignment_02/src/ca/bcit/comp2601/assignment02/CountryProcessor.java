package ca.bcit.comp2601.assignment02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * CountryProcessor class
 *
 * Create a HashMap instance variable with country name as key, and its capital city name as value
 * (e.g. "Canada": "Ottawa"). Use streams and filters to create the following functions which do exactly what they say.
 * In all cases, before printing, collect the result into a java collection local variable:
 *
 * ProcessCountries() that calls all eight stream functions.
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-11-28
 */
public class CountryProcessor {
    private static final String              INPUT_FILE;
    private static final String              DELIMITER;
    private static final String              SAMPLE_COUNTRIES_START_WITH;
    private static final int                 OFFSET_COUNTRY;
    private static final int                 OFFSET_LAST_ELEMENT;
    private static final int                 INDEX_COUNTRY;
    private static final int                 INDEX_CAPITAL;
    private static final int                 SAMPLE_CAPITALS_LENGTH_MIN;
    private static final int                 SAMPLE_CAPITALS_LENGTH_MAX;
    private static final char                SAMPLE_COUNTRIES_END_WITH;
    private static final char                SAMPLE_COUNTRIES_CONTAIN;
    private final Map<String, String>        countriesCapitals;

    static {
        INPUT_FILE                      = "files\\countries-and-capitals.txt";
        DELIMITER                       = ",";
        OFFSET_COUNTRY                  = -1;
        OFFSET_LAST_ELEMENT             = -1;
        INDEX_COUNTRY                   = 0;
        INDEX_CAPITAL                   = 1;
        // Sample values for "processCountries"
        SAMPLE_COUNTRIES_START_WITH     = "Co"; // printAllCountriesStartingWith
        SAMPLE_CAPITALS_LENGTH_MIN      = 4; // printCapitalsWithThisManyLetters
        SAMPLE_CAPITALS_LENGTH_MAX      = 6;
        SAMPLE_COUNTRIES_END_WITH       = 'a'; // printAllCountriesThatDoNotEndWith
        SAMPLE_COUNTRIES_CONTAIN        = 'y'; // printAllCountriesThatContainLetterIntoASingleStringNoSpaces
    }

    /**
     * CountryProcessor Constructor - Populates countriesCapitals hashMap
     * @throws FileNotFoundException if necessary input file is missing
     */
    public CountryProcessor() throws FileNotFoundException {
        countriesCapitals = new HashMap<>();
        // Populate countriesCapitals with clean data
        Scanner file = new Scanner(new File(INPUT_FILE));
        while(file.hasNextLine()) {
            String line = file.nextLine();
            String[] countryCapitalArray = parseCountryCapitalLineAsArray(line);
            if (countryCapitalArray != null){
                countriesCapitals.put(countryCapitalArray[INDEX_COUNTRY], countryCapitalArray[INDEX_CAPITAL]);
            }
        }
        file.close();
    }

    /**
     * Parses Line data coming from a TXT file using the default comma as delimiter
     * Assumes that the pattern is country, capital
     * Since some countries can have commas, the parsing method works its way from the last element (capital -> country)
     * @param commaSeparatedLine a line containing country, capital
     *                           e.g. "Congo, Republic of the,Brazzaville"
     * @return a string array where the first element (0) is the country and the second (1) is the capital
     */
    private static String[] parseCountryCapitalLineAsArray(final String commaSeparatedLine){
        try{
            String country;
            String capital;
            List<String> countryCapitalData;
            countryCapitalData = new ArrayList<>(List.of(commaSeparatedLine.split(DELIMITER)));
            capital = countryCapitalData.get(countryCapitalData.size()+OFFSET_COUNTRY);
            countryCapitalData.remove(countryCapitalData.size()+OFFSET_LAST_ELEMENT);
            country = String.join(DELIMITER, countryCapitalData);
            return new String[]{country, capital};
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // Do nothing
        }
    }

    /**
     * Print the longest capital (character length)
     * Uses "stream" to accomplish that
     */
    public void printLongestCapitalCity(){
        Optional<String> longest = countriesCapitals.values().stream()
                .filter(s -> s != null && !s.isBlank())
                .max(Comparator.comparing(String::length));

        longest.ifPresent(s-> System.out.println("Longest capital city is \"" + s + "\"."));
    }

    /**
     * Print the shortest country (character length)
     * Uses "stream" to accomplish that
     */
    public void printShortestCountryName(){
        Optional<String> shortest = countriesCapitals.entrySet().stream()
                .filter(m -> m.getKey() != null && !m.getKey().isBlank())
                .map(Map.Entry::getKey)
                .min(Comparator.comparing(String::length));

        shortest.ifPresent(s-> System.out.println("Shortest country name is \"" + s + "\"."));
    }

    /**
     * Print all countries starting with provided substring
     * @param substring substring that country starts with
     */
    public void printAllCountriesStartingWith(final String substring){
        List containingString = countriesCapitals.entrySet().stream()
                .filter(m->m.getKey() != null && !m.getKey().isBlank() &&
                        m.getKey().toLowerCase().startsWith(substring.toLowerCase()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Printing all countries starting with \"" + substring + "\".");
        containingString.forEach(System.out::println);
    }

    /**
     * Print longest combination of country name plus capital city name
     */
    public void printLongestCombination(){
        Optional<String> longestCombination = countriesCapitals.entrySet().stream()
                .filter(m -> !m.getKey().isBlank() && m.getKey() != null &&
                        !m.getValue().isBlank() && m.getValue() != null)
                .map(m-> m.getKey() + DELIMITER + " " + m.getValue())
                .max(Comparator.comparing(String::length));

        longestCombination.ifPresent(s-> System.out.println("Longest combination (capital+country) name is \"" + s + "\"."));
    }

    /**
     * Print the total number of letters in all the country names put together
     */
    public void printHowManyLettersInCountries(){
        String result = countriesCapitals.entrySet().stream()
                .filter(m -> m.getKey() != null && !m.getKey().isBlank())
                .map(map -> map.getValue())
                .collect(Collectors.joining());
        System.out.println("Number of letters in all the country names put together: " + result.length());
    }

    /**
     * Print all capitals between 5 and 8 letters inclusive
     * @param min minimum number of characters to be included
     * @param max maximum number of characters to be included
     */
    public void printCapitalsWithThisManyLetters(final int min, final int max){
        List matchingLength = countriesCapitals.values().stream()
                .filter(s->!s.isBlank() && s != null && s.length() >= min && s.length() <= max)
                .collect(Collectors.toList());

        System.out.println("Printing all capitals with within character range (min:" + min + ", max:" + max + ")");
        matchingLength.forEach(System.out::println);
    }

    /**
     * Print all countries that do not end with provided letter
     * @param letter letter to filter
     */
    public void printAllCountriesThatDoNotEndWith(final char letter){
        List containingString = countriesCapitals.entrySet().stream()
                .filter(m->m.getKey() != null && !m.getKey().isBlank() && !m.getKey().endsWith(String.valueOf(letter)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Printing all countries that do not end with \"" + letter + "\".");
        containingString.forEach(System.out::println);
    }

    /**
     * Print all countries that contain letter into a single string
     * e.g. containing 'a': "CanadaChadArgentinaNewZealandAustralia…"
     * (Even though this example shows countries, I'm assuming these were supposed to be capitals)
     * @param letter substring to find (should contain)
     */
    public void printAllCountriesThatContainLetterIntoASingleStringNoSpaces(char letter){
        String containingString = countriesCapitals.keySet().stream()
                .filter(s->s != null && !s.isBlank() && s.contains(String.valueOf(letter)))
                .sorted(Comparator.comparing(String::toString))
                .map(s->s.replaceAll(" ", ""))
                .collect(Collectors.joining());
        System.out.println("Printing all capitals that contain the letter \"" + letter + "\" combined.");
        System.out.println(containingString);
    }

    /**
     * Calls all eight stream and filters functions
     */
    public void processCountries(){
        printLongestCapitalCity();
        printShortestCountryName();
        printAllCountriesStartingWith(SAMPLE_COUNTRIES_START_WITH);
        printLongestCombination();
        printHowManyLettersInCountries();
        printCapitalsWithThisManyLetters(SAMPLE_CAPITALS_LENGTH_MIN, SAMPLE_CAPITALS_LENGTH_MAX);
        printAllCountriesThatDoNotEndWith(SAMPLE_COUNTRIES_END_WITH);
        printAllCountriesThatContainLetterIntoASingleStringNoSpaces(SAMPLE_COUNTRIES_CONTAIN);
    }

}
