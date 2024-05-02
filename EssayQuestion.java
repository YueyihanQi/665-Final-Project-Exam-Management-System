/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: EssayQuestion.java
 * Description: Represents an essay question in the exam.
 *              A concrete product in question factory.
 */

package exammanagementsystem.exammanagement.questionfactory;

public class EssayQuestion implements QuestionProduct {
    private String content;

    // Constructs an EssayQuestion object with the specified content.
    public EssayQuestion(String content) {
        this.content = content;
    }

    // Displays the essay question to the student.
    @Override
    public void displayQuestion() {
        System.out.println("Essay Question: " + content);
        System.out.println("Write your answer in the space provided.");
    }

    // Gets the content of the essay question.
    @Override
    public Object getContent() {
        return content;
    }

    // Grades the provided answer for the essay question.
    // Since essay questions require manual grading, this method always returns false.
    @Override
    public boolean gradeAnswer(Object answer) {
        if (!(answer instanceof String)) {
            return false;
        }
        System.out.println("Essay Question Waiting for grading...");
        return false;
    }

}