/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: SingleChoice.java
 * Description: Represents a single-choice question in the exam.
 */

package exammanagementsystem.exammanagement.questionfactory;



public class SingleChoice implements QuestionProduct {
    private String content;
    private String[] options;
    private int correctOption;

    // Constructs a SingleChoice object with the specified content, options, and correct option.
    public SingleChoice(String content, String[] options, int correctOption) {
        this.content = content;
        this.options = options;
        this.correctOption = correctOption;
    }

    // Displays the single-choice question to the user.
    @Override
    public void displayQuestion() {
        System.out.println("Single Choice Question: " + content);
        System.out.println("Choose one from: ");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    // Gets the content of the single-choice question.
    @Override
    public Object getContent() {
        return content;
    }

    // Grades the provided answer for the single-choice question.
    @Override
    public boolean gradeAnswer(Object answer) {
        if (!(answer instanceof Integer)) {
            return false;
        }
        int selectedOption = (int) answer;
        if (selectedOption == correctOption) return true;
        return false;
    }


}

