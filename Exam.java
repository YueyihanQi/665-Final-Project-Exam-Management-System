/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: Exam.java
 * Description: Exam class is responsible for creating individual exam
 * instances and providing management and operation for those instances.
 *
 * Provide Exam Information:
 * Provide basic information of the exam, such as exam category, status, etc.
 * Manage Exam Content:
 * Manage the question list of the exam, including adding questions, removing
 * questions and other operations.
 */

package exammanagementsystem.exammanagement;

import exammanagementsystem.exammanagement.examdecorator.ExamDecorator;
import exammanagementsystem.exammanagement.examdecorator.TimerDecorator;
import exammanagementsystem.exammanagement.exammemento.ExamMemento;
import exammanagementsystem.exammanagement.questionfactory.QuestionFactory;
import exammanagementsystem.exammanagement.questionfactory.QuestionProduct;
import exammanagementsystem.studentmanagement.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Exam {
    // Basic information of exam: name, category, exam status
    private String name;
    private Category category;
    private ExamStatus status;

    // Create question using exam factory
    private QuestionFactory questionFactory;
    private List<QuestionProduct> questions;

    private ExamMemento examMemento;
    public TimerDecorator timerDecorator;
    private List<ExamNotification> observers;

    // Construct function of Exam
    public Exam(String name, Category category, QuestionFactory questionFactory) {
        this.name = name;
        this.category = category;
        this.status = ExamStatus.NOT_STARTED;
        this.questionFactory = questionFactory;
        this.questions = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    // Registers an observer.
    public void registerObserver(ExamNotification observer) {
        observers.add(observer);
    }
    // Removes an observer.
    public void removeObserver(ExamNotification observer) {
        observers.remove(observer);
    }
    // Notifies all observers.
    public void notifyObservers() {
        for (ExamNotification observer : observers) {
            observer.notify(this);
        }
    }
    // Gets the name of the exam.
    public String getName() {
        return name;
    }
    // Modifies the exam status and notifies observers.
    public void setStatus(ExamStatus status) {
        this.status = status;
        notifyObservers();
    }
    // Gets the status of the exam.
    public ExamStatus getStatus() {
        return status;
    }

    // Gets the list of questions in the exam.
    public List<QuestionProduct> getQuestions() {
        return questions;
    }

    // Methods for creating different types of questions using the question factory.
    public void createSingleChoiceQuestion(String questionContent, String[] options, int correctOption) {
        addQuestion(questionFactory.createSingleChoice(questionContent, options, correctOption));
    }
    public void createMultipleChoiceQuestion(String questionContent, String[] options, int[] correctOptions) {
        addQuestion(questionFactory.createMultipleChoice(questionContent, options, correctOptions));
    }
    public void createFillTheBlankQuestion(String questionContent, String correctAnswer) {
        addQuestion(questionFactory.createFillTheBlank(questionContent, correctAnswer));
    }
    public void createEssayQuestion(String questionContent) {
        addQuestion(questionFactory.createEssayQuestion(questionContent));
    }

    // Adds a question to the exam.
    public void addQuestion(QuestionProduct question) {
        questions.add(question);
    }

    // Removes a question from the exam.
    public void removeQuestion(String questionName) {
        questions.removeIf(question -> question.getContent().equals(questionName));
    }

    // Grades the exam for a student.
    public int gradeExam(Student student, Map<QuestionProduct, Object> studentAnswers) {
        // Check if student has permission to take the exam
        if (student.hasExamPermission()) {
            int totalScore = 0;
            for (QuestionProduct question : questions) {
                Object answer = studentAnswers.get(question);
                if (answer != null && question.gradeAnswer(answer)) {
                    totalScore++;
                }
            }
            return totalScore;
        } else
            System.out.println(student.getName() + "don't have exam permission.");
        return 0;
    }

    // Methods for managing decorators and timer.
    // Adds a decorator to the exam.
    public void addDecorator(ExamDecorator decorator) {
        decorator.decorate();
    }
    // Starts the exam timer with the specified duration.
    public void startTimer(long duration) {
        timerDecorator = new TimerDecorator(duration);
        addDecorator(timerDecorator);
    }
    // Checks if the exam timer is running.
    public boolean isTimerRunning() {
        return timerDecorator != null && timerDecorator.isRunning();
    }
    //Stops the exam timer if it's running.
    public void stopTimer() {
        if (timerDecorator != null) {
            timerDecorator.stopTimer();
        }
    }

    // Methods for managing exam memento.
    // Gets the memento representing the current state of the exam.
    public ExamMemento getExamMemento() {
        return examMemento;
    }
    // Sets the state of the exam based on the provided memento.
    public void setExamMemento(ExamMemento examMemento) {
        this.examMemento = examMemento;
    }
    // Saves the current state of the exam to a memento.
    public ExamMemento saveToMemento() {
        return new ExamMemento(status);
    }
    // Restores the state of the exam from a memento.
    public void restoreFromMemento(ExamMemento memento) {
        status = memento.getStatus();
    }


}
