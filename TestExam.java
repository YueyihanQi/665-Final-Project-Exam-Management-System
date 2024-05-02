/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: TestExam.java
 * Description: Contains test cases for the Exam class.
 */

package edu.bu.met.cs665.Test;

import exammanagementsystem.exammanagement.Category;
import exammanagementsystem.exammanagement.Exam;
import exammanagementsystem.exammanagement.questionfactory.ConcreteQuestionFactory;
import exammanagementsystem.exammanagement.questionfactory.QuestionFactory;
import exammanagementsystem.exammanagement.questionfactory.QuestionProduct;
import exammanagementsystem.studentmanagement.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExam {
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

    // Tests adding questions to the exam using factory pattern.
    @Test
    public void testAddQuestions() {
        exam.createSingleChoiceQuestion("Single Choice 1", new String[]{"T1, F1, F2, F3"}, 0);
        exam.createMultipleChoiceQuestion("Multiple Choice 1", new String[]{"T1, F1, T2, F2"}, new int[]{0,2});
        exam.createFillTheBlankQuestion("Fill the Blank 1", "Correct Answer");
        exam.createEssayQuestion("Essay Question1");

        assertEquals(4, exam.getQuestions().size());
    }


    // Tests removing questions from the exam.
    @Test
    public void testRemoveQuestions() {
        exam.createSingleChoiceQuestion("Single Choice 1", new String[]{"T1, F1, F2, F3"}, 0);
        exam.createMultipleChoiceQuestion("Multiple Choice 1", new String[]{"T1, F1, T2, F2"}, new int[]{0,2});
        exam.createFillTheBlankQuestion("Fill the Blank 1", "Correct Answer");
        exam.createEssayQuestion("Essay Question1");

        exam.removeQuestion("Essay Question1");

        assertEquals(3, exam.getQuestions().size());
    }

    // Tests grading the exam based on student answers.
    @Test
    public void testGradeExam() {
        exam.createSingleChoiceQuestion("Single Choice 1", new String[]{"T1, F1, F2, F3"}, 0);
        exam.createMultipleChoiceQuestion("Multiple Choice 1", new String[]{"T1, F1, T2, F2"}, new int[]{0,2});
        exam.createFillTheBlankQuestion("Fill the Blank 1", "CorrectAnswer");
        exam.createEssayQuestion("Essay Question1");

        // Student's answers
        Map<QuestionProduct, Object> studentAnswers = new HashMap<>();
        studentAnswers.put(exam.getQuestions().get(0), 0); // 单选题
        studentAnswers.put(exam.getQuestions().get(1), new int[]{0, 2});
        studentAnswers.put(exam.getQuestions().get(2), "CorrectAnswer");
        studentAnswers.put(exam.getQuestions().get(3), "Answer");

        // Grading
        int score = exam.gradeExam(student, studentAnswers);

        // Check if the total score is correct
        assertEquals(3, score);
    }
}
