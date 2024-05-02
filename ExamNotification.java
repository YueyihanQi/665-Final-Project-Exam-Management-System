/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 4/25/2024
 * File Name: ExamNotification.java
 * Description: Defines an interface for exam notifications.
 *              Using Observer pattern to notify.
 */

package exammanagementsystem.exammanagement;

public interface ExamNotification {

    // Updates the exam notification.
    void update(Exam exam);

    // Notifies about the exam status.
    void notify(Exam exam);
}
