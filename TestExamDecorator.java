/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: TestExamDecorator.java
 * Description: Contains test cases for the TimerDecorator class.
 */

package edu.bu.met.cs665.Test;

import exammanagementsystem.exammanagement.Category;
import exammanagementsystem.exammanagement.Exam;
import exammanagementsystem.exammanagement.examdecorator.TimerDecorator;
import exammanagementsystem.exammanagement.questionfactory.ConcreteQuestionFactory;
import exammanagementsystem.exammanagement.questionfactory.QuestionFactory;
import exammanagementsystem.studentmanagement.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class TestExamDecorator {
    private Exam exam;
    private Student student;

    // Sets up the test environment before each test method.
    @BeforeEach
    public void setUp() {
        QuestionFactory questionFactory = new ConcreteQuestionFactory();

        exam = new Exam("Sample Exam", Category.EXAM_1, questionFactory);
        student = new Student("123", "Student1");
        student.setExamPermission(true);
    }


    // Tests the functionality of the TimerDecorator class.
    @Test
    public void testTimerDecorator() {
        // Create a timer decorator with a duration of 5 seconds
        TimerDecorator timerDecorator = new TimerDecorator(5000);

        // Start the timer
        timerDecorator.startTimer();

        // Wait for 10 seconds to ensure the timer has enough time to run
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the timer
        timerDecorator.stopTimer();

        // Check if the timer is still running
        assertFalse(timerDecorator.isRunning());
    }

    // Tests the functionality of the Exam class timer.
    @Test
    public void testTimer() {
        Object Category = null;

        // Start the timer for 5 seconds
        exam.startTimer(5000);

        // Check if the timer is running
        assertTrue(exam.isTimerRunning());

        // Wait for 10 seconds to ensure the timer has stopped
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check if the timer has stopped
        assertFalse(exam.isTimerRunning());
    }

}
