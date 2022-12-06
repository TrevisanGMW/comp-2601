package ca.bcit.comp2601.assignment02;

import ca.bcit.comp2601.assignment02.patterns.*;

/**
 * Tester class used to test design patterns
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
public class Tester {

    private static final double MPH_SPEED_TEST       = 268d;
    private static final double KMPH_EXCEPTED_SPEED  = 431.30312d;
    private static final double CONVERSION_THRESHOLD = 0.00001d;

    /**
     * Runs tests to confirm the usability of the following patterns:
     * PatternName: (Involved Elements)
     * Singleton: (PrimeMinister)
     * Adapter (Movable, MovableAdapter, MovableAdapterImpl, BugattiVeyron)
     * Command (TextFile, TextFileOperation, TextFileOperationExecutor, OpenTextFileOperation, SaveTextFileOperation)
     * Observer (NewsAgency, NewsChannel, Channel)
     */
    public void test(){
        // Singleton Tests ---------
        PrimeMinister pm1;
        PrimeMinister pm2;
        PrimeMinister pm3;
        PrimeMinister pm4;

        pm1 = PrimeMinister.getInstance("Name One");
        pm2 = PrimeMinister.getInstance("Name Two");
        pm3 = PrimeMinister.getInstance("Name Three");
        pm4 = PrimeMinister.getInstance("Name Four");

        System.out.println(pm1);
        System.out.println(pm2);
        System.out.println(pm3);
        System.out.println(pm4);

        // Adapter Tests ---------
        Movable bugattiVeyron = new BugattiVeyron(MPH_SPEED_TEST);
        MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);

        double mphSpeed;
        double kmphSpeed;
        mphSpeed = bugattiVeyron.getSpeed();
        kmphSpeed = bugattiVeyronAdapter.getSpeed();
        System.out.println("Bugatti Veryon speed in MPH: " + mphSpeed);
        System.out.println("Bugatti Veryon speed in KMPH: " + kmphSpeed);
        if (Math.abs(kmphSpeed - KMPH_EXCEPTED_SPEED) < CONVERSION_THRESHOLD){
            System.out.println("Conversion is within acceptable threshold! (Epsilon:" +
                    Math.abs(kmphSpeed - KMPH_EXCEPTED_SPEED) + ")");
        }

        // Command Tests ---------
        String openOut;
        String saveOut;
        TextFile fileOne = new TextFile("file1.txt");
        TextFile fileTwo = new TextFile("file2.txt");
        TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
        openOut = textFileOperationExecutor.executeOperation(new OpenTextFileOperation(fileOne));
        saveOut = textFileOperationExecutor.executeOperation(new SaveTextFileOperation(fileTwo));
        System.out.println(openOut);
        System.out.println(saveOut);

        // Observer Tests ---------
        String news;
        NewsAgency observable;
        NewsChannel observer;

        news = "Good News";
        observable = new NewsAgency();
        observer = new NewsChannel();

        observable.addObserver(observer);
        System.out.println("Setting news to \"" + news + "\" (Giving it to the observable)");
        observable.setNews(news);
        System.out.println("Getting value stored in the observer channel: \"" + observer.getNews() + "\"");
    }
}
