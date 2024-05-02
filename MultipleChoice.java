/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: MultipleChoice.java
 * Description: Represents a multiple choice question in the exam.
 *              A concrete product in question factory.
 */

package exammanagementsystem.exammanagement.questionfactory;

public class MultipleChoice implements QuestionProduct {
    private String content;
    private String[] options;
    private int[] correctOptions;

    // Constructs a MultipleChoice object with the specified content, options, and correct options.
    public MultipleChoice(String content, String[] options, int[] correctOptions) {
        this.content = content;
        this.options = options;
        this.correctOptions = correctOptions;
    }

    // Displays the multiple choice question to the user.
    @Override
    public void displayQuestion() {
        System.out.println("Multiple Choice Question: " + content);
        System.out.println("Choose one or more from: ");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    // Gets the content of the multiple choice question.
    @Override
    public Object getContent() {
        return content;
    }

    // Grades the provided answer for the multiple choice question.
    @Override
    public boolean gradeAnswer(Object answer) {
        if (!(answer instanceof int[])) {
            return false;
        }
        int[] selectedOptions = (int[]) answer;
        if (selectedOptions.length != correctOptions.length) {
            return false;
        }
        for (int i = 0; i < selectedOptions.length; i++) {
            if (selectedOptions[i] != correctOptions[i]) {
                return false;
            }
        }
        return true;
    }

}


