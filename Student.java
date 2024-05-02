/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: Student.java
 * Description: Represents a student enrolled in the exam management system.
 */

package exammanagementsystem.studentmanagement;

import exammanagementsystem.exammanagement.Exam;
import exammanagementsystem.exammanagement.ExamNotification;

import java.util.HashMap;
import java.util.Map;

public class Student implements ExamNotification {
    private String id;
    private String name;
    private boolean examPermission;
    private Map<String, String> answers;

    // Constructs a Student object with the specified ID and name.
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.examPermission = false;
        this.answers = new HashMap<>();
    }

    // Gets the ID and Name of the student.
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    // Checks if the student has permission to take exams.
    public boolean hasExamPermission() {
        return examPermission;
    }
    // Sets the exam permission for the student.
    public void setExamPermission(boolean examPermission) {
        this.examPermission = examPermission;
    }

    @Override
    public void update(Exam exam) {
        System.out.println("Received update from exam: " + exam.getName() + " status changed to " + exam.getStatus());
    }

    // Updates the student based on the exam status change.
    @Override
    public void notify(Exam exam) {
        System.out.println(name + " Received notification: " + exam.getName() + " status changed to " + exam.getStatus());
    }
}



