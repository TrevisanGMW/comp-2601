package ca.bcit.comp2601.lab5.monikaszucsguilherme;

/**
 * Main.java
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
public class Main {

    private static final int        FOR_LOOP_START_VALUE;
    private static final int        INITIAL_ARGUMENT;
    private static final int        SECONDARY_ARGUMENT;
    private static final int        REVERSE_REDUCED_LENGTH;
    private static final int        REVERSE_END_POSITION;
    private static final String     OPERATION_CONCAT;
    private static final String     OPERATION_REPEAT;
    private static final String     OPERATION_NTH;
    private static final String     OPERATION_REVERSE;

    static
    {
        FOR_LOOP_START_VALUE    = 0;
        INITIAL_ARGUMENT        = 0;
        SECONDARY_ARGUMENT      = 1;
        REVERSE_REDUCED_LENGTH  = 1;
        REVERSE_END_POSITION    = 0;
        OPERATION_CONCAT        = "concat";
        OPERATION_REPEAT        = "repeat";
        OPERATION_NTH           = "nth";
        OPERATION_REVERSE       = "reverse";
    }

    /**
     * @param args first the name of the operation then the second will be the number to be use in the operation
     */
    public static void main(final String[] args) {
        Dictionary dictionary;
        int size;

        dictionary = new Dictionary();
        size = dictionary.jaWords.size();

        Wordable wordy = (word, length) -> {
            StringBuilder answer;
            answer = new StringBuilder();

            if(word.equalsIgnoreCase(OPERATION_CONCAT)) {
                for(int i = FOR_LOOP_START_VALUE; i < length; i++) {
                    answer.append(dictionary.jaWords.get(i));
                }
            }
            if(word.equalsIgnoreCase(OPERATION_REPEAT)) {
                for(int i = FOR_LOOP_START_VALUE; i < size; i++) {
                    for(int j = FOR_LOOP_START_VALUE; j < length; j++) {
                        answer.append(dictionary.jaWords.get(i));
                    }
                }
            }

            if(word.equalsIgnoreCase(OPERATION_NTH)) {
                answer.append(dictionary.jaWords.get(length));
            }

            if(word.equalsIgnoreCase(OPERATION_REVERSE)) {
                for(int i = FOR_LOOP_START_VALUE; i < length - REVERSE_REDUCED_LENGTH; i++) {
                    for(int j = dictionary.jaWords.get(i).length() - REVERSE_REDUCED_LENGTH; j >= REVERSE_END_POSITION; j--){
                        answer.append(dictionary.jaWords.get(i).charAt(j));
                    }
                }
            }

            return answer.toString();
        }; // lambda expression

        if(args[INITIAL_ARGUMENT].equalsIgnoreCase(OPERATION_CONCAT)) {
            System.out.println(dictionary.getWords(args[INITIAL_ARGUMENT],size,wordy));
        } else if(args[INITIAL_ARGUMENT].equalsIgnoreCase(OPERATION_REPEAT)) {
            System.out.println(dictionary.getWords(args[INITIAL_ARGUMENT],
                    Integer.valueOf(args[SECONDARY_ARGUMENT]),wordy));
        } else if(args[INITIAL_ARGUMENT].equalsIgnoreCase(OPERATION_NTH)) {
            System.out.println(dictionary.getWords(args[INITIAL_ARGUMENT],
                    Integer.valueOf(args[SECONDARY_ARGUMENT]),wordy));
        } else if(args[INITIAL_ARGUMENT].equalsIgnoreCase(OPERATION_REVERSE)) {
            System.out.println(dictionary.getWords(args[INITIAL_ARGUMENT],size,wordy));
        }
        dictionary.jaWords.forEach(System.out::println);
    }
}