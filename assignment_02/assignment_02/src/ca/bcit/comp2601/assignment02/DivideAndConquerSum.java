package ca.bcit.comp2601.assignment02;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

/**
 * DivideAndConquerSum class - Concurrency
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-11-28
 */
public class DivideAndConquerSum {
    private final static int MIN_NUM_THREAD;

    static {
        MIN_NUM_THREAD = 1;
    }

    /**
     * Sum a range of numbers. Uses ForkJoinPool to execute calculation in multiple threads
     * @param rangeStart first number in the range e.g. 1
     * @param rangeEnd last namber in the range e.g 3 -> (1, 2, 3)
     * @param numberOfThreads how many threads will be used to compute it
     * @return sum of the range of numbers
     */
    private static int sum(final int rangeStart, final int rangeEnd, final int numberOfThreads) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfThreads);
        try {
            return forkJoinPool.submit(() ->
                    IntStream.rangeClosed(rangeStart, rangeEnd)
                            .parallel()
                            .sum()
            ).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            // Do nothing
        }
    }

    /**
     * Asks the user for input to determine how much to compute while using threads
     * @throws InterruptedException is thrown when a thread is interrupted while it's waiting, sleeping...
     */
    public static void concurrentMain() throws InterruptedException {
        Scanner input;
        input = new Scanner(System.in);
        int rangeStart;
        int rangeEnd;
        int numberOfThreads;
        do {
            System.out.print("Enter the range start: ");
            rangeStart = input.nextInt();

            System.out.print("Enter the range end: ");
            rangeEnd = input.nextInt();

            System.out.print("Enter the number of threads: ");
            numberOfThreads = input.nextInt();

            if (rangeStart >= rangeEnd || numberOfThreads < MIN_NUM_THREAD) {
                System.out.println("Warning: range start should be less then range end." +
                        " Also number of threads should not be less then 1.");
            }
        } while (rangeStart >= rangeEnd || numberOfThreads < MIN_NUM_THREAD);

        int sum = DivideAndConquerSum.sum(rangeStart, rangeEnd, numberOfThreads);

        System.out.println(String.format("Sum of numbers in the range [%s, %s] found in %s threads is %s",
                rangeStart, rangeEnd, numberOfThreads, sum));
    }
}
