/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: QuestionFactory.java
 * Description: Represents an abstract factory interface for creating different types of questions.
 */


package exammanagementsystem.exammanagement.questionfactory;

public interface QuestionFactory {
    // Creates questions based on the attributes of different question types.
    SingleChoice createSingleChoice(String content, String[] options, int correctOption);
    MultipleChoice createMultipleChoice(String content, String[] options, int[] correctOptions);
    FillTheBlank createFillTheBlank(String content, String correctAnswer);
    EssayQuestion createEssayQuestion(String content);
}
