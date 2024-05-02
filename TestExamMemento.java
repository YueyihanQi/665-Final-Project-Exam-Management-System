/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: TestExamMemento.java
 * Description: This class contains test cases to verify the functionality of the Exam Memento pattern.
 */

package edu.bu.met.cs665.Test;

import exammanagementsystem.exammanagement.Category;
import exammanagementsystem.exammanagement.Exam;
import exammanagementsystem.exammanagement.ExamStatus;
import exammanagementsystem.exammanagement.exammemento.ExamMemento;
import exammanagementsystem.exammanagement.questionfactory.*;

import exammanagementsystem.proctormanagement.Proctor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//A test class to verify the functionality of the Exam Memento pattern.
public class TestExamMemento {

    // Test case to verify that the proctor can manage exam states using memento.
    @Test
    public void testManageExamStates() {
        // Create a proctor
        Proctor proctor = new Proctor("John");

        // Create an exam
        Exam exam = new Exam("Exam1", Category.EXAM_1, null);

        // Start the exam
        proctor.startExam(exam);

        // Save the current state of the exam
        ExamMemento memento = exam.saveToMemento();

        // Modify the exam status
        exam.setStatus(ExamStatus.FINISHED);

        // Check if the exam status has been modified
        assertEquals(ExamStatus.FINISHED, exam.getStatus(), "Exam status should be finished");

        // Restore the exam status from the memento
        proctor.restoreExamStatus(exam);

        // Check if the exam status has been restored
        assertEquals(ExamStatus.IN_PROGRESS, exam.getStatus(), "Exam status should be in progress");
    }
}