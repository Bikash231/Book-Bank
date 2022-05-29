package library.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Librarian implements Serializable {
  private final int id;
  private final String name;
  private final String password;
  private final String email;
  private final String address;
  private final String city;
  private final String contact;

  public Librarian(int id, String name, String password, String email, String address, String city, String contact) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.email = email;
    this.address = address;
    this.city = city;
    this.contact = contact;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }

  public String getCity() {
    return city;
  }

  public String getContact() {
    return contact;
  }

  public String[] getData() {
    return new String[] { String.valueOf(id), name, password, email, address, city, contact };
  }

  public static String[] getColumns() {
    return new String[] { "id", "name", "password", "email", "address", "city", "contact" };
  }
}
