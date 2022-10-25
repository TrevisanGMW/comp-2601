package ca.bcit.comp2601.lab5.monikaszucsguilherme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Dictionary.java
 *
 * COMP 2601 - CRN: 48065
 * Friday evenings, Fall 2022
 * Lab #5
 *
 * @author Monika Szucs
 * @author Guilherme Trevisan
 * @version 1.1
 *
 */
public class Dictionary {
    List<String> jaWords;

    /**
     * Dictionary Constructor
     */
    Dictionary() {
        jaWords = new ArrayList<>();
        String[] data = {
                "jab", "jabbed", "jabber", "jabbered", "jabbering", "jabbers", "jabberwocky",
                "jabbing", "jabot", "jabots", "jabs", "jacaranda", "jacarandas", "jacinth",
                "jack", "jackal", "jackals", "jackanapes","jackanapeses", "jackass","jackasses",
                "jackboot", "jackboots", "jackdaw", "jackdaws", "jacked", "jacket", "jacketed",
                "jacketing", "jackets", "jackhammer", "jackhammers", "jackie", "jacking",
                "jackknife", "jackpot", "jackpots", "jacks", "jackson", "jacksonville", "jaclyn",
                "jacob", "jacobean", "jacobian", "jacobin", "jacobins", "jacobite", "jacobites",
                "jacobs", "jacquard", "jacquards", "jacqueline", "jacques", "jactitation",
                "jactitations", "jactus", "jacuzzi", "jacuzzis", "jade", "jaded", "jadeite",
                "jadeites", "jades", "jading", "jaeger", "jaffa", "jag", "jagged", "jaggedly",
                "jaggedness", "jagger", "jags", "jaguar", "jaguars", "jai", "jail", "jailed",
                "jailer", "jailers", "jailhouse", "jailing", "jailor", "jailors", "jails", "jaipur",
                "jakarta", "jake", "jalopies", "jalopy", "jalousie", "jalousies", "jam", "jamaica",
                "jamaican", "jamaicans", "jamb", "jamboree", "jamborees", "jambs", "james", "jamey",
                "jamie", "jammed", "jamming", "jammy", "jams", "jan", "jane", "janeiro", "janet",
                "jangle", "jangled", "jangles", "jangling", "janice", "janitor", "janitorial",
                "janitors", "january", "januarys", "janus", "japan", "japanese", "japanned",
                "japanning", "japans", "jape", "japed", "japer", "japers", "japery", "japes",
                "japing", "japonica", "japonicas", "jar", "jardiniere", "jardinieres", "jarful",
                "jarfuls", "jargon", "jargons", "jarred", "jarring", "jarringly", "jarrow",
                "jars", "jasmine", "jasmines", "jason", "jasper", "jaspers", "jaundice", "jaundiced",
                "jaunt", "jaunted", "jauntier", "jauntiest", "jauntily", "jaunting", "jaunts", "jaunty",
                "java", "javanese", "javelin", "javelins", "jaw", "jawbone", "jawbones", "jawboning",
                "jawbreaker", "jawbreakers", "jawed", "jawing", "jaws", "jay", "jays", "jayvees",
                "jaywalk", "jaywalked", "jaywalker", "jaywalkers", "jaywalking", "jaywalks",
                "jazz", "jazzed", "jazzes", "jazzier", "jazziest", "jazzing", "jazzman", "jazzmen",
                "jazzy"
        };
        jaWords = Arrays.stream(data).toList();
    }

    /**
     * @param word the word passed in the argument
     * @param number the number of words
     * @param w referencing the interface Wordable to get exact formatting
     * @return the String of the word
     */
    public String getWords(final String word, final int number, final Wordable w) {
        return w.createString(word, number);
    }
}