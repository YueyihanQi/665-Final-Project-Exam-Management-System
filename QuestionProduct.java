/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: QuestionProduct.java
 * Description: Represents a generic interface for all types of questions.
 */

// QuestionProduct.java
package exammanagementsystem.exammanagement.questionfactory;

public interface QuestionProduct {
    // Displays the question to the user.
    void displayQuestion();

    // Grades the provided answer for the question.
    boolean gradeAnswer(Object answer);

    // Gets the content of the question.
    Object getContent();
}
