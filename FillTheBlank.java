/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: FillTheBlank.java
 * Description: Represents a fill the blank question in the exam.
 *              A concrete product in question factory.
 */

package exammanagementsystem.exammanagement.questionfactory;

public class FillTheBlank implements QuestionProduct {
    private String content;
    private String correctAnswer;

    // Constructs a FillTheBlank object with the specified content and correct answer.
    public FillTheBlank(String content, String correctAnswer) {
        this.content = content;
        this.correctAnswer = correctAnswer;
    }

    // Displays the fill the blank question to the user.
    @Override
    public void displayQuestion() {
        System.out.println("Fill the Blank Question: " + content);
        System.out.println("Enter your answer in the blank space provided.");
    }

    // Gets the content of the fill the blank question.
    @Override
    public Object getContent() {
        return content;
    }


    // Grades the provided answer for the fill the blank question.
    @Override
    public boolean gradeAnswer(Object answer) {
        if (!(answer instanceof String)) {
            return false;
        }
        String blankAnswer = (String) answer;
        if (blankAnswer == correctAnswer) return true;
        return false;
    }


}