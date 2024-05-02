/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: TestProctor.java
 * Description: This class contains test cases to verify the functionality of the Proctor class.
 */

package edu.bu.met.cs665.Test;

import exammanagementsystem.exammanagement.Category;
import exammanagementsystem.exammanagement.Exam;
import exammanagementsystem.exammanagement.ExamStatus;
import exammanagementsystem.proctormanagement.Proctor;
import exammanagementsystem.studentmanagement.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProctor {

    @Test
    public void testStartExam() {
        Proctor proctor = new Proctor("Proctor1");
        Exam exam = new Exam("Exam3", Category.EXAM_3, null);
        proctor.startExam(exam);
        assertEquals(ExamStatus.IN_PROGRESS, exam.getStatus(), "Exam should be in progress after starting");
    }

    @Test
    public void testEndExam() {
        Proctor proctor = new Proctor("Proctor1");
        Exam exam = new Exam("Exam3", Category.EXAM_3, null);
        proctor.endExam(exam);
        assertEquals(ExamStatus.FINISHED, exam.getStatus(), "Exam should be finished after ending");
    }

    @Test
    public void testNotifyStudents() {
        // Create a Proctor object
        Proctor proctor = new Proctor("Proctor1");

        // Create an Exam object
        Exam exam = new Exam("Exam4", Category.EXAM_4, null);

        // Create 2 Students object
        Student student1 = new Student("111", "Student1");
        Student student2 = new Student("222", "Student2");

        // Set exam permissions for students
        student1.setExamPermission(true);
        student2.setExamPermission(true);

        // Register students as observers
        exam.registerObserver(student1);
        exam.registerObserver(student2);

        // Use the Proctor object to update the exam status to IN_PROGRESS
        proctor.update(exam);


    }




}

