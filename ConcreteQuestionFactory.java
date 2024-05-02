/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: ConcreteQuestionFactory.java
 * Description: Represents a concrete implementation of the QuestionFactory interface.
 *              This factory is responsible for creating specific types of questions.
 */

package exammanagementsystem.exammanagement.questionfactory;

public class ConcreteQuestionFactory implements QuestionFactory {

    // Creates different types questions with the specified content, options, and correct option.
    @Override
    public SingleChoice createSingleChoice(String content, String[] options, int correctOption) {
        return new SingleChoice(content, options, correctOption);
    }

    @Override
    public MultipleChoice createMultipleChoice(String content, String[] options, int[] correctOptions) {
        return new MultipleChoice(content, options, correctOptions);
    }

    @Override
    public FillTheBlank createFillTheBlank(String content, String correctAnswer) {
        return new FillTheBlank(content, correctAnswer);
    }

    @Override
    public EssayQuestion createEssayQuestion(String content) {
        return new EssayQuestion(content);
    }
}
