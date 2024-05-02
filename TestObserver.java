/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: TestObserver.java
 * Description: This class contains test cases to verify the functionality of the Observer pattern.
 */

package edu.bu.met.cs665.Test;

import exammanagementsystem.exammanagement.Category;
import exammanagementsystem.exammanagement.Exam;
import exammanagementsystem.exammanagement.ExamNotification;
import exammanagementsystem.exammanagement.ExamStatus;
import exammanagementsystem.exammanagement.questionfactory.*;
import exammanagementsystem.proctormanagement.Proctor;
import exammanagementsystem.studentmanagement.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class TestObserver {
    private Exam exam;
    private List<String> notifications;

    @BeforeEach
    void setUp() {
        // Create an exam
        exam = new Exam("Exam2", Category.EXAM_2, new QuestionFactory() {
            @Override
            public SingleChoice createSingleChoice(String content, String[] options, int correctOption) {
                return null;
            }

            @Override
            public MultipleChoice createMultipleChoice(String content, String[] options, int[] correctOptions) {
                return null;
            }

            @Override
            public FillTheBlank createFillTheBlank(String content, String correctAnswer) {
                return null;
            }

            @Override
            public EssayQuestion createEssayQuestion(String content) {
                return null;
            }
        });

        // Create a list to store notifications
        notifications = new ArrayList<>();
    }

    @Test
    void testObserverPattern() {
        // Create a proctor
        Proctor proctor = new Proctor("Proctor1");

        // Create a list of students
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("111", "Student1");
        Student student2 = new Student("222", "Student2");
        students.add(student1);
        students.add(student2);

        // Register students and proctor as observers
        students.forEach(exam::registerObserver);
        exam.registerObserver(proctor);

        // Simulate exam status changes
        exam.setStatus(ExamStatus.IN_PROGRESS);
        exam.setStatus(ExamStatus.FINISHED);



    }
}
