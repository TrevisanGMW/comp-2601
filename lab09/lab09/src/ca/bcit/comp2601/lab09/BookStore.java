package ca.bcit.comp2601.lab09;

import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * BookStore Class
 *
 * @author Guilherme Trevisan, Monika Szucs, Davood Tabrizi Nejad
 * @version 0.0.1
 * @since 2022-11-18
 */
public class BookStore {
    private final String bookStoreName;
    private static List<Novel> novels;
    private static final String INPUT_FILE;
    private static final String DELIMITER_COMMA;
    private static final String BLANK_STRING;
    private static final int OFFSET_YEAR_PUBLISHED;
    private static final int OFFSET_AUTHOR_NAME;
    private static final int OFFSET_LAST_ELEMENTS;
    private static final int OFFSET_DECADE;
    private static final int INDEX_FIRST_LETTER;
    private static final int OFFSET_DELIMITER_REMOVAL;
    private static final int MAX_PERCENTAGE;
    private static final double DOUBLE_NORMALIZATION;

    static {
        novels = new ArrayList<>();
        INPUT_FILE = "files\\data_lab09.csv";
        DELIMITER_COMMA = ",";
        BLANK_STRING = "";
        OFFSET_YEAR_PUBLISHED = -1;
        OFFSET_AUTHOR_NAME = -2;
        OFFSET_LAST_ELEMENTS = -1;
        OFFSET_DECADE = 9;
        INDEX_FIRST_LETTER = 0;
        OFFSET_DELIMITER_REMOVAL = 2;
        MAX_PERCENTAGE = 100;
        DOUBLE_NORMALIZATION = 1.0;
    }

    /**
     * Default Constructor for a BookStore
     *
     * @param bookStoreName name of bookstore
     * @throws FileNotFoundException throws exception if provided file is not found
     */
    public BookStore(final String bookStoreName) throws FileNotFoundException {
        this.bookStoreName = bookStoreName;

        // Charset changed to include French accents
        Scanner scanner = new Scanner(new File(INPUT_FILE), StandardCharsets.ISO_8859_1.toString());

        // Populate Novels List
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Novel newNovel = parseNovelData(line);
            if (newNovel != null){
                novels.add(newNovel);
            } else {
                // Do nothing
            }
        }
        scanner.close();
    }

    /**
     * Getter bookStoreName
     *
     * @return the name of bookstore
     */
    public String getBookStoreName() {
        return bookStoreName;
    }

    /**
     * Program Entry Point
     *
     * @param args commandline arguments (not used for anything in this case)
     */
    public static void main(final String[] args) throws FileNotFoundException {
        BookStore bs;
        bs = new BookStore("BCIT Books");

        //printAllNovels(); // Testing Ingested Data

        System.out.println("Printing all book titles in uppercase:");
        printAllTitles();

        System.out.println("Printing all book titles that contain the word \"God\" in their title:");
        printBookTitle("God");

        System.out.println("Printing all book titles in alphabetical order:");
        printTitlesInAlphaOrder();

        System.out.println("Printing all book titles grouped by decades (between 2000 and 2009)");
        printGroupByDecade(2000);

        System.out.println("Printing the book with the longest title:");
        getLongest();

        System.out.println("Checking if any books were written in the year 2000:");
        boolean isBookFound = isThereABookWrittenBetween(2000);
        System.out.println("Were books written in the year 2000? : " + isBookFound);

        System.out.println("Checking how many books contain the word \"God\" in their title:");
        int novelsContainingWord = howManyBooksContain("God");
        System.out.println(novelsContainingWord + " books contain the word \"God\" in their title." );

        System.out.println("Calculating the percentage of books written in between 2000 and 2009");
        double percentageWritten = whichPercentWrittenBetween(2000,2009);
        System.out.println(percentageWritten + "% of the available books were written between 2000 and 2009.");

        System.out.println("Finding the oldest book in the bookstore:");
        Novel oldestBook = getOldestBook();
        System.out.println("The oldest book in the bookstore is: " + oldestBook);

        System.out.println("Getting a list of all books whose title is this length of 8:");
        List booksWithLength = getBooksThisLength(8);
        booksWithLength.forEach(n-> System.out.println(n.toString()));
    }

    /**
     * Prints all titles in UPPERCASE
     */
    private static void printAllTitles(){
        novels.forEach(n-> System.out.println(n.getTitle().toUpperCase()));
    }

    /**
     * Prints all titles that match the specified parameter
     * @param title title used in the filter
     */
    private static void printBookTitle(final String title){
        List<Novel> novelsContaining = novels.stream()
                .filter(n->n.getTitle().contains(title))
                .collect(Collectors.toList());
        novelsContaining.forEach(n-> System.out.println(n.getTitle()));
    }

    /**
     * Prints all titles in alphabetical order, A-Z
     */
    private static void printTitlesInAlphaOrder(){
        List<Novel> novelsContaining = novels.stream()
                .sorted(Comparator.comparing(n->n.getTitle().replaceAll("\"",BLANK_STRING)))
                .collect(Collectors.toList());
        novelsContaining.forEach(n-> System.out.println(n.getTitle()));
    }

    /**
     * Prints all books for the inputted decade IE 2000s -> print all book titles from 2000 to 2009
     * @param decade year when the decade starts e.g. 2000 will contain 2000 to 2009
     */
    private static void printGroupByDecade(final int decade){
        int maxYear = decade + OFFSET_DECADE;
        Map<Integer, List<Novel>> novFiltered = novels.stream()
                .filter(n->n.getYearPublished() >= decade && n.getYearPublished() <= maxYear)
                .sorted(Comparator.comparing(Novel::getYearPublished))
                .collect(Collectors.groupingBy(Novel::getYearPublished));
;
        novFiltered.forEach((yearPublished, novels)->
        {
            System.out.print(yearPublished + " : ");
            String titleList;
            titleList = BLANK_STRING;
            for (Novel novel: novels) {
                titleList += ((novel.getTitle() + ", "));
            }
            titleList = titleList.substring(INDEX_FIRST_LETTER, titleList.length()-OFFSET_DELIMITER_REMOVAL);
            System.out.print(titleList + System.lineSeparator());
        });
    }

    /**
     * Find the longest title in the bookstore
     */
    private static void getLongest(){
        Optional<Novel>longest = novels.stream()
                .filter(n->!n.getTitle().isBlank())
                .max(Comparator.comparing(n->n.getTitle().length()));
        longest.ifPresent(n-> System.out.println("Longest book title is " + n.getTitle()));
    }

    /**
     * Returns true or false depending on finding books in specified year
     * @param year year to find books
     * @return true or false if a book is found
     */
    private static boolean isThereABookWrittenBetween(final int year){
        boolean isBookFound = novels.stream()
                .anyMatch(n->n.getYearPublished() == year);
        return isBookFound;
    }

    /**
     * Returns the amount of Books that contain this word in their title
     * @param word word to look for
     * @returns number of books with provided word in title
     */
    private static int howManyBooksContain(final String word){
        List<Novel> novelsContaining = novels.stream()
                .filter(n->n.getTitle().contains(word))
                .collect(Collectors.toList());
        return novelsContaining.size();
    }

    /**
     * What percentage of the books were written between these two years (inclusive)?
     * @param first starting year e.g. 2000
     * @param last ending year e.g. 2009 (result from 2000 to 2009)
     * @return
     */
    private static double whichPercentWrittenBetween(final int first, final int last){
        int numBooks = novels.size();
        List<Novel> novFiltered = novels.stream()
                .filter(n->n.getYearPublished() >= first && n.getYearPublished() <= last)
                .sorted(Comparator.comparing(Novel::getYearPublished))
                .collect(Collectors.toList());
        double percentage = DOUBLE_NORMALIZATION * novFiltered.size() / numBooks * MAX_PERCENTAGE;
        return percentage;
    }

    /**
     * Returns the oldest book
     * @returns oldest book
     */
    private static Novel getOldestBook(){
        Optional<Novel> oldest = novels.stream()
                .min(Comparator.comparing(Novel::getYearPublished));
        return oldest.get();
    }

    /**
     * Returns a List of all books whose title is this length
     * @param titleLength length of character in book's title
     * @return a list of novels that match the provided length
     */
    private static List<Novel> getBooksThisLength(final int titleLength){
        List<Novel> filteredNovels = novels.stream()
                .filter(n->(n.getTitle().length()==titleLength))
                .collect(Collectors.toList());
        return filteredNovels;
    }

    /**
     * Method created to check ingested data. It prints all novels and their fields
     */
    private static void printAllNovels(){
        novels.forEach(n-> System.out.println(n.toString()));
    }

    /**
     * Helper method used to remove non-printable characters from strings
     * @param inputString string to be cleaned
     * @return string without non-printable characters
     */
    private static String removeNonPrintableChars(final String inputString){
        String result;
        result = inputString.replaceAll("[^\\x00-\\x7F]", BLANK_STRING); // strips off all non-ASCII characters
        result = result.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", BLANK_STRING); // ASCII control characters
        result = result.replaceAll("\\p{C}", BLANK_STRING); // removes non-printable characters from Unicode
        return result.trim();
    }

    /**
     * Parses Line data coming from a CSV file using the default comma as delimiter
     * Assumes that the pattern is bookTitle(string), authorName(string) , yearPublished(int)
     * Since book title can have commas, the parsing method works its way from the last element
     * @param commaSeparatedLine a line containing bookTitle, authorName, yearPublished
     *                           e.g. "Are You There God? It's Me, Margaret.,Judy Blume,1970"
     * @return a Novel if all necessary parameters are valid. Null if it failed
     */
    private static Novel parseNovelData(final String commaSeparatedLine){
        try{
            String title;
            String authorName;
            int yearPublished;
            List<String> novelData;
            novelData = new ArrayList<>(List.of(commaSeparatedLine.split(DELIMITER_COMMA)));
            yearPublished = Integer.parseInt(novelData.get(novelData.size()+OFFSET_YEAR_PUBLISHED));
            authorName = novelData.get(novelData.size()+OFFSET_AUTHOR_NAME);
            novelData.remove(novelData.size()+OFFSET_LAST_ELEMENTS);
            novelData.remove(novelData.size()+OFFSET_LAST_ELEMENTS);
            title = removeNonPrintableChars(String.join(DELIMITER_COMMA, novelData));
            return new Novel(title, authorName, yearPublished);
        } catch(Exception e) {
            return null;
        } finally {
            // Do nothing
        }
    }
}