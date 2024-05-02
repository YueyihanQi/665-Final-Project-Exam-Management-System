/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: TimerDecorator.java
 * Description: Represents a timer decorator for exams.
 */

package exammanagementsystem.exammanagement.examdecorator;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDecorator implements ExamDecorator {
    private boolean isRunning;
    private Timer timer;
    private long duration;

    // Constructs a TimerDecorator with the specified duration.
    public TimerDecorator(long duration) {
        this.duration = duration;
        this.isRunning = false;
    }

    @Override
    public void decorate() {
        startTimer();
    }

    // Starts the timer.
    public void startTimer() {
        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                isRunning = false;
            }
        }, duration);
        isRunning = true;
    }

    // Checks if the timer is running.
    public boolean isRunning() {
        return isRunning;
    }

    // Stops the timer.
    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

}
