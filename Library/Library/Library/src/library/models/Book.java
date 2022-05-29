package library.models;

import java.io.Serializable;

public class Book implements Serializable {
  private final int id;
  private final String callno;
  private final String name;
  private final String author;
  private final String publisher;
  private int issued;
  private int quantity;

  public Book(int id, String callno, String name, String author, String publisher, int quantity) {
    this.id = id;
    this.callno = callno;
    this.name = name;
    this.author = author;
    this.publisher = publisher;
    this.quantity = quantity;
  }

  public int getId() {
    return id;
  }

  public String getCallno() {
    return callno;
  }

  public String getName() {
    return name;
  }

  public String getAuthor() {
    return author;
  }

  public String getPublisher() {
    return publisher;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getIssued() {
    return issued;
  }

  public void setQuantity(final int quantity) {
    this.quantity = quantity;
  }

  public void setIssued(final int issued) {
    this.issued = issued;
  }

  public String[] getData() {
    return new String[] { String.valueOf(id), callno, name, author, publisher, String.valueOf(issued), String.valueOf(quantity) };
  }

  public static String[] getColumns() {
    return new String[] { "id", "callno", "name", "author", "publisher", "issued", "quantity" };
  }
}

