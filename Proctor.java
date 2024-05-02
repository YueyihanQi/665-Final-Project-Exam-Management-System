/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: Proctor.java
 * Description: Represents a proctor responsible for managing exams.
 */

package exammanagementsystem.proctormanagement;

import exammanagementsystem.exammanagement.Exam;
import exammanagementsystem.exammanagement.ExamNotification;
import exammanagementsystem.exammanagement.ExamStatus;
import exammanagementsystem.exammanagement.exammemento.ExamMemento;

public class Proctor implements ExamNotification {
    private String name;
    private ExamMemento memento;

    // Attribute to store the current exam status
    private Exam currentExam;

    // Constructs a Proctor object with the specified name.
    public Proctor(String name) {
        this.name = name;
    }

    // Starts the exam and updates its status to in progress.
    public void startExam(Exam exam) {
        System.out.println("Exam started by proctor " + name);
        exam.setStatus(ExamStatus.IN_PROGRESS);
        this.currentExam = exam;
        saveExamMemento(exam);
    }

    // Ends the exam and updates its status to finished.
    public void endExam(Exam exam) {
        System.out.println("Exam ended by proctor " + name);
        exam.setStatus(ExamStatus.FINISHED);
        // Clear the current exam status
        this.currentExam = null;
        saveExamMemento(exam);
    }

    private void saveExamMemento(Exam exam) {
        memento = exam.saveToMemento();
    }

    public void restoreExamStatus(Exam exam) {
        if (memento != null) {
            exam.restoreFromMemento(memento);
        }
    }

    public ExamMemento getCurrentMemento() {
        return memento;
    }

    // Updates the proctor based on the exam status.
    @Override
    public void update(Exam exam) {
        ExamStatus status = exam.getStatus();
        if (status == ExamStatus.NOT_STARTED) {
            startExam(exam);
        } else if (status == ExamStatus.IN_PROGRESS) {
            endExam(exam);
        }
    }

    // Notifies the proctor about the exam status change.
    @Override
    public void notify(Exam exam) {
        System.out.println("Proctor " + name + " received notification: Exam status changed to " + exam.getStatus());
    }

    // Gets the current exam being managed by the proctor.
    public Exam getCurrentExam() {
        return currentExam;
    }
}
