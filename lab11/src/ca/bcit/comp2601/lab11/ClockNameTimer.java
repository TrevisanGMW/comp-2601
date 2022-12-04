package ca.bcit.comp2601.lab11;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ClockNameTimer Class - As Lab11 (Timer Lab)
 * Adapter Class and Main were created inside this class to keep it simple.
 *
 * @author Guilherme Trevisan
 * @version 0.0.2
 * @since 2022-12-04
 */
public class ClockNameTimer {
    private static int            numberTimerNum;
    private static int            clockTimerNum;
    private static final Timer    clockTimer;
    private static final Timer    numberTimer;
    private static final Timer    nameTimer;
    private static final int      NUMBER_TIMER_STARTING_POINT;
    private static final int      CLOCK_TIMER_PERIOD;
    private static final int      NUMBER_TIMER_PERIOD;
    private static final int      NAME_TIMER_PERIOD;
    private static final int      DEFAULT_DELAY;
    private static final int      NAME_KILLER_DELAY;
    private static final int      NUMBER_CANCEL_LIMIT;
    private static final int      CLOCK_CANCEL_LIMIT;
    private static final String   NAME_TO_PRINT;

    static {
        clockTimer = new Timer();
        numberTimer = new Timer();
        nameTimer = new Timer();
        NUMBER_TIMER_STARTING_POINT = 1;
        CLOCK_TIMER_PERIOD = 1000;
        NUMBER_TIMER_PERIOD = 1000;
        NAME_TIMER_PERIOD = 1200;
        DEFAULT_DELAY = 0;
        NAME_KILLER_DELAY = 5100;
        NUMBER_CANCEL_LIMIT = 7;
        CLOCK_CANCEL_LIMIT = 4;
        NAME_TO_PRINT = "Guilherme Trevisan";
    }

    /**
     * Main - Program Entry Point
     * @param args commandline arguments
     */
    public static void main(final String[] args) {
        numberTimerNum = NUMBER_TIMER_STARTING_POINT; // Sets numberTimer to 1, so it doesn't start at zero
        RunnableTimerTask printTimeTask; // create tasks using the adapter class
        RunnableTimerTask printNumberTask;
        RunnableTimerTask printNameTask;
        printTimeTask = new RunnableTimerTask(ClockNameTimer::printTime);
        printNumberTask = new RunnableTimerTask(ClockNameTimer::printNumber);
        printNameTask = new RunnableTimerTask(ClockNameTimer::printName);
        clockTimer.scheduleAtFixedRate(printTimeTask, DEFAULT_DELAY, CLOCK_TIMER_PERIOD); // populate timers with tasks
        numberTimer.scheduleAtFixedRate(printNumberTask, DEFAULT_DELAY, NUMBER_TIMER_PERIOD); // and parameters
        nameTimer.scheduleAtFixedRate(printNameTask, DEFAULT_DELAY, NAME_TIMER_PERIOD);
        Timer nameKillerTimer = new Timer(); // create local timer scheduled to kill nameTimer after 5.1 seconds
        nameKillerTimer.schedule(new TimerTask() {
            /**
             * Override run to cancel name timer and itself (nameKillerTimer)
             */
            @Override
            public void run() {
                System.out.println("Cancel name after 5.1 seconds");
                nameTimer.cancel();
                nameKillerTimer.cancel();
            }
        }, NAME_KILLER_DELAY);

    }

    /**
     * Prints and increments a number
     * Kill the timer when it reaches NUMBER_CANCEL_LIMIT
     */
    public static void printNumber() {
        System.out.println("Number is " + numberTimerNum);
        numberTimerNum++;
        if (numberTimerNum > NUMBER_CANCEL_LIMIT) {
            numberTimer.cancel();
            System.out.println("Stopping the number after " + NUMBER_CANCEL_LIMIT + " prints");
        }
    }

    /**
     * Print time
     * Kill the timer when it reaches CLOCK_CANCEL_LIMIT
     */
    public static void printTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        System.out.println(new Date(System.currentTimeMillis()));

        clockTimerNum++;
        if (clockTimerNum >= CLOCK_CANCEL_LIMIT) {
            clockTimer.cancel();
            System.out.println("Stopping the clock after " + CLOCK_CANCEL_LIMIT + " prints");
        }
    }

    /**
     * Prints a name (NAME_TO_PRINT)
     */
    public static void printName() {
        System.out.println(NAME_TO_PRINT);
    }

    /**
     * Required Adapter Class
     * Used for timer to be able to call the same method during execution
     */
    private static class RunnableTimerTask extends TimerTask {
        private final Runnable runnable;

        /**
         * RunnableTimerTask Constructor
         * Initialize runnable
         * @param runnable runnable
         */
        public RunnableTimerTask(Runnable runnable) {
            this.runnable = runnable;
        }

        /**
         * Overrides (implements) run
         */
        @Override
        public void run() {
            runnable.run();
        }
    }
}