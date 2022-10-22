package ca.bcit.comp2601.lab05;

/**
 * Main Class
 * @author Guilherme Trevisan & Monica Szucs
 * @version 0.0.1
 * @since 2022-10-22
 */
public class Main {
    private static final int ARGS_MIN_LENGTH = 1;
    private static final int ARGS_INDEX_OPERATION = 0;
    private static final int ARGS_INDEX_NUMBER = 1;
    private static final int EXIT_CODE_FAILURE = 0;
    private static final int DEFAULT_NUM_ARG = 0;
    private static final String DEFAULT_OPERATION_ARG = "";
    private static final String OPERATION_CONCAT = "concat";
    private static final String OPERATION_REVERSE = "reverse";
    private static final String OPERATION_REPEAT = "repeat";
    private static final String OPERATION_NTH = "nth";

    /**
     * Main Entry Point
     * Validates the provided args to guarantee that it's composed of "Operation" and "Number" (When necessary)
     * @param args operation number e.g. java main repeat 3
     */
    public static void main(final String[] args) {
        validateArgs(args); // Validates args (with some feedback)

        Wordable wordy;
        Dictionary d1;
        String result;
        int providedNumber; // If not provided or not necessary, it becomes DEFAULT_NUM_ARG

        d1 = new Dictionary();
        if (args.length > ARGS_MIN_LENGTH){
            providedNumber = Integer.parseInt(args[ARGS_INDEX_NUMBER]);
        } else {
            providedNumber = DEFAULT_NUM_ARG;
        }

        if (args[ARGS_INDEX_OPERATION].equalsIgnoreCase(OPERATION_REPEAT)){ //  b) "repeat"
            wordy = (s, n)->{
                StringBuilder out;
                out = new StringBuilder();
                for(int i = 0; i < n; i++){
                    out.append(s);
                }
                return out.toString();
            };
        } else if (args[ARGS_INDEX_OPERATION].equalsIgnoreCase(OPERATION_NTH)){ // c) "nth
            wordy = (s, n)-> s;
        } else if (args[ARGS_INDEX_OPERATION].equalsIgnoreCase(OPERATION_REVERSE)) { // d) "reverse"
            wordy = (s, n) -> {
                String out = "";
                char ch;
                for (int i = 0; i < s.length(); i++) {
                    ch = s.charAt(i); // extracts each character
                    out = ch + out; // adds each character in front of the output string
                }
                return out;
            };
        } else { // a) "concat" - DEFAULT
            wordy = (s, n) -> s;
        }

        // e) At the end of main(), print the String returned by Wordable.
        result = d1.getWords(args[ARGS_INDEX_OPERATION], providedNumber, wordy);
        System.out.println(result);

        // Then use a method reference to print the entire list of words.
        d1.getWords(DEFAULT_OPERATION_ARG, DEFAULT_NUM_ARG, Dictionary::printString);

        // In case the intended return needed to be in one single line:
        // System.out.println(d1.getWords(DEFAULT_OPERATION_ARGUMENT, DEFAULT_NUM_ARGUMENT, Dictionary::returnString));

        // In case another function/interface could be used (Using Consumer)
        // d1.processWords(Dictionary::printString);
    }

    /**
     * Validates the provided args to guarantee that it's composed of "Operation" and "Number" (When necessary)
     * @param args args received through commandline in main
     */
    public static void validateArgs(final String[] args){
        String validArguments;
        validArguments = "Valid arguments: \"concat\", \"reverse\", \"repeat\" or \"nth\"";
        // Validate first argument (must be known operation)
        if (args.length < ARGS_MIN_LENGTH) {
            System.out.println("Unable to proceed without commandline arguments.");
            System.out.println(validArguments);
            System.exit(EXIT_CODE_FAILURE);
        }

        // Using "repeat" or "nth", validate second argument
        if (args[ARGS_INDEX_OPERATION].equalsIgnoreCase(OPERATION_REPEAT) ||
                args[ARGS_INDEX_OPERATION].equalsIgnoreCase(OPERATION_NTH)) {
            if (args.length > ARGS_MIN_LENGTH) {
                try {
                    Integer.valueOf(args[ARGS_INDEX_NUMBER]);
                }
                catch(Exception e) {
                    System.out.println("Second argument must be and integer.");
                    System.exit(EXIT_CODE_FAILURE);
                }
            } else {
                System.out.println("This operation requires a second argument.");
                System.exit(EXIT_CODE_FAILURE);
            }
        } else if (args[ARGS_INDEX_OPERATION].equalsIgnoreCase(OPERATION_CONCAT) ||
                args[ARGS_INDEX_OPERATION].equalsIgnoreCase(OPERATION_REVERSE)){
            // Do nothing
        } else {
            System.out.println("\"" + args[ARGS_INDEX_OPERATION] + "\" is not a valid argument.");
            System.out.println(validArguments);
            System.exit(EXIT_CODE_FAILURE);
        }

    }
}