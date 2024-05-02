/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: ExamMemento.java
 * Description: Represents a memento for storing the state of an exam.
 */

package exammanagementsystem.exammanagement.exammemento;

import exammanagementsystem.exammanagement.ExamStatus;

public class ExamMemento {
    private ExamStatus status;

    // Constructs an ExamMemento object with the specified status.
    public ExamMemento(ExamStatus status) {
        this.status = status;
    }

    // Gets the status stored in the memento.
    public ExamStatus getStatus() {
        return status;
    }
}
