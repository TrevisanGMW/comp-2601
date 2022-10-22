package ca.bcit.comp2601.lab05;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Dictionary Class - Holds English words that begin with the letters "ja"
 * @author Guilherme Trevisan & Monica Szucs
 * @version 0.0.1
 * @since 2022-10-22
 */
public class Dictionary {

    private final List<String> wordsStartingWithJa;
    private static final String OPERATION_NTH = "nth";

    String[] data = {"jab", "jabbed", "jabber", "jabbered", "jabbering", "jabbers", "jabberwocky", "jabbing", "jabot",
            "jabots", "jabs", "jacaranda", "jacarandas", "jacinth", "jack", "jackal", "jackals", "jackanapes",
            "jackanapeses", "jackass", "jackasses", "jackboot", "jackboots", "jackdaw", "jackdaws", "jacked", "jacket",
            "jacketed", "jacketing", "jackets", "jackhammer", "jackhammers", "jackie", "jacking", "jackknife",
            "jackpot", "jackpots", "jacks", "jackson", "jacksonville", "jaclyn", "jacob", "jacobean", "jacobian",
            "jacobin", "jacobins", "jacobite", "jacobites", "jacobs", "jacquard", "jacquards", "jacqueline", "jacques",
            "jactitation", "jactitations", "jactus", "jacuzzi", "jacuzzis", "jade", "jaded", "jadeite", "jadeites",
            "jades", "jading", "jaeger", "jaffa", "jag", "jagged", "jaggedly", "jaggedness", "jagger", "jags", "jaguar",
            "jaguars", "jai", "jail", "jailed", "jailer", "jailers", "jailhouse", "jailing", "jailor", "jailors",
            "jails", "jaipur", "jakarta", "jake", "jalopies", "jalopy", "jalousie", "jalousies", "jam", "jamaica",
            "jamaican", "jamaicans", "jamb", "jamboree", "jamborees", "jambs", "james", "jamey", "jamie", "jammed",
            "jamming", "jammy", "jams", "jan", "jane", "janeiro", "janet", "jangle", "jangled", "jangles", "jangling",
            "janice", "janitor", "janitorial", "janitors", "january", "januarys", "janus", "japan", "japanese",
            "japanned", "japanning", "japans", "jape", "japed", "japer", "japers", "japery", "japes", "japing",
            "japonica", "japonicas", "jar", "jardiniere", "jardinieres", "jarful", "jarfuls", "jargon", "jargons",
            "jarred", "jarring", "jarringly", "jarrow", "jars", "jasmine", "jasmines", "jason", "jasper", "jaspers",
            "jaundice", "jaundiced", "jaunt", "jaunted", "jauntier", "jauntiest", "jauntily", "jaunting", "jaunts",
            "jaunty", "java", "javanese", "javelin", "javelins", "jaw", "jawbone", "jawbones", "jawboning",
            "jawbreaker", "jawbreakers", "jawed", "jawing", "jaws", "jay", "jays", "jayvees", "jaywalk", "jaywalked",
            "jaywalker", "jaywalkers", "jaywalking", "jaywalks", "jazz", "jazzed", "jazzes", "jazzier", "jazziest",
            "jazzing", "jazzman", "jazzmen", "jazzy"};

    /**
     * Dictionary Constructor
     * Populates "wordsStartingWithJa" with the words found in the String array "data"
     */
    public Dictionary() {
        wordsStartingWithJa = Arrays.stream(data).toList();
    }

    /**
     * Get words function goes through all "ja" words and concatenates them using return value from Wordable
     * @param word word or modifier during operation
     * @param number number to be used by the Wordable operation
     * @param w function used to process every "ja" object
     * @return result of the Wordable operation
     */
    public String getWords(String word, int number, Wordable w){
        StringBuilder result;
        result = new StringBuilder();
        // Special Case
        if (word.equalsIgnoreCase(OPERATION_NTH)) {
            return wordsStartingWithJa.get(number);
        }
        // Default
        for (String s : wordsStartingWithJa) {
            result.append(w.createString(s, number));
        }
        return result.toString();
    }

    /**
     * printString method. Created to be used as an example of a method reference
     * @param word word to be printed (System.out.println)
     * @param number not used in this case, here to satisfy Wordable pattern
     * @return null
     */
    public static String printString(final String word, final int number){
        System.out.println(word);
        return null;
    }

    /**
     * returnString method. Created to be used as an example of a method reference
     * (in case requirement D meant return everything in one line)
     * @param word word to be printed (System.out.println)
     * @param number not used in this case, here to satisfy Wordable pattern
     * @return world + space (" ")
     */
    public static String returnString(final String word, final int number){
        return word + " ";
    }

    /**
     * Overloaded version returnString method. Created to be used as an example of a method reference
     * This version doesn't rely on the original "getWords" definition,
     * so it doesn't have unnecessary arguments and can returns void
     * @param word word to be printed (System.out.println)
     */
    public static void printString(final Object word){
        System.out.print(word + " ");
    }

    /**
     * Process words - Goes through words running provided lambda expression on them
     * @param c consumer lambda function
     */
    public void processWords(Consumer c){
        for (String string : wordsStartingWithJa) {
            c.accept(string);
        }
    }


}
