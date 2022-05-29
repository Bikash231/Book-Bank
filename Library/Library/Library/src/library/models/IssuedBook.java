package library.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IssuedBook implements Serializable {
  private final int id;
  private final String bookCallNumber;
  private final int studentId;
  private final String studentName;
  private final String studentContact;
  private final LocalDateTime dateIssued;

  public IssuedBook(int id, String bookCallNumber, int studentId, String studentName, String studentContact) {
    this.id = id;
    this.bookCallNumber = bookCallNumber;
    this.studentId = studentId;
    this.studentName = studentName;
    this.studentContact = studentContact;
    this.dateIssued = LocalDateTime.now();
  }

  public int getId() {
    return id;
  }

  public String getBookCallNumber() {
    return bookCallNumber;
  }

  public int getStudentId() {
    return studentId;
  }

  public String getStudentName() {
    return studentName;
  }

  public String getStudentContact() {
    return studentContact;
  }

  public LocalDateTime getDateIssued() {
    return dateIssued;
  }

  public String[] getData() {
    String date = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateIssued);
    return new String[] { String.valueOf(id), bookCallNumber, String.valueOf(studentId), studentName, studentContact, date };
  }

  public static String[] getColumns() {
    return new String[] { "ID", "BookCallNo", "Student ID", "Student Name", "Student Contact", "Date Issued" };
  }
}
